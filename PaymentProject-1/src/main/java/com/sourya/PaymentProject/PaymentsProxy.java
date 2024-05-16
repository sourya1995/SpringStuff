package com.sourya.PaymentProject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payments", url = "{name.service.url}")
public interface PaymentsProxy {
	@PostMapping("/payment")
	Payment createPayment(@RequestHeader requestId, @RequestBody Payment payment);
}
