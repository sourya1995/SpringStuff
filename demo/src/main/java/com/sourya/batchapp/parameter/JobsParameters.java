package com.sourya.batchapp.parameter;

import java.util.*;

public class JobsParameters {
	INGESTER_JOB("ingesterJob", IngesterJobParams.values());

    private String jobName;
    private Parameter[] parameters;

    JobsParameters(String jobName, Parameter[] parameters) {
        this.jobName = jobName;
        this.parameters = parameters;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public static Optional<JobsParameters> getParamsForJob(String job) {
        return Arrays.stream(values())
                .filter(jobsParameters -> jobsParameters.jobName.equals(job))
                .findFirst();
    }
}
