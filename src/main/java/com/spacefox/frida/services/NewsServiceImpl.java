package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.NewsDTO;
import com.spacefox.frida.domain.News;
import com.spacefox.frida.domain.PictureJH;
import com.spacefox.frida.repository.NewsRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public boolean save(News news) {
        news.setCreatedDate(LocalDate.now());
        news.setId(null);
        news = repository.save(news);
        return repository.existsById(news.getId());
    }

    @Override
    public boolean update(News news) {
        if(repository.existsById(news.getId())){
            News orig = repository.getOne(news.getId());
            news.setCreatedDate(orig.getCreatedDate());
            news = repository.save(news);
        }
        return repository.existsById(news.getId());
    }

    @Override
    public NewsDTO convert(News news) {
        return mapper.map(news, NewsDTO.class);
    }

    @Override
    public News convert(NewsDTO dto) {
        return mapper.map(dto, News.class);
    }

    @Override
    public List<NewsDTO> convert(List<News> news) {
        return news.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public News getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public NewsDTO delete(NewsDTO dto) {
        News news = mapper.map(dto, News.class);
        if(repository.existsById(news.getId())){
            repository.delete(news);
        }
        return dto;
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}