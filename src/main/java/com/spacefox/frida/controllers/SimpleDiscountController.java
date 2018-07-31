package com.spacefox.frida.controllers;

import com.spacefox.frida.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/123/discounts")
public class SimpleDiscountController {

    @Autowired
    private DiscountService service;

    @GetMapping
    public String generalDiscountsPage(Model model){
        model.addAttribute("discounts", service.getAll());
        model.addAttribute("perm", "123");
        model.addAttribute("localPerm", "12");
//        System.out.println("userName: "+((UserDetails)SecurityContextHolder.getContext().getAuthentication()).getUsername());
        return "discounts";
    }
}
