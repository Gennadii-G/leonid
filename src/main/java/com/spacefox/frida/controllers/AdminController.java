package com.spacefox.frida.controllers;

import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.User;
import com.spacefox.frida.domain.catalogs.Roles;
import com.spacefox.frida.services.DiscountService;
import com.spacefox.frida.services.TrampolineHallService;
import com.spacefox.frida.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TrampolineHallService hallService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAdm(Model model,
                          @ModelAttribute(name = "hall") TrampolineHall hall,
                          @ModelAttribute(name = "discount") Discount discount,
                          @ModelAttribute(name = "user") User user) {

        model.addAttribute("roles", Roles.values());
        return "admin";
    }

    @PostMapping("/addHall")
    public String postHall(ModelAndView model,
                           @ModelAttribute(name = "hall") TrampolineHall hall,
                           @RequestParam("trampsAmount") int trAmount) {

        hallService.save(hall, trAmount);
        return "redirect:/trampolineHalls";
    }

    @PostMapping("/addDiscount")
    public String postDiscount(ModelAndView model,
                               @ModelAttribute(name = "discount") Discount discount) {
        discountService.save(discount);
        return "redirect:/discounts";
    }

    @PostMapping("/addUser")
    public String postAddUser(Model model,
                              @ModelAttribute(name = "hall") TrampolineHall hall,
                              @ModelAttribute(name = "discount") Discount discount,
                              @ModelAttribute(name = "user") User user) {
        String page;

        if(userService.exists(user.getLogin())){
            model.addAttribute("rejectedUsr", "true");
            page = "admin";
        }else {
            userService.save(user);
            page = "redirect:/admin";
        }
        return page;
    }
}
