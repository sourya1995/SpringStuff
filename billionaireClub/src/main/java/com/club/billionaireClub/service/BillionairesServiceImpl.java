package com.club.billionaireClub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.billionaireClub.dao.BillionairesRepository;
import com.club.billionaireClub.domain.Billionaires;

@Service
public class BillionairesServiceImpl implements BillionairesService{
	
	@Autowired
	private BillionairesRepository billionairesRepository;
	
	

	@Override
	public List<Billionaires> listAll() {
		// TODO Auto-generated method stub
		return (List<Billionaires>)billionairesRepository.findAll();
	}

	@Override
	public boolean deleteBillionaire(Long billionaireID) {
		// TODO Auto-generated method stub
		Billionaires billionaire = new Billionaires(billionaireID);
		billionairesRepository.delete(billionaire);
		return true;
	}

	@Override
	public Billionaires createBillionaires(Billionaires billionaires) {
		// TODO Auto-generated method stub
		return billionairesRepository.save(billionaires);
	}

	@Override
	public Billionaires updateBillionaires(Billionaires billionaires) {
		// TODO Auto-generated method stub
		return billionairesRepository.save(billionaires);
	}

	@Override
	public Billionaires getBillionaire(Long billionaireID) {
		// TODO Auto-generated method stub
		return billionairesRepository.findById(billionaireID).get();
	}

}
