package org.sourya.springlearning;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/*@Component which class to add to context*/
public class Parrot {
	private String name;

	public String getName() {
		return name;
	}

	/*
	 * @PostConstruct public void init() { this.name = "Ramesh"; }
	 */

	public void setName(String name) {
		this.name = name;
	}

}
