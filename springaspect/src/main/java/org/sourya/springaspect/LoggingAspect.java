package org.sourya.springaspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect //no bean for this class
public class LoggingAspect {
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	@Around("execution(* org.sourya.springaspect.*.*(..))")
	public void log(ProceedingJoinPoint joinPoint) 
	{
		logger.info("Method will execute");
		joinPoint.proceed(); //delegate to intercepted method
		logger.info("Method executed");
	}
}
