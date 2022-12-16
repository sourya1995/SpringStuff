package com.club.eliteclub.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.eliteclub.dao.EliteClubRepository;
import com.club.eliteclub.entity.EliteClub;
import com.club.eliteclub.model.ClubDTO;

@Service
public class EliteClubServiceImpl implements EliteClubService{
	
	private static final Logger LOG = LoggerFactory.getLogger(EliteClubServiceImpl.class);
	
	private EliteClubRepository eliteClubRepository;
	
	@Autowired
	public void setEliteClubRepository(EliteClubRepository eliteClubRepository) {
		this.eliteClubRepository = eliteClubRepository;
	}
	
	public List<ClubDTO> getAll() {
		return eliteClubRepository.findAll().stream().map(c -> new ClubDTO(c.getClubName())).collect(Collectors.toList());
	}

	public void addClub(String...clubnames) {
		// TODO Auto-generated method stub
		for(String clubname : clubnames) {
			EliteClub eliteClub = new EliteClub();
			eliteClub.setClubName(clubname);
			eliteClubRepository.save(eliteClub);
		}
		
	}

	@Override
	public List<ClubDTO> searchClub(String searchTerm) {
		// TODO Auto-generated method stub
		LOG.info("Searching Term: {}", searchTerm);
		List<ClubDTO> result = eliteClubRepository
				.findClubs(buildLikePattern(searchTerm))
				.stream()
				.map(c -> new ClubDTO(c.getClubName()))
				.collect(Collectors.toList());
		LOG.info("Search Result: {}", result);
		return result;
	}
	
	private String buildLikePattern(String searchTerm) {
		return searchTerm.toLowerCase() + "%";
	}

	@Override
	public ClubDTO getById(long clubId) {
		// TODO Auto-generated method stub
		return new ClubDTO(eliteClubRepository.getOne(clubId).getClubName());
	}

	@Override
	public void deleteClub(long clubId) {
		eliteClubRepository.deleteById(clubId);
		
	}

	@Override
	public ClubDTO updateClub(long clubId, ClubDTO updatedClub) {
		// TODO Auto-generated method stub
		EliteClub eliteClub = new EliteClub(); //entity
		eliteClub.setId(clubId);
		eliteClub.setClubName(updatedClub.getClubName());
		final EliteClub saved = eliteClubRepository.save(eliteClub);
		return new ClubDTO(saved.getClubName());
	}
	

}
