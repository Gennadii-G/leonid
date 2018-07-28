package com.spacefox.frida.controllers.global;

import com.spacefox.frida.utils.SecUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class GlobalControllerAdvice {


//    @Autowired
    private SecUtil secUtil;
//
//    @ModelAttribute
//    public void globalAttributes(Model model) {
//        model.addAttribute("accessLevel", secUtil.accessLevel());
//    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView ero(Exception exception, HttpServletRequest request) {
//        exception.printStackTrace();
//
//
//        ModelAndView mav = new ModelAndView();
//        String mes = exception.getMessage().replaceAll(";", ";\n");
//        mav.addObject("status", request.getAttribute("javax.servlet.error.status_code"));
//        mav.addObject("reason", request.getAttribute("javax.servlet.error.message"));
//        mav.addObject("mes", mes);
//        mav.setViewName("error");
//        return mav;
//    }
//
//    @RequestMapping(path = "/error")
//    public String handle(Model model, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
//        map.put("reason", request.getAttribute("javax.servlet.error.message"));
//        model.addAllAttributes(map);
//        return "error";
//    }

    @RequestMapping("/403")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String forbidden() {
        return "error";
    }
}