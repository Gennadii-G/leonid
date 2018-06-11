package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.services.ContactService;
import com.spacefox.frida.services.DiscountService;
import com.spacefox.frida.services.OrderService;
import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/recordVisitors")
public class RecordVisitorsController {

    @Autowired
    private TrampolineHallService hallService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ContactService contactService;


    @GetMapping
    public String get(Model model,
                      @ModelAttribute(name = "order") Order order){
        model.addAttribute("halls", hallService.getAll());
        model.addAttribute("discounts", discountService.getAll());
        return "recordVisitors";
    }

    @PostMapping("/addOrder")
    public String post(Model model,
                       @ModelAttribute(name = "order") Order order,
                       @ModelAttribute(name = "discount") Discount discount,
                       @ModelAttribute(name = "hall") TrampolineHall hall){
        order.setHall(hall);
        order.setDiscount(discount);
//        contactService.save(order.getContact());
        orderService.saveWithRegDate(order);

        return "redirect:/trampolineHalls";
    }

}
