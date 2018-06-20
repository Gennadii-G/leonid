package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.services.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/news")
@Slf4j
public class NewsController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/pictures/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> pictureFile(@PathVariable String filename){

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/api/upload")
    // If not @RestController, uncomment this
    //@ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        log.debug("загрузка файла " + file.getOriginalFilename());

        if (file.isEmpty()) {
            return new ResponseEntity<>("please select a file!", HttpStatus.OK);
        }

        try {
            storageService.save(file);
        } catch (IOException e) {
            log.error("Ошибка при сохранении файла " + file.getName());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("успешно загружен - " +
                file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }
}
