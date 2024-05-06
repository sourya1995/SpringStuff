package com.sourya.batchapp.persistence.manager;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component
public class DatabaseConnManager implements Serializable {
	
	 @Value("${spring.datasource.url}")
	    private String dbUrl;

	    @Value("${spring.datasource.username}")
	    private String username;

	    @Value("${spring.datasource.password}")
	    private String password;

	    @Value("${spring.datasource.driver-class-name}")
	    private String driver;

	    
	    public DataSource getDataSource() {
	    	HikariDataSource hikariDataSource = new HikariDataSource();
	    	hikariDataSource.setJdbcUrl(dbUrl);
	    	hikariDataSource.setUsername(username);
	    	hikariDataSource.setPassword(password);
	    	hikariDataSource.setDriverClassName(driver);
	    	return hikariDataSource;
	    }
	    
	    public String getDbUrl() {
	        return dbUrl;
	    }

	    public void setDbUrl(String dbUrl) {
	        this.dbUrl = dbUrl;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getDriver() {
	        return driver;
	    }

	    public void setDriver(String driver) {
	        this.driver = driver;
	    }
	
}
