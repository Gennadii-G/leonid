package com.spacefox.frida.services;

import com.spacefox.frida.domain.PictureJH;
import com.spacefox.frida.repository.PictureJHRepository;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

@Service
@NoArgsConstructor
@Slf4j
public class FSPictureStorageService implements StorageService {

    private Path targetDir;
    @Value("${pictures.dir.name}")
    private String dirName;
    private String fullDirPath;
    @Autowired
    private PictureJHRepository pictureRepository;

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
            @Cleanup InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, this.targetDir.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            genMetadata(filename);
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
                delMetadata(filename);
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
    public Path download(String filename) {
        log.debug("Процесс выгрузки файла: " + filename);
        return path(filename);

    }

    @Override
    public long size(String filename) {
        long size = 0;
        try {
            Path p = this.targetDir.resolve(filename);
            size =  Files.size(p);
        }catch(IOException e){
            log.error("ошибка проверки размера файла " + filename);
            e.printStackTrace();
        }
        return size;
    }

    private void genMetadata(String filename) {
        if(exist(filename)) {
            PictureJH pic = new PictureJH();
            pic.setSize(size(filename));
            pic.setFilename(filename);
            pic.setKey(filename);
            pic.setWhenSaved(LocalDateTime.now());
            pictureRepository.save(pic);
        }
    }

    private void delMetadata(String filename) throws IOException {
        PictureJH pic = pictureRepository.findByKey(filename).orElse(null);
        if(!exist(filename) && pic != null) {
            pictureRepository.deleteFileDataByKey(filename);
        }
    }

    @Override
    public boolean exist(String fileName) {
        return Files.exists(this.targetDir.resolve(fileName));
    }


    @Override
    public List<PictureJH> getAllInfo() {
        return pictureRepository.findAll();
    }
}
