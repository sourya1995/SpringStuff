package com.club.eliteclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.club.eliteclub.model.ClubDTO;
import com.club.eliteclub.service.EliteClubService;
import com.club.eliteclub.service.EliteClubServiceImpl;

@RestController
public class EliteClubController {
	
	
	private EliteClubServiceImpl eliteClubServiceImpl;
	
	public void setEliteClubService(EliteClubServiceImpl eliteClubServiceImpl) {
		this.eliteClubServiceImpl = eliteClubServiceImpl;
	}
	
	@GetMapping(path="/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDTO> clubs() {
		return eliteClubServiceImpl.getAll();
	}
	
	@PostMapping(path="/club", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createNewClub(@RequestBody ClubDTO clubDTO) {
		eliteClubServiceImpl.addClub(clubDTO.getClubName());
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@GetMapping(path="/club/search", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDTO> searchClub(@RequestParam String clubName){
		return eliteClubServiceImpl.searchClub(clubName);
	}
	
	@GetMapping(path="/club/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ClubDTO clubWithId(@PathVariable long id) {
		return eliteClubServiceImpl.getById(id);
	}
	
	@DeleteMapping(path="/club/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteClub(@PathVariable long id) {
		eliteClubServiceImpl.deleteClub(id);
	}
	
	@PutMapping(path="/club/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ClubDTO updateClub(@PathVariable long id, @RequestBody ClubDTO clubDTO) {
		return eliteClubServiceImpl.updateClub(id, clubDTO);
	}
	

}
