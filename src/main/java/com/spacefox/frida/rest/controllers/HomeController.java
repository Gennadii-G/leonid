package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.Domenko;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HomeController {

    @GetMapping
    public Domenko domenko() {
        Domenko dome = new Domenko();
        dome.setName("hello");
        dome.setNumber(123);
        dome.setYes(true);

        return dome;
    }


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/zx")
    public @ResponseBody
    Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));

    }
}
