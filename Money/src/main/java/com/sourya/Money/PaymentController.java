package com.sourya.Money;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	private static Logger LOGGER = Logger.getLogger(PaymentController.class.getName());
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping("/payment")
	public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
		
			/*PaymentDetails paymentDetails = paymentService.processPayment();*/
		
		LOGGER.info("received payment" + paymentDetails.getAmount());
			
			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(paymentDetails);
		} 
	}
	
	

