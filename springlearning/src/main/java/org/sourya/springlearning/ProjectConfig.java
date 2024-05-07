package org.sourya.springlearning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.sourya.springlearning") /* where to look for classes */
public class ProjectConfig {
	/*
	 * @Bean we will add this instance to the context Parrot parrot() { var p = new
	 * Parrot(); p.setName("Koko"); return p; }
	 * 
	 * @Bean String hello() { return "Hello"; }
	 * 
	 * @Bean Integer ten() { return 10; }
	 * 
	 * @Bean Parrot parrot2() { var p = new Parrot(); p.setName("Miki"); return p; }
	 * 
	 * @Bean Parrot parrot3() { var p = new Parrot(); p.setName("Riki"); return p; }
	 */

	@Bean
	public Parrot parrot1() {
		Parrot p = new Parrot();
		p.setName("Ramesh");
		return p;
	}

	/*
	 * @Bean public Person person(Parrot parrot)Parrot bean injected here { Person p
	 * = new Person(); p.setName("Sachin"); p.setParrot(parrot); if the bean exists,
	 * return a reference to it - if not, create and return a reference return p; }
	 */
	
	@Bean
	public Parrot parrot2() {
		Parrot p = new Parrot();
		p.setName("Miki");
		return p;
	}
	
	@Bean
	public Person person(@Qualifier("parrot2")Parrot parrot) {
		Person p = new Person();
		p.setName("Ella");
		p.setParrot(parrot);
		return p;
				
	}
}
