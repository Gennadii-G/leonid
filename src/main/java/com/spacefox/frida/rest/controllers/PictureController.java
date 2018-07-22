package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.adapter.RestPictureAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class PictureController {

    @Autowired
    private RestPictureAdapter pictureAdapter;

    @GetMapping("/picture/{filename}")
    public Resource loadPicture(@PathVariable String filename){
        return pictureAdapter.loadPicture(filename);
    }

    @PostMapping("/picture/add")
    public ResponseEntity<?> savePicture(@RequestParam("uploadPicture") MultipartFile file) {
        return pictureAdapter.savePicture(file);
    }

    @GetMapping("/picture/download/{filename}")
    public ResponseEntity downloadPicture(@PathVariable String filename, HttpServletResponse response){
        return pictureAdapter.downloadPicture(filename);
    }

    @DeleteMapping("/picture/delete/{filename}")
    public ResponseEntity deletePicture(@PathVariable String filename){
        return pictureAdapter.deletePicture(filename);
    }
}
