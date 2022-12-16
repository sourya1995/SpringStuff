package com.club.eliteclub.service;

import java.util.List;

import com.club.eliteclub.model.ClubDTO;

public interface EliteClubService{
	
	List<ClubDTO> getAll();
	List<ClubDTO> searchClub(String searchTerm);
	void addClub(String...clubNames);
	ClubDTO getById(long clubId);
	void deleteClub(long clubId);
	ClubDTO updateClub(long clubId, ClubDTO updatedClub);
	
}