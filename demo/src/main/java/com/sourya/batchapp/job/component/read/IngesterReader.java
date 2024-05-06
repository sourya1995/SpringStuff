package com.sourya.batchapp.job.component.read;

import javax.inject.Qualifier;

import org.apache.log4j.Logger;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sourya.batchapp.configuration.SparkSessionProvider;
import com.sourya.batchapp.context.CommonJobContext;
import com.sourya.batchapp.context.IngesterJobContext;
import com.sourya.batchapp.dictionary.IngestJobConfig;
import com.sourya.batchapp.parameter.CommonJobParameter;
import com.sourya.batchapp.parameter.IngesterJobParams;
import com.sourya.batchapp.persistence.repository.ConfigRepository;

public class IngesterReader implements Reader<Dataset<Row>> {
	

    private static Logger LOGGER = (Logger) LoggerFactory
            .getLogger(IngesterReader.class);

    private static final String DOT = ".";

    private CommonJobContext jobContext;
    private ConfigRepository configRepository;

    @Autowired
    public IngesterReader(@Qualifier("ingesterJobContext") CommonJobContext jobContext,
                          ConfigRepository configRepository) {
        this.jobContext = jobContext;
        this.configRepository = configRepository;
    }


    @Override
    public Dataset<Row> read() {
        SparkSession sparkSession = SparkSessionProvider.provideSession(jobContext.getSparkMode());
        String fileReadFormat = jobContext.getParams().getParamValue(IngesterJobParams.READ_FORMAT);
        String fileName = jobContext.getParams().getParamValue(IngesterJobParams.FILE_NAME);
        String fullPath = readInputPath().concat(fileName).concat(DOT).concat(fileReadFormat);
        //Read using Spark
        DataFrameReader dfReader = sparkSession.read().format(fileReadFormat);
        LOGGER.info("Reading input file...");
        return getReaderForFormat(dfReader, fileReadFormat).load(fullPath);
    }
    
    private String readInputPath() {
        return configRepository
                .findTop1ByJobNameAndClientIdAndConfigName(jobContext.getParams().getParamValue(CommonJobParameter.JOB_NAME),
                        jobContext.getParams().getParamValue(CommonJobParameter.CLIENT_ID),
                        IngestJobConfig.INPUT_PATH.getConfigName()).getValue();
    }
    
    private DataFrameReader getReaderForFormat(DataFrameReader reader, String format) {
        if (format.equals(IngesterJobContext.CSV_FORMAT)) {
            return reader.option("header", "true");
        } else if (format.equals(IngesterJobContext.JSON_FORMAT)) {
            return reader.option("multiline", "true");
            //Other possible formats below or extract to object with logic...
        } else {
            return reader;
        }
    }

}
