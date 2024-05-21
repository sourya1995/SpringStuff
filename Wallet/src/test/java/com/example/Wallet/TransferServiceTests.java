package com.example.Wallet;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTests {
	@Mock
	private AccountRepository accountRepository;
	
	@InjectMocks
	private TransferService transferService; //framework will inject all mocks
	
	
	@Test
	
	public void moneyTransferHappyFlow() {
		
		TransferService transferService = new TransferService(accountRepository);
		
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
	
@Test
	
	public void moneyTransferHappyFlowNotFound() {
		
		TransferService transferService = new TransferService(accountRepository);
		
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(1000));
		
		Account destination = new Account();
		destination.setId(2);
		destination.setAmount(new BigDecimal(1000));
		
		given(accountRepository.findById(1L))
		.willReturn(Optional.of(sender));
		
		given(accountRepository.findById(2L))
		.willReturn(Optional.empty());
		
		assertThrows(AccountNotFoundException.class, () -> transferService.transferMoney(1, 2, new BigDecimal(100)));
		verify(accountRepository, never()).changeAmount(anyLong(), any());
		
	}

}
