package com.spacefox.frida.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//REBuilder
public class REBuilder {

    public static ResponseEntity badResponse(String body){
        return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity okResponse(String body){
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
