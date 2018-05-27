package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.Order;
import com.spacefox.frida.layout.DiscountService;
import com.spacefox.frida.layout.TrampolineHallService;
import com.spacefox.frida.utils.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recordVisitors")
public class RecordVisitorsController {

    private TrampolineHallService hallDao;
    private DiscountService discounts;
    private OrderHandler handler;

    @Autowired
    public RecordVisitorsController(TrampolineHallService hallDao, DiscountService discounts, OrderHandler handler) {
        this.hallDao = hallDao;
        this.discounts = discounts;
        this.handler = handler;
    }


    @GetMapping
    public String get(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("halls", hallDao.getAll());
        model.addAttribute("discounts", discounts.getAll());
        return "recordVisitors";
    }

    @PostMapping
    public String post(@ModelAttribute Order order, Model model){
        handler.handle(order);
        System.out.println(hallDao.getByName(order.getHallId()).getOrders().size());
        System.out.println(order.toString());
        return "redirect:/recordVisitors";
    }

}
