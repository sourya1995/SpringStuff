package com.sourya.MVC.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class MainController {
	@RequestMapping("/home")
	public String home(Model page) {
		page.addAttribute("username", "Katy");
		page.addAttribute("color", "red");
		return "home.html";
	}
}
