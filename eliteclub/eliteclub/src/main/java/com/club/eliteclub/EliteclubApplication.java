package com.club.eliteclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class EliteclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EliteclubApplication.class, args);
	}

}
