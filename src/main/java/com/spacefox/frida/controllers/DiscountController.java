package com.spacefox.frida.controllers;


import com.spacefox.frida.repository.DiscountRepository;
import com.spacefox.frida.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountService service;

    @GetMapping
    public String generalDiscountsPage(Model model){
        model.addAttribute("discounts", service.getAll());
        return "discounts";
    }
}
