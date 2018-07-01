package com.spacefox.frida.services;

import com.spacefox.frida.domain.News;
import com.spacefox.frida.domain.DTO.NewsDTO;

import java.util.List;

public interface NewsService {

    List<News> getLastNews();

    List<News> getAll();

    News getById(long id);

    NewsDTO getDTOById(long id);

    News save(News news);

    boolean save(NewsDTO newsDTO);

    NewsDTO getDTO(News news);

    List<NewsDTO> getDTO(List<News> news);

    NewsDTO delete(NewsDTO dto);
}
