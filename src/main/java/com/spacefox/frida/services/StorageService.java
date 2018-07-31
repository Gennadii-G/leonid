package com.spacefox.frida.services;

import com.spacefox.frida.domain.PictureJH;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface StorageService {

    boolean save(MultipartFile file);

    boolean delete(String filename);

    Path path(String filename);

    boolean exist(String fileName);

    Path download(String filename);

    long size(String filename);

    List<PictureJH> getAllInfo();


}
