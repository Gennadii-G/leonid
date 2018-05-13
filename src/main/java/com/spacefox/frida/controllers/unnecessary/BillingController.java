package com.spacefox.frida.controllers.unnecessary;


import com.spacefox.frida.layout.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BillingController {

    TrampolineHallService hallDao;

    @Autowired
    public BillingController(TrampolineHallService hallDao) {
        this.hallDao = hallDao;
    }

    @RequestMapping(value="/billing/{hallid}")
    public String startBilling(Model model, @PathVariable("hallid")String hallid){
        model.addAttribute("hall", hallDao.getByName(hallid));
        return "billing";
    }
}
