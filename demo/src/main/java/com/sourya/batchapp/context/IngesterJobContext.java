package com.sourya.batchapp.context;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class IngesterJobContext extends CommonJobContext implements Serializable {
	 public static final String CSV_FORMAT = "csv";
	 public static final String JSON_FORMAT = "json";

}
