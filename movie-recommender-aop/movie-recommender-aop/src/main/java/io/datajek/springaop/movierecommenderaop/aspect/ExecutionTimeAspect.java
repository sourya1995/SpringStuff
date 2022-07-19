package io.datajek.springaop.movierecommenderaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExecutionTimeAspect {
	public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		long startTime = System.currentTimeMillis();
		Object returnValue = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time taken by {} to complete execution is: {}", joinPoint, timeTaken);
		return returnValue;
	}

}
