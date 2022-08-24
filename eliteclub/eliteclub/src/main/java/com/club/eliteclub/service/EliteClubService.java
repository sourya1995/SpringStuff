package com.club.eliteclub.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.club.eliteclub.model.ClubDTO;

@Service
public class EliteClubService {
	
	public List<ClubDTO> getAll() {
		return Arrays.asList(new ClubDTO("Billionaire"),
				new ClubDTO("Environmentalist"),
				new ClubDTO("soccer"));
	}
	

}
