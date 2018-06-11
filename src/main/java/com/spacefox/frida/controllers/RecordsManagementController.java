package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.Order;
import com.spacefox.frida.services.DiscountService;
import com.spacefox.frida.services.OrderService;
import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recordsManagement")
public class RecordsManagementController {

    @Autowired
    private TrampolineHallService hallService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String get(Model model,
                      @ModelAttribute(name = "order") Order order){
        model.addAttribute("halls", hallService.getAll());
        model.addAttribute("discounts", discountService.getAll());

        model.addAttribute("orders", orderService.getAll());
        model.addAttribute("perm", "12");
        model.addAttribute("localPerm", "12");
        return "recordsManagement";
    }

}
