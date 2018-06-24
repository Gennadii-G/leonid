package com.spacefox.frida.adapter;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface  RestPictureAdapter {


    ResponseEntity savePicture(MultipartFile file);

    Resource loadPicture(String filename);

    ResponseEntity downloadPicture(String filename);

    ResponseEntity deletePicture(String filename);
}
