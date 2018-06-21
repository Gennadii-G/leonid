package com.spacefox.frida.adapter;

import com.spacefox.frida.services.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
@Slf4j
public class RestPictureAdapter {

    @Autowired
    private StorageService storageService;

    public ResponseEntity savePicture(MultipartFile file){
        boolean isSave = storageService.save(file);
        return isSave ? goodResponse("Файл сохранен") : badResponse("Ошибка сохранения");
    }

    public Resource loadPicture(String filename) {
        Resource res = null;
        Path pic = storageService.loadPath(filename);
        if(pic != null){
            try {
                res = new UrlResource(pic.toUri());
            }catch (MalformedURLException e) {
                log.error("Некорректное указание файла " + filename);
                log.error(e.getCause().toString());
                res = null;
            }
        }
        return res;
    }

    public ResponseEntity downloadPicture(String filename){
        ResponseEntity responseEntity;
        InputStream in = storageService.download(filename);
        InputStreamResource resource = new InputStreamResource(in);
        if (resource.exists() || resource.isReadable()) {
            responseEntity = ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION)
                    .contentLength(storageService.size(filename))
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);
        }else{
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    public ResponseEntity deletePicture(String filename){
        boolean isDelete = storageService.delete(filename);
        return isDelete ? goodResponse("Файл удален") : badResponse("Ошибка удаления");
    }

    private ResponseEntity badResponse(String body){
        return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity goodResponse(String body){
        return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
    }



}
