package com.sourya.batchapp.job.implementation;

import javax.inject.Qualifier;

import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sourya.batchapp.job.Job;
import com.sourya.batchapp.job.component.process.Processor;
import com.sourya.batchapp.job.component.read.Reader;
import com.sourya.batchapp.job.component.write.Writer;

public class IngesterJob extends Job<Dataset<Row>> {
	
	private static Logger LOGGER = (Logger) LoggerFactory
            .getLogger(IngesterJob.class);

    private Reader ingesterReader;
    private Processor ingesterProcessor;
    private Writer ingesterWriter;

    @Autowired
    public IngesterJob(@Qualifier("ingesterReader") Reader<Dataset<Row>> ingesterReader,
                       @Qualifier("ingesterProcessor")Processor<Dataset<Row>> ingesterProcessor,
                       @Qualifier("ingesterWriter") Writer<Dataset<Row>> ingesterWriter ) {
        this.ingesterReader = ingesterReader;
        this.ingesterProcessor = ingesterProcessor;
        this.ingesterWriter = ingesterWriter;
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
