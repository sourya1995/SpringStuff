package com.club.billionaireClub.service;

import java.util.List;

import com.club.billionaireClub.domain.Billionaires;

public interface BillionairesService {
	public List<Billionaires> listAll();
	public boolean deleteBillionaire(Long billionaireID);
	public Billionaires createBillionaires(Billionaires billionaires);
	public Billionaires updateBillionaires(Billionaires billionaires);
	public Billionaires getBillionaire(Long billionaireID);
	

}
