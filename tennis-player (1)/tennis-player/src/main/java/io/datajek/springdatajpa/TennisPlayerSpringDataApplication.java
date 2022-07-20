package io.datajek.springdatajpa;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner{
	
	@Autowired
	PlayerSpringDataRepository repo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Inserting Player: {}", repo.save(new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
		logger.info("Player with Id 2: {}", repo.findById(2));
		logger.info("All Players data: {}", repo.findAll());
		
	}


}
