package com.sourya.batchapp.parameter;

public class IngesterJobParams implements Parameter<IngesterJobParams>{
	READ_FORMAT("readFormat"),
    FILE_NAME("fileName");

    //Others to be added...

    private String paramName;

    IngesterJobParams(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String getParamName() {
        return paramName;
    }
}
