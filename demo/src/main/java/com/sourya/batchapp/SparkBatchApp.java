package com.sourya.batchapp;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparkBatchApp implements CommandLineRunner{
	
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(SparkBatchApp.class);
	
	@Autowired
	private ExceptionHandler exceptionHandler;
	
	@Autowired
	private Parameters parameters;
	
	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SparkBatchApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			LOGGER.info("Parsing common job arguments");
			loadCommonParams(args);
			LOGGER.info("instantiating job");
			Job job = (Job)context.getBean(parameters.getParamValue(CommonJobParameter.JOB_NAME),CommonJobParameter.JOB_NAME);
			LOGGER.info("executing job");
			job.execute();
			
		} catch(Exception be) {
			exceptionHandler.handleException(be);
			throw be;
		}
		
	}
	
	private void loadCommonParams(String[] args) {
		parameters.loadAllParams(args, CommonJobParameter.values());
	}

}
