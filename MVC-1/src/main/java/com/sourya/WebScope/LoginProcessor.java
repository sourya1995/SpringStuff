package com.sourya.WebScope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
	private String username;
	private String password;
	
	private final LoggedUserManagementService loggedUserManagementService;
	
	public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}

	public boolean login() {
		String username = this.getUsername();
		String password = this.getPassword();
		
		if("natalie".equals(username) && "password".equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
