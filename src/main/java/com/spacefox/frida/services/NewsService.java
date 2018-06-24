package com.spacefox.frida.services;

import com.spacefox.frida.domain.News;
import com.spacefox.frida.rest.DTO.NewsDTO;

import java.util.List;

public interface NewsService {

    List<News> getLastNews();

    List<News> getAll();

    void save(News news);

    void save(NewsDTO newsDTO);

    NewsDTO getDTO(News news);

    List<NewsDTO> getDTO(List<News> news);
}
