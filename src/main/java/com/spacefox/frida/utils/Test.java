package com.spacefox.frida.utils;

import com.spacefox.frida.domain.PictureJH;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Slf4j
public class Test {

    public static void main(String[] args) {
        int r3 = 1 + 1;

        ModelMapper mapper = new ModelMapper();

        PictureJH pic = new PictureJH();
        pic.setFilename("fileName2222");
        pic.setSize(3000000);
    }
}
