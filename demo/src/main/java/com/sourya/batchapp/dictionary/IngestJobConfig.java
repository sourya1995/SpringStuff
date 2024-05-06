package com.sourya.batchapp.dictionary;

public class IngestJobConfig {
	
	INPUT_PATH(configName: "inputPath");
	
	private String configName;
	
	IngestJobConfig(String configName){
		this.configName = configName;
	}
	
	public String getConfigName() {
		return configName;
	}
	

}
