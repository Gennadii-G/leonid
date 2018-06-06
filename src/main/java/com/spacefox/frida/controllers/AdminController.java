package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.services.DiscountService;
import com.spacefox.frida.services.TrampolineHallService;
import org.slf4j.Logger;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final String page = "admin";
//    private Logger logger = new L

    @Autowired
    private TrampolineHallService hallService;
    @Autowired
    private DiscountService discountService;

//  <<--  hall  -->>
    @GetMapping
    public String getAdm(ModelAndView model,
                          @ModelAttribute(name = "hall") TrampolineHall hall,
                          @ModelAttribute(name = "discount") Discount discount){
        return page;
    }

    @PostMapping("/addHall")
    public String postHall(ModelAndView model,
                           @ModelAttribute(name = "hall") TrampolineHall hall,
                           @RequestParam("trampsAmount") int trAmount){
        hallService.save(hall, trAmount);
        return "redirect:/trampolineHalls";
    }

    @PostMapping("/addDiscount")
    public String postDiscount(ModelAndView model, @ModelAttribute(name = "discount") Discount discount) {
        discountService.save(discount);
        return "redirect:/discounts";
    }

}
