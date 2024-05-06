package org.sourya.springlearning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
	@Bean /* we will add this instance to the context */
	Parrot parrot() {
		var p = new Parrot();
		p.setName("Koko");
		return p;
	}
	
	@Bean
	String hello() {
		return "Hello";
	}
	
	@Bean
	Integer ten() {
		return 10;
	}
	
	@Bean
	Parrot parrot2() {
		var p = new Parrot();
		p.setName("Miki");
		return p;
	}
	
	@Bean
	Parrot parrot3() {
		var p = new Parrot();
		p.setName("Riki");
		return p;
	}
}
