package com.sourya.batchapp.parameter;

import java.util.*;

public enum CommonJobParameter implements Parameter<CommonJobParameter> {
	 JOB_NAME("jobName"),
	    CLIENT_ID("clientId");

	    //Others to be added...

	    private String paramName;

	    CommonJobParameter(String paramName) {
	        this.paramName = paramName;
	    }

	    public Optional<CommonJobParameter> paramExists(String argName) {
	        return Arrays.stream(values())
	                .filter(commonJobParameter -> commonJobParameter.paramName.equals(argName))
	                .findFirst();
	    }

	    @Override
	    public String getParamName() {
	        return paramName;
	    }
}
