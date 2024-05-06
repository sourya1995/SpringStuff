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
}
