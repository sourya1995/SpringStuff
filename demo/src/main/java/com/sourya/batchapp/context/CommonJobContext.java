package com.sourya.batchapp.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonJobContext {
	@Autowired
    protected Parameters params;

    @Value("${spark.master.mode}")
    private String sparkMode;

    //Getters, setters, ect (Or use Lombok)
    public String getSparkMode() {
        return this.sparkMode;
    }

    public Parameters getParams() {
        return params;
    }
}
