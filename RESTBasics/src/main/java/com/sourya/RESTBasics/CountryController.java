package com.sourya.RESTBasics;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	@GetMapping("/France")
	public ResponseEntity<Country> France() {
		Country c = Country.of("France", 67);
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.header("continent", "Europe")
				.header("capital", "Paris")
				.header("favorite food", "camembert")
				.body(c);
	}
	
	@GetMapping("/allCountries")
	public List<Country> allCountries(){
		Country c1 = Country.of("Italy", 38);
		Country c2 = Country.of("Germany", 76);
		
		return List.of(c1, c2);
	}
}
