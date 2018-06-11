package com.spacefox.frida.controllers.global;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalControllerAdvice {

//    @InitBinder
//    public void dataBinding(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
//    }
//    @ModelAttribute
//    public void globalAttributes(Model model) {
//        model.addAttribute("msg", "Welcome to My World!");
//    }
    @ExceptionHandler(Exception.class)
    public ModelAndView ero(Exception exception) {
        ModelAndView mav = new ModelAndView();
        String mes = exception.getMessage().replaceAll(";", ";\n");
        mav.addObject("mes", mes);
        mav.setViewName("oherror");
        return mav;
    }
}