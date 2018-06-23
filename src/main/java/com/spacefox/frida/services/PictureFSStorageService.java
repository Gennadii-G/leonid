package com.spacefox.frida.services;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@NoArgsConstructor
@Slf4j
public class PictureFSStorageService implements StorageService {

    private Path targetDir;
    @Value("${pictures.dir.name}")
    private String dirName;
    private String fullDirPath;

    @PostConstruct
    private void init() {
        fullDirPath = System.getProperty("user.dir") + dirName;
        targetDir = Paths.get(fullDirPath);
        if(Files.notExists(targetDir)){
            try {
                Files.createDirectories(targetDir);
                log.info("Создана директория изображений: " + targetDir);
            } catch (IOException e) {
                log.error("Ошибка создания директории изображений");
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean save(MultipartFile file) {
        log.debug("сохранение файла");
        boolean res = false;
        String filename = "";
        try{
            if(file.isEmpty()){
                log.warn("файл пуст");
                throw new IOException();
            }
            filename = file.getOriginalFilename();
            if (filename.contains("..")) {
                log.warn("нельзя использовать относительный путь при загрузке файла " + filename);
                throw new IOException();
            }
            filename = file.getOriginalFilename();
            @Cleanup InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, this.targetDir.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            res = true;
        } catch(IOException e) {
            log.error("Ошибка сохранения файла " + filename);
            e.printStackTrace();
        }
        return res;
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
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Path path(String filename) {
        log.debug("Чтение файла: " + filename);
        Path pic;
        pic = this.targetDir.resolve(filename);
        if(!Files.exists(pic) || !Files.isReadable(pic)) {
            log.error("Ошибка чтения файла: " + filename);
            pic = null;
        }
        return pic;
    }

    @Override
    public FileInputStream download(String filename) throws FileNotFoundException {
        log.debug("Процесс выгрузки файла: " + filename);
        try {
            Path pic = this.targetDir.resolve(filename);
            @Cleanup FileInputStream in = new FileInputStream(pic.toFile());
            return in;
        }
        catch (IOException e) {
            log.error("Ошибка выгрузки файла " + filename);
            e.printStackTrace();
            throw new FileNotFoundException();
        }
    }

    @Override
    public long size(String filename) {
        long size = 0;
        try {
            Path p = this.targetDir.resolve(filename);
            size = Files.size(p);
        }catch(IOException e){
            log.error("ошибка проверки размера файла " + filename);
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public boolean exist(String fileName) {
        return Files.exists(this.targetDir.resolve(fileName));
    }

}
