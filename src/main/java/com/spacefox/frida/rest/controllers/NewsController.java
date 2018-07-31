package com.spacefox.frida.rest.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.spacefox.frida.domain.DTO.NewsDTO;
import com.spacefox.frida.domain.News;
import com.spacefox.frida.services.NewsService;
import com.spacefox.frida.utils.REBuilder;
import com.spacefox.frida.utils.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @JsonView(Transfer.Update.class)
    @GetMapping("/news/all")
    public List<NewsDTO> allNews() {
        List<News> news = newsService.getAll();
        return newsService.convert(news);
    }

    @JsonView(Transfer.Info.class)
    @GetMapping("/news")
    public List<NewsDTO> currentNews(){
        List<News> news = newsService.getLastNews();
        return newsService.convert(news);
    }

    @JsonView({Transfer.Update.class, Transfer.Info.class})
    @PostMapping("/news/add")
    public ResponseEntity postNews(@RequestBody @Valid NewsDTO newsDTO){
        newsService.save(newsService.convert(newsDTO));
        return REBuilder.okResponse("новость сохранена");
    }

    @JsonView({Transfer.Update.class})
    @GetMapping("/news/{id}")
    @ResponseBody
    public NewsDTO getNewsForUpdate(@PathVariable long id) {
        News news = newsService.getById(id);
        return newsService.convert(news);
    }


    @JsonView({Transfer.Update.class})
    @PutMapping("/news/update")
    public ResponseEntity updateNews(@RequestBody @Valid NewsDTO newsDTO) {
        ResponseEntity resp = REBuilder.okResponse("новость сохранена");
        boolean isSave = newsService.update(newsService.convert(newsDTO));
        if(!isSave){
            resp = REBuilder.badResponse("ошибка сохранения");
        }
        return resp;
    }

    @JsonView({Transfer.Update.class})
    @DeleteMapping("/news/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getNewsForUpdate(@PathVariable Long id){
        newsService.delete(id);
    }
}
