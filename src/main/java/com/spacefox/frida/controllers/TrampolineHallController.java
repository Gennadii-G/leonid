package com.spacefox.frida.controllers;


import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/trampolineHalls")
public class TrampolineHallController {

    @Autowired
    private TrampolineHallService service;
    private String page = "trampolineHalls";

    @GetMapping
    public String generalHallsPage(Model model){
        model.addAttribute("halls", service.getAll());
        return page;
    }
}
