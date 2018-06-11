package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.repository.TrampolineHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GeneralController {

    @Autowired
    private TrampolineHallRepository hallRepository;
    private String page = "index";

    @GetMapping
    public String main(ModelMap model){
//        int freeTrampolinesAmount = hallRepository.findAll().stream().mapToInt(TrampolineHall::freeTrampsAmount).sum();
//        model.addAttribute("freeTrampolinesAmount", freeTrampolinesAmount);
        model.addAttribute("perm", "12");
        model.addAttribute("localPerm", "12");
        return page;
    }
}
