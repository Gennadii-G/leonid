package com.spacefox.frida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ContactController {

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String conrtacts(ModelMap model){
        model.addAttribute("text", "test Text");
        return "contacts";
    }
}
