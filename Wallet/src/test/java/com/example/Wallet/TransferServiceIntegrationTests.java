package com.example.Wallet;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TransferServiceIntegrationTests {
	@MockBean
	private AccountRepository accountRepository;
	
	@Autowired
	private TransferService transferService; //framework will inject all mocks
	
	
	@Test
	
	public void moneyTransferHappyFlow() {
		
		
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(1000));
		
		Account destination = new Account();
		destination.setId(2);
		destination.setAmount(new BigDecimal(1000));
		
		given(accountRepository.findById(sender.getId()))
		.willReturn(Optional.of(sender));
		
		given(accountRepository.findById(destination.getId()))
		.willReturn(Optional.of(destination));
		
		transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(1000));
		
		 verify(accountRepository) 
		 .changeAmount(1, new BigDecimal(900));
		 verify(accountRepository) 
		 .changeAmount(2, new BigDecimal(1100));
		
	}
}
