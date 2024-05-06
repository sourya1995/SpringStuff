package com.sourya.batchapp.exception;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ExceptionHandler.class);
	
	public void handleException(Exception exceptionThrow) {
		LOGGER.error(exceptionThrow.getMessage());
	}
	
	public void handleBusinessException(BatchAppException batchAppException) {
		LOGGER.error(batchAppException.getMessage());
	}
}
