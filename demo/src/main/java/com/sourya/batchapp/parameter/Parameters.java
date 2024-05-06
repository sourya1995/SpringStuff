package com.sourya.batchapp.parameter;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class Parameters {
	private static final String ARG_SEPARATOR = "=";
    private static final int KEY = 0;
    private static final int VALUE = 1;

    private Map<Parameter, String> jobParams = new HashMap<>();

    public void loadAllParams(String[] appArgs, Parameter[] parameters) {
        Map<String, String> keyVals = new HashMap<>();
        Arrays.stream(appArgs).forEach(arg -> {
            String[] keyVal = arg.split(ARG_SEPARATOR);
            keyVals.put(keyVal[KEY], keyVal[VALUE]);
        });
        Arrays.stream(parameters).forEach(parameter -> {
            String value = keyVals.get(parameter.getParamName());
            if(Objects.nonNull(value)) {
                jobParams.put(parameter, value);
            }
        });
    }

    public String getParamValue(Parameter paramName) {
        return jobParams.get(paramName);
    }

}
