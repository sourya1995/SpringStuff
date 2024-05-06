package com.sourya.batchapp.job.implementation;

import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sourya.batchapp.job.Job;


@Component
public class SparkJob extends Job<Dataset<Row>> {
	
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(SparkJob.class);
	
	private Parameters parameters;
	
	@Autowired
	public SparkJob(Parameters parameters) {
		this.parameters = parameters;
	}

	@Override
	protected Dataset<Row> preProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Dataset<Row> process(Dataset<Row> preProcessOutput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void postProcess(Dataset<Row> processOutput) {
		// TODO Auto-generated method stub
		
	}

	

}
