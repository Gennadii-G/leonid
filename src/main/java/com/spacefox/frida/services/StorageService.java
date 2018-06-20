package com.spacefox.frida.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void save(MultipartFile file) throws IOException;

    boolean delete(String filename);

    Resource load(String filename) throws IOException;

    boolean exist(String fileName);

}
