package com.spacefox.frida.repository;

import com.spacefox.frida.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findFirst4ByPublicationDateNotNullOrderByPublicationDateDesc();

}
