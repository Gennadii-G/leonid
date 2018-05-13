package com.spacefox.frida.controllers.unnecessary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dfdfgfdg/")
public class HWController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model){
        model.addAttribute("greeting", "hello, how are you?)");
        return "test1234";
    }
    @RequestMapping(value="/helloagain", method=RequestMethod.GET)
    public String sayHelloAgain(ModelMap model){
        model.addAttribute("greeting", "hello, again");
        return "login";
    }

    @GetMapping(value = "/search")
    public String search(){
        return "search";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(ModelMap model){
        model.addAttribute("text", "какое-то сообщение");
        return "test";
    }

//    @GetMapping(value = "/test123")
//    public ModelAndView test(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("test123");
//        return modelAndView;
//    }

//    @GetMapping(value = "/test32")
//    public ModelAndView test2(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }

}
