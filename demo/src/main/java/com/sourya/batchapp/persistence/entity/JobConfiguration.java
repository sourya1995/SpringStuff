package com.sourya.batchapp.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB_CONFIG")
public class JobConfiguration {
	public JobConfiguration() {
		
	}
	
	@Id @GeneratedValue
	private Integer id;
	private String clientId;
	private String jobName;
	private String configName;
	private String value;
}
