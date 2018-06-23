package com.spacefox.frida.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Paths;

@Slf4j
public class Test {

    public static void main(String[] args) {
        int r3 = 1 + 1;
        log.error(Paths.get(System.getProperty("user.dir") + "/pictures").toString());
    }

}
