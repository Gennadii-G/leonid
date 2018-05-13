package com.spacefox.frida.controllers.unnecessary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

	@RequestMapping("/exception")
	public @ResponseBody
	String exception() {
		throw new IllegalStateException("Sorry!");
	}

	@RequestMapping("/global-exception")
	public @ResponseBody
	String businessException() throws Exception {
		throw new Exception();
	}

	@ExceptionHandler
	public @ResponseBody
	String handle(Exception e) {
		return "Exception handled!";
	}

}
