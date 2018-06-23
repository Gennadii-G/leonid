package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.Domenko;
import org.springframework.web.bind.annotation.*;

@RestController("/homy")
public class HomeController {

    @GetMapping("/homy")
    public Domenko domenko() {
        Domenko dome = new Domenko();
        dome.setName("hello");
        dome.setNumber(123);
        dome.setYes(true);

        return dome;
    }

}
