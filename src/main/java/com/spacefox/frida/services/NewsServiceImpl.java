package com.spacefox.frida.services;

import com.spacefox.frida.domain.News;
import com.spacefox.frida.repository.NewsRepository;
import com.spacefox.frida.domain.DTO.NewsDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<News> getLastNews() {
        return repository
                .findFirst4ByPublicationDateNotNullOrderByPublicationDateDesc();
    }

    @Override
    public List<News> getAll() {
        return repository.findAll();
    }

    @Override
    public News save(News news) {
        return repository.save(news);
    }

    @Override
    public boolean save(NewsDTO newsDTO) {
        News news = mapper.map(newsDTO, News.class);
        news.setCreatedDate(LocalDate.now());
        news = repository.save(news);
        return repository.existsById(news.getId());
    }

    @Override
    public NewsDTO getDTO(News news) {
        NewsDTO newsDTO = mapper.map(news, NewsDTO.class);
        return mapper.map(news, NewsDTO.class);
    }

    @Override
    public List<NewsDTO> getDTO(List<News> news) {
        return news.stream().map(this::getDTO).collect(Collectors.toList());
    }

    @Override
    public News getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public NewsDTO getDTOById(long id) {
        News news = repository.getOne(id);
        return mapper.map(news, NewsDTO.class);
    }

    @Override
    public NewsDTO delete(NewsDTO dto) {
        News news = mapper.map(dto, News.class);
          repository.delete(news);
        return dto;
    }
}