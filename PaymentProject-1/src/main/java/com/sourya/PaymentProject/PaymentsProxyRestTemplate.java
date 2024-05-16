package com.sourya.PaymentProject;

import java.net.http.HttpHeaders;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentsProxyRestTemplate {
	private final RestTemplate rest;
	
	@Value("${name.service.url}")
	private String paymentsServiceUrl;
	
	public PaymentsProxyRestTemplate(RestTemplate rest) {
		this.rest = rest;
	}
	
	public Payment createPayment(Payment payment) {
		String uri = paymentsServiceUrl + "/payment";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("requestId", UUID.randomUUID().toString());
		
		HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
		
		ResponseEntity<Payment> response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
		
		return response.getBody();
	}
}
