package com.example.SpringReactive;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class ProjectConfig {
	
	@Bean
	public WebClient webClient() {
		return WebClient
				.builder()
				.build();
	}
}
