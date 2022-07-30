package com.club.eliteclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.eliteclub.model.Club;
import com.club.eliteclub.service.EliteClubService;

@RestController
public class EliteClubController {
	
	@Autowired
	private EliteClubService eliteClubService;
	
	@GetMapping(path="/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Club> clubs() {
		return eliteClubService.getAll();
	}
	

}
