package com.spacefox.frida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recordsManagement")
public class RecordsManagementController {

    @GetMapping
    public String get(){
        return "recordsManagement";
    }

}
