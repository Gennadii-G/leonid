package com.spacefox.frida.utils;

import com.spacefox.frida.domain.Domenko;
import com.spacefox.frida.domain.PictureJH;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Slf4j
public class Test {

    public static void main(String[] args) {
        int r3 = 1 + 1;

        Domenko dom = new Domenko();
        dom.setYes(true);
        dom.setName("test");
        dom.setNumber(3);

        ModelMapper mapper = new ModelMapper();

        PictureJH pic = new PictureJH();
        pic.setFilename("fileName2222");
        pic.setSize(3000000);
    }
}
