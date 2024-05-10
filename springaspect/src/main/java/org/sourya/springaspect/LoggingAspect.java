package org.sourya.springaspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect //no bean for this class
public class LoggingAspect {
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	@Around("@annotation(ToLog)")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		String methodName = joinPoint.getSignature().getName(); //method name
		Object[] arguments = joinPoint.getArgs(); //arguments
		logger.info("Method will execute");
		Comment comment = new Comment();
		comment.setText("something else");
		Object[] newArguments = {comment};
		Object returnedByMethod = joinPoint.proceed(newArguments); //delegate to intercepted method
		logger.info("Method executed");
		
		return "FAILED";
	}
}
