package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.inmemdb.DataHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GeneralController {

    private DataHall dataHall;

    @Autowired
    public GeneralController(DataHall dataHall) {
        this.dataHall = dataHall;
    }

    @GetMapping
    public String main(ModelMap model){
        int freeTrampolinesAmount = dataHall.getHalls().stream().mapToInt(TrampolineHall::freeTramps).sum();
        model.addAttribute("freeTrampolinesAmount", freeTrampolinesAmount);
        return "index";
    }
}
