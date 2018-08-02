package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.NewsDTO;
import com.spacefox.frida.services.NewsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NewsController.class, secure = false)
public class NewsControllerTest {

    @MockBean
    private NewsServiceImpl newsService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void retriveLastNews() throws Exception {

        NewsDTO mockNews = new NewsDTO();
        mockNews.setTitle("mockTiltle");
        mockNews.setBody("mockBody");
        mockNews.setPicture("mock.jpg");
        mockNews.setId(1L);


        Mockito.when(newsService.convert(newsService.getById(Mockito.anyLong()))).thenReturn(mockNews);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/news/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("\nRESULT: " + result.getResponse().getContentAsString());
        String expected = "{id:1,picture:mock.jpg,title:mockTiltle,body:mockBody,publicationDate:null}";


        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);

    }

}
