package com.club.eliteclub.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.club.eliteclub.model.Club;

@Service
public class EliteClubService {
	
	public List<Club> getAll() {
		return Arrays.asList(new Club("Billionaire"),
				new Club("Environmentalist"),
				new Club("soccer"));
	}
	

}
