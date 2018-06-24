package com.spacefox.frida.services;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {

    boolean save(MultipartFile file);

    boolean delete(String filename);

    Path path(String filename);

    boolean exist(String fileName);

    Path download(String filename);

    int size(String filename);

}
