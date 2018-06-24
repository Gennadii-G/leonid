package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.News;
import com.spacefox.frida.rest.DTO.NewsDTO;
import com.spacefox.frida.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired

    @GetMapping("/news/all")
    public List<NewsDTO> getAllNews(){
        List<News> news = newsService.getAll();
        return newsService.getDTO(news);
    }

    @GetMapping("/news/current")
    public List<NewsDTO> getFreshNews(){
        List<News> news = newsService.getLastNews();
        return newsService.getDTO(news);
    }

    @PostMapping("/news/save")
    public ResponseEntity postNews(@ModelAttribute NewsDTO newsDTO, BindingResult bindingResult){
        newsService.save(newsDTO);
        return new ResponseEntity<String>("новость сохранена", HttpStatus.OK);
    }
}
