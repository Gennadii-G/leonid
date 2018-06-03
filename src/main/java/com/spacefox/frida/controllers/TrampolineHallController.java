package com.spacefox.frida.controllers;


import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

//      todo позже удалить
//    @RequestMapping(value = "/{hallid}", method = RequestMethod.GET)
//    public String getInformationHall(Model model, @PathVariable("hallid") String hallid){
//        TrampolineHall hall = service.getByName(hallid);
//        model.addAttribute("id", hallid);
//        model.addAttribute("hall", hall);
//        return "infohall";
//    }
}
