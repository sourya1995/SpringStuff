package com.sourya.WebScope;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	private final LoggedUserManagementService loggedUserManagementService;
	private final LoginCountService loginCountService;
	
	public MainController(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}
	
	@GetMapping("/main")
	public String home(@RequestParam(required = false) String logout, Model model) {
		
		if(logout != null) {
			loggedUserManagementService.setUsername(null);
		}
		String username = loggedUserManagementService.getUsername();
		int count = loginCountService.getCount();
		
		if(username == null) {
			return "redirect:/";
		}
		
		model.addAttribute("username", username);
		model.addAttribute("loginCount", count);
		
		return "main.html";
	}
}
