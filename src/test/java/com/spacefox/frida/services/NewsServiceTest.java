package com.spacefox.frida.services;

import com.spacefox.frida.domain.News;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class NewsServiceTest {

    @Autowired
    private NewsService newsService;

    public void testCreateAndFindNews(){
        News news = new News();
        news.setBody("testBody");
        news.setCreatedDate(LocalDate.now());
        news.setPicture("abc.jpg");
        news.setPublicationDate(LocalDateTime.now().plusDays(1));
        news.setTitle("testTitle");
        newsService.save(news);

        List<News> found = newsService.getAll();

        assertFalse(found.isEmpty());
    }

}
