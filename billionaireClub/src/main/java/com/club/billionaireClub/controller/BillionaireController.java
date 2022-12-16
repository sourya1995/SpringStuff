package com.club.billionaireClub.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.billionaireClub.domain.Billionaires;
import com.club.billionaireClub.service.BillionairesService;

@RestController
@RequestMapping("/api/")
public class BillionaireController {
	private static final Logger LOG = LoggerFactory.getLogger(BillionaireController.class);
	
	private BillionairesService billionairesService;
	
	@Autowired
	public BillionaireController(BillionairesService billionairesService) {
		this.billionairesService = billionairesService;
	}
	
	@GetMapping(path="/billionaire",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Billionaires> findAll(){
		LOG.info("findAll method");
		return billionairesService.listAll();
	}
	
	@DeleteMapping(path="/billionaire/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable Long id){
		LOG.info("Deleting info for {}", id);
		billionairesService.deleteBillionaire(id);
		return ResponseEntity.ok().body("User deleted successfully");
	}
	
	@PostMapping(path="/billionaire", produces=MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody Billionaires billionaires) {
		LOG.info("billionaire request saving");
		LOG.debug("save method, First Name - {}", billionaires.getFirstName());
		LOG.debug("save method, Last Name - {}", billionaires.getLastName());
		LOG.debug("save method, Company - {}", billionaires.getCompany());
		LOG.debug("save method, Wealth - {}", billionaires.getWealth());
		
		billionairesService.createBillionaires(billionaires);
		return "created";
	}
	
	@PutMapping(path="/billionaire/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody Billionaires billionaires) {
		LOG.info("billionaire record updating");
		LOG.debug("update method, First Name -{}", billionaires.getFirstName());
		LOG.debug("update method, Last Name - {}", billionaires.getLastName());
		LOG.debug("update method, Company - {}", billionaires.getCompany());
		LOG.debug("update method, Wealth -{}", billionaires.getWealth());
		
		billionairesService.updateBillionaires(billionaires);
		return "updated";
	}
	
	@GetMapping(path="/billionaire/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Billionaires fetchBillionaire(@PathVariable long id) {
		LOG.info("fetchBillionaire method for - {}", id);
		return billionairesService.getBillionaire(id);
	}

}
