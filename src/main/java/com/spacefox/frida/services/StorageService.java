package com.spacefox.frida.services;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    boolean save(MultipartFile file);

    boolean delete(String filename);

    Path loadPath(String filename);

    boolean exist(String fileName);

    FileInputStream download(String filename);

    long size(String filename);

}
