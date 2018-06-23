package com.spacefox.frida.adapter;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface  RestPictureAdapter {


    ResponseEntity savePicture(MultipartFile file);

    public Resource loadPicture(String filename);

    public ResponseEntity downloadPicture(String filename);

    public ResponseEntity deletePicture(String filename);
}
