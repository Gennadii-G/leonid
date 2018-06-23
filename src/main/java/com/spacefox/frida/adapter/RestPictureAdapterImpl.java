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

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
@Slf4j
public class RestPictureAdapterImpl implements RestPictureAdapter{

    @Autowired
    private StorageService storageService;

    public ResponseEntity savePicture(MultipartFile file){
        boolean isSave = storageService.save(file);
        return isSave ? okResponse("Файл сохранен") : badResponse("Ошибка сохранения");
    }

    public Resource loadPicture(String filename) {
        Resource res = null;
        Path pic = storageService.path(filename);
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
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        try {
            InputStream in = storageService.download(filename);
            InputStreamResource resource = new InputStreamResource(in);
            if (resource.exists() || resource.isReadable()) {
                responseEntity = ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION)
                        .contentLength(storageService.size(filename))
                        .contentType(MediaType.parseMediaType("application/octet-stream"))
                        .body(resource);
            }
        }catch(FileNotFoundException e) {
            log.error("файл не найден");
            e.printStackTrace();
        }
        return responseEntity;
    }

    public ResponseEntity deletePicture(String filename) {
        ResponseEntity resp;
        boolean isDelete = storageService.delete(filename);
        if(!storageService.exist(filename)){
            resp = badResponse("Файл с таким именем не найден");
        }else if(storageService.delete(filename)) {
            resp = okResponse("Файл удален");
        }else {
            resp = badResponse("Ошибка удаления");
        }
        return resp;
    }

    private ResponseEntity badResponse(String body){
        return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity okResponse(String body){
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }



}
