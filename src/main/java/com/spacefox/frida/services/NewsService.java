package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.NewsDTO;
import com.spacefox.frida.domain.News;
import com.spacefox.frida.domain.PictureJH;

import java.util.List;

public interface NewsService {

    List<News> getLastNews();

    List<News> getAll();

    News getById(long id);

    boolean save(News news);

    boolean update(News news);

    NewsDTO convert(News news);

    News convert(NewsDTO dto);

    List<NewsDTO> convert(List<News> news);

    NewsDTO delete(NewsDTO dto);

    void delete(Long id);
}
