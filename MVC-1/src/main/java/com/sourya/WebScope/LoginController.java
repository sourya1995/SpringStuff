package com.sourya.WebScope;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private LoginProcessor loginProcessor;
	
	@GetMapping("/")
	public String loginGet() {
		return "login.html";
	}
	
	@PostMapping("/")
	public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
		loginProcessor.setPassword(password);
		loginProcessor.setUsername(username);
		
		boolean loggedIn = loginProcessor.login();
		
		if(loggedIn) {
			return "redirect:/main";
		} else {
			model.addAttribute("message", "login failed");
		}
		
		return "login.html";
	}
}
