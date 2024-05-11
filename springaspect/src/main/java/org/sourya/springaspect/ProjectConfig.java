package org.sourya.springaspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.sourya.springaspect")
@EnableAspectJAutoProxy
public class ProjectConfig {
	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	
	@Bean
	public SecurityAspect aspect() {
		return new SecurityAspect();
	}
}
