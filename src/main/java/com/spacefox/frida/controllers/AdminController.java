package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import com.spacefox.frida.services.TrampolineHallService;
import com.spacefox.frida.utils.factory.TrampolineHallBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private String page = "adminpanel";

    @Autowired
    private TrampolineHallService hallService;

    @GetMapping
    public String get(ModelAndView model,
                      @ModelAttribute(name = "hall") TrampolineHall hall){

        return page;
    }

    @PostMapping
    public String post(ModelAndView model,
                       @ModelAttribute(name = "hall") TrampolineHall hall,
                       @RequestParam("trampsAmount") int trAmount){

        hallService.save(hall, trAmount);
        return page;
    }
}
