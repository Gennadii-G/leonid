package com.spacefox.frida.controllers.global;

import com.spacefox.frida.services.UserService;
import com.spacefox.frida.utils.SecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private UserService userService;
    @Autowired
    private SecUtil secUtil;

    @ModelAttribute
    public void globalAttributes(Model model) {
        model.addAttribute("accessLevel", secUtil.accessLevel());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView ero(Exception exception) {
        ModelAndView mav = new ModelAndView();
        String mes = exception.getMessage().replaceAll(";", ";\n");
        mav.addObject("mes", mes);
        mav.setViewName("error");
        return mav;
    }
}