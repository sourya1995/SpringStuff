package com.sourya.PaymentProject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsControllerRestTemplate {
	private final PaymentsProxyRestTemplate paymentsProxyRestTemplate;

	public PaymentsControllerRestTemplate(PaymentsProxyRestTemplate paymentsProxyRestTemplate) {
		this.paymentsProxyRestTemplate = paymentsProxyRestTemplate;
	}
	
	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentsProxyRestTemplate.createPayment(payment);
	}
	
	
}
