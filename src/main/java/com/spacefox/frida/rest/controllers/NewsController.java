package com.spacefox.frida.rest.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.spacefox.frida.domain.DTO.NewsDTO;
import com.spacefox.frida.domain.News;
import com.spacefox.frida.services.NewsService;
import com.spacefox.frida.utils.REBuilder;
import com.spacefox.frida.utils.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @JsonView(Transfer.Info.class)
    @GetMapping("/news/all")
    public List<NewsDTO> addNews(){
        List<News> news = newsService.getAll();
        return newsService.getDTO(news);
    }

    @JsonView(Transfer.Info.class)
    @GetMapping("/news")
    public List<NewsDTO> currentNews(){
        List<News> news = newsService.getLastNews();
        return newsService.getDTO(news);
    }

    @JsonView({Transfer.Update.class, Transfer.Info.class})
    @PostMapping("/news/add")
    public ResponseEntity postNews(@Valid NewsDTO newsDTO){
        newsService.save(newsDTO);
        return REBuilder.okResponse("новость сохранена");
    }

    @JsonView({Transfer.Update.class})
    @GetMapping("/news/{id}")
    @ResponseBody
    public NewsDTO getNewsForUpdate(@PathVariable long id){
        return newsService.getDTOById(id);
    }


    @JsonView({Transfer.Update.class})
    @PutMapping("/news/update")
    public ResponseEntity updateNews(@Valid NewsDTO newsDTO) {
        ResponseEntity resp = REBuilder.okResponse("новость сохранена");
        boolean isSave = newsService.save(newsDTO);
        if(!isSave){
            resp = REBuilder.badResponse("ошибка сохранения");
        }
        return resp;
    }

    @JsonView({Transfer.Update.class})
    @DeleteMapping("/news/delete")
    @ResponseBody
    public NewsDTO getNewsForUpdate(NewsDTO newsDTO){
        return newsService.delete(newsDTO);
    }
}
