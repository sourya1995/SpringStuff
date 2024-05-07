package org.sourya.springlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name = "Ella";
	
	 //we can inject an appropriate value from context here
	private final Parrot parrot;
	
	@Autowired //hey, inject an appropriate value from your context
	public Person(Parrot parrot) {
		this.parrot = parrot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Parrot getParrot() {
		return parrot;
	}
	//can have autowired here too - have to remove final 
	public void setParrot(Parrot parrot) {
		parrot = parrot;
	}
	
	
}
