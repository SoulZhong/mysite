/**
 * 
 */
package com.soullleo.server.jetty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Soul
 * @date Jun 1, 2013
 */
final public class Config {

	private final int port;
	private final String webFilePath;
	private final String resourcePath;
	private final String contextPath;

	Config(InputStream inputStream) throws IOException {

		Properties config = new Properties();
		config.load(inputStream);
		
		webFilePath = config.getProperty("server.webFilePath");
		resourcePath = config.getProperty("server.resourcePath");
		contextPath = config.getProperty("server.contextPath", "/");
		port = Integer.valueOf(config.getProperty("server.port", "80"));

	}

	Config(String configFile) throws FileNotFoundException, IOException {
		this(new FileInputStream(new File(configFile)));
	}

	public int getPort() {
		return port;
	}

	public String getWebfilepath() {
		return webFilePath;
	}

	public String getResourcepath() {
		return resourcePath;
	}

	public String getContextpath() {
		return contextPath;
	}

}
