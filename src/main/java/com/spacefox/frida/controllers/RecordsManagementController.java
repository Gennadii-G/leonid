package com.spacefox.frida.controllers;

import com.spacefox.frida.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recordsManagement")
public class RecordsManagementController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String get(Model model){
        model.addAttribute("orders", orderService.getAll());
        return "recordsManagement";
    }

}
