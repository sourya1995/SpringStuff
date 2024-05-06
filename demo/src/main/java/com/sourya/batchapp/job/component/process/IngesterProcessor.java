package com.sourya.batchapp.job.component.process;

import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.slf4j.LoggerFactory;

import com.sourya.batchapp.schema.SalesSchema;

public class IngesterProcessor implements Processor<Dataset<Row>> {
	
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(IngesterProcessor.class);

	@Override
	public Dataset<Row> process(Dataset<Row> inputDf) {
		// TODO Auto-generated method stub
		Dataset<Row> parsedResults = inputDf.flatMap(new IngesterJsonFlatMapper(), RowEncoder.apply(SalesSchema.getSparkSchema()));
		return parsedResults;
	}

}
