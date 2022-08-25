package com.club.eliteclub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.club.eliteclub.service.EliteClubService;
import com.club.eliteclub.service.EliteClubServiceImpl;
import com.club.eliteclub.model.ClubDTO;

import antlr.collections.List;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class EliteclubApplication implements ApplicationRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(EliteclubApplication.class);
	
	@Autowired
	private EliteClubServiceImpl eliteClubServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(EliteclubApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		eliteClubServiceImpl.addClub("Billionaire", "Environmentalist", "Poker");
		List<ClubDTO> clubs = eliteClubServiceImpl.searchClub("Bi");
		LOG.info("Search Result: {}", clubs);
		
		
	}

}
