package org.sourya.springlearning;

import org.springframework.stereotype.Component;

@Component /*which class to add to context*/
public class Parrot {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
