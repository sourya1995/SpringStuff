package com.sourya.batchapp.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sourya.batchapp.persistence.entity.JobConfiguration;

@Repository
public class ConfigRepository extends CrudRepository<JobConfiguration, Integer> {
	JobConfiguration findTop1ByJobNameAndClientIdAndConfigName(String jobName, String clientId, String configName);
}
