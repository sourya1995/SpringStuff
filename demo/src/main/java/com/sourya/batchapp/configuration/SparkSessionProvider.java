package com.sourya.batchapp.configuration;

import java.util.Objects;

import org.apache.spark.sql.SparkSession;

public class SparkSessionProvider {
	
	private SparkSessionProvider() {}
	
	private static SparkSession sparkSession;
	
	public static SparkSession provideSession(String masterMode) {
		if(Objects.isNull(sparkSession)) {
			SparkSession.Builder sessionBuilder = SparkSession.builder()
					.appName("SparkBatchApp");
			
			if(Objects.nonNull(masterMode)) {
				sessionBuilder = sessionBuilder.master(masterMode);
			}
			
			sparkSession = sessionBuilder.getOrCreate();
		}
		return sparkSession;
	}

}
