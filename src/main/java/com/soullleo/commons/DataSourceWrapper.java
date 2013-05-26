/**
 * 
 */
package com.soullleo.commons;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Soul
 * @date May 26, 2013
 */
public class DataSourceWrapper extends BasicDataSource {

	private String configFile;
	
	public DataSourceWrapper(){

	}

	protected synchronized DataSource createDataSource() throws SQLException {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(configFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.setUrl(properties.getProperty("url"));
		super.setUsername(properties.getProperty("username"));
		super.setPassword(properties.getProperty("password"));
		
		return super.createDataSource();
	}
	
	
	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}
	
	

}
