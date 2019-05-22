package com.intertech.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartupController {
	
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome() {
		System.out.println(message);
		return "welcome";
	}

}
