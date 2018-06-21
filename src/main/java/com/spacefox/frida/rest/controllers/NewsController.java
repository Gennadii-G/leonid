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
    public ResponseEntity<Resource> loadPicture(@PathVariable String filename){
        Resource file = null;
        ResponseEntity<Resource> responseEntity;
        try {
            file = storageService.load(filename);
            responseEntity = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        } catch (IOException e) {
            log.error("ошибка при загрузке файла "+ filename);
            e.printStackTrace();
            responseEntity = new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/pictures/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("uploadPicture") MultipartFile file) {
        return storageService.save(file);
    }

//    @GetMapping("/pictures/download/{filename}")
//    public ResponseEntity<Resource> downloadPicture(@PathVariable String filename){
//        return storageService.download(filename);
//
//        ResponseEntity<Resource> responseEntity;
//        try {
//            responseEntity = storageService.download(filename);
//        } catch (IOException e) {
//            log.error("ошибка при загрузке файла "+ filename);
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<Resource>(HttpStatus.BAD_REQUEST);
//        }
//        return responseEntity;
//    }

}
