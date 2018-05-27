package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.layout.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GeneralController {

    private TrampolineHallService hallService;

    @Autowired
    public GeneralController(TrampolineHallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    public String main(ModelMap model){
        int freeTrampolinesAmount = hallService.getAll().stream().mapToInt(TrampolineHall::freeTramps).sum();
        model.addAttribute("freeTrampolinesAmount", freeTrampolinesAmount);
        return "index";
    }
}
