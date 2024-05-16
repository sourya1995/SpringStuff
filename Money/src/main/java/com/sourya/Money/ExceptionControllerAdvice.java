package com.sourya.Money;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage("insufficient balance");
		return ResponseEntity
				.badRequest()
				.body(errorDetails);
	}
}
