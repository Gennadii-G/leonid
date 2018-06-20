package com.spacefox.frida.services;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@NoArgsConstructor
@Slf4j
public class PictureStorageService implements StorageService {

    private Path targetDir;
    @Value("${pictures.dir.name}")
    private String dirName;
    private final String FULL_DIR_NAME = System.getProperty("user.dir") + dirName;


    @Override
    @PostConstruct
    public void init() {
        targetDir = Paths.get(FULL_DIR_NAME);
        if(Files.notExists(targetDir)){
            try {
                Files.createDirectories(targetDir);
                log.info("Создана директория картинок: " + targetDir);
            } catch (IOException e) {
                log.error("Ошибка создания директории картинок");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
            if (file.isEmpty()) {
                log.warn("файл пуст: " + filename);
                throw new IOException();
            }
            if (filename.contains("..")) {
                log.warn("нельзя использовать относительный путь при загрузке файла " + filename);
                throw new IOException();
            }
            @Cleanup InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, this.targetDir.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public boolean delete(String filename) {
        boolean res = false;
        try {
            Path pic = this.targetDir.resolve(filename);
            log.debug("Удаление файла " + pic.getFileName());
            if(Files.exists(pic)) {

                Files.delete(pic);
                log.info("файл удален");
                res = true;
            }
        } catch (IOException e) {
            log.error("ошибка удаления файла");
            e.printStackTrace(); }
        return res;
    }

    @Override
    public Resource load(String filename) throws IOException {
        log.debug("Процесс чтения файла: " + filename);
        try {
            Path pic = this.targetDir.resolve(filename);
            Resource resource = new UrlResource(pic.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                log.error("Ошибка чтения файла: " + filename);
                throw new FileNotFoundException();
            }
        }
        catch (MalformedURLException e) {
            log.error("Некорректное указание файла " + filename);
            log.error(e.getCause().toString());
            throw e;
        }
    }

    @Override
    public boolean exist(String fileName) {
        return Files.exists(this.targetDir.resolve(fileName));
    }

}
