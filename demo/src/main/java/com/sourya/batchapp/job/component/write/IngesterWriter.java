package com.sourya.batchapp.job.component.write;

import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sourya.batchapp.job.component.transformation.mapper.IngesterSalesToDbMapper;
import com.sourya.batchapp.persistence.manager.DatabaseConnManager;
import com.sourya.batchapp.schema.SalesSchema;

public class IngesterWriter implements Writer<Dataset<Row>>{
	private static Logger LOGGER = (Logger) LoggerFactory
            .getLogger(IngesterWriter.class);

    @Autowired
    private DatabaseConnManager connManager;

    @Override
    public void write(Dataset<Row> input) {
        LOGGER.info("Writing Records to SALES table in the DB...");
        Dataset<Row> persistedDf = input.mapPartitions(new IngesterSalesToDbMapper(connManager),
                RowEncoder.apply(SalesSchema.getSparkSchema()));
        //Call a Spark Action triggering all the previous transformations done
        persistedDf.count();
    }

}
