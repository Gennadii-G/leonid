package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.services.DiscountService;
import com.spacefox.frida.services.OrderService;
import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping
    public String post(Model model,
                       @Valid
                       @ModelAttribute(name = "order") Order order,
                       BindingResult bindingResult,
                       @ModelAttribute(name = "discount") Discount discount,
                       @ModelAttribute(name = "hall") TrampolineHall hall)
                        throws IllegalAccessException{

        if(order.getComment().equals("exc")){
            throw new IllegalAccessException("wah-wah");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("hasError", true);
            model.addAttribute("halls", hallService.getAll());
            model.addAttribute("discounts", discountService.getAll());
            model.addAttribute("orders", orderService.getAll());
            return "recordsManagement";
        }

        order.setHall(hall);
        order.setDiscount(discount);
        orderService.saveWithRegDate(order);

        return "redirect:/recordsManagement";
    }

    @GetMapping("/edit/{orderid}")
    public String editGet(Model model, @PathVariable Long orderid){
        Order order = orderService.getById(orderid);
        model.addAttribute("halls", hallService.getAll());
        model.addAttribute("discounts", discountService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("id", orderid);
        return "editOrder";
    }

    @PostMapping("/edit/{orderid}")
    public String editPost(Model model,
                    @PathVariable Long orderid,
                    @ModelAttribute(name = "order") Order order,
                    @ModelAttribute(name = "discount") Discount discount,
                    @ModelAttribute(name = "hall") TrampolineHall hall,
                    BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            model.addAttribute("hasError", true);
            model.addAttribute("halls", hallService.getAll());
            model.addAttribute("discounts", discountService.getAll());
            return "editOrder";
        }

        order.setHall(hall);
        order.setDiscount(discount);
        order.setPublicId(orderid);
        orderService.save(order);

        return "redirect:/recordsManagement";
    }

    @GetMapping("/delete/{orderid}")
    public String deleteO(Model model, @PathVariable Long orderid) {
        orderService.delete(orderid);
        return "redirect:/recordsManagement";
    }
}
