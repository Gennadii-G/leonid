package com.spacefox.frida.rest.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.spacefox.frida.domain.DTO.Transfer;
import com.spacefox.frida.domain.News;
import com.spacefox.frida.domain.DTO.NewsDTO;
import com.spacefox.frida.services.NewsService;
import com.spacefox.frida.utils.REBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired

    @JsonView(Transfer.Info.class)
    @GetMapping("/news/all")
    public List<NewsDTO> getAllNews(){
        List<News> news = newsService.getAll();
        return newsService.getDTO(news);
    }

    @GetMapping("/news")
    public List<NewsDTO> getFreshNews(){
        List<News> news = newsService.getLastNews();
        return newsService.getDTO(news);
    }

    @PostMapping("/news/add")
    public ResponseEntity postNews(@ModelAttribute NewsDTO newsDTO, BindingResult bindingResult){
        newsService.save(newsDTO);
        return REBuilder.okResponse("новость сохранена");
    }

    @JsonView({Transfer.Update.class, Transfer.Info.class})
    @GetMapping("/news/{id}")
    public NewsDTO getNewsForUpdate(@PathVariable long id){
        return newsService.getDTOById(id);
    }

    @PostMapping("/news/update")
    public ResponseEntity updateNews(@ModelAttribute @Valid NewsDTO newsDTO, BindingResult bindingResult) {
        ResponseEntity resp = REBuilder.okResponse("новость сохранена");
        boolean isSave = newsService.save(newsDTO);
        if(!isSave){
            resp = REBuilder.badResponse("ошибка сохранения");
        }
        return resp;
    }
}
