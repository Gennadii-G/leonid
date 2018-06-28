package com.spacefox.frida.adapter;

import com.spacefox.frida.services.StorageService;
import com.spacefox.frida.utils.REBuilder;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
@Slf4j
public class RestPictureAdapterImpl implements RestPictureAdapter {

    @Autowired
    private StorageService storageService;

    public ResponseEntity savePicture(MultipartFile file){
        boolean isSave = storageService.save(file);
        return isSave ?
                REBuilder.okResponse("Файл сохранен") :
                REBuilder.badResponse("Ошибка сохранения");
    }

    @Override
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

    @Override
    public ResponseEntity downloadPicture(String filename){
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);

        try {
            File file = storageService.download(filename).toFile();
            InputStream in = new FileInputStream(file);
            InputStreamResource resource = new InputStreamResource(in);

            if (resource.exists() || resource.isReadable()) {
                responseEntity = ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION)
                        .contentLength(storageService.size(filename))
                        .contentType(MediaType.parseMediaType("application/octet-stream"))
                        .body(resource);
            }
        }catch(IOException e) {
            log.error("Ошибка загрузки файла " + filename);
            e.printStackTrace();
        }
        return responseEntity;

    }

    @Override
    public ResponseEntity deletePicture(String filename) {
        ResponseEntity resp;
        boolean isDelete = storageService.delete(filename);
        if(!storageService.exist(filename)){
            resp = REBuilder.badResponse("Файл с таким именем не найден");
        }else if(storageService.delete(filename)) {
            resp = REBuilder.okResponse("Файл удален");
        }else {
            resp = REBuilder.badResponse("Ошибка удаления");
        }
        return resp;
    }

}
