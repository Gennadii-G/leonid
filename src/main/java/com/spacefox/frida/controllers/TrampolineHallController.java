package com.spacefox.frida.controllers;


import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.layout.TrampolineHallService;
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

    private TrampolineHallService hallDao;

    @Autowired
    public TrampolineHallController(TrampolineHallService hallDao) {
        this.hallDao = hallDao;
    }

    @GetMapping
    public String generalHallsPage(Model model){
        model.addAttribute("halls", hallDao.getAll());
        return "trampolineHalls";
    }

    @RequestMapping(value = "/{hallid}", method = RequestMethod.GET)
    public String getInformationHall(Model model, @PathVariable("hallid") String hallid){
        TrampolineHall hall = hallDao.getByName(hallid);
        model.addAttribute("id", hallid);
        model.addAttribute("hall", hall);
        return "infohall";
    }
}
