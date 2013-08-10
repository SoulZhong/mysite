/**
 * 
 */
package com.soullleo.server.jetty;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Soul
 * @date Jun 1, 2013
 */
public enum Config {

	INSTANCE;
	
	public Properties CONFIG = new Properties();
	private int port;
	private String webFilePath;
	private String resourcePath;
	private String contextPath;
	private String indexPath;

	private Config() {
	}

	public void load(InputStream inputStream) throws IOException {

		CONFIG.load(inputStream);

		webFilePath = CONFIG.getProperty("server.webFilePath");
		resourcePath = CONFIG.getProperty("server.resourcePath");
		contextPath = CONFIG.getProperty("server.contextPath", "/");
		port = Integer.valueOf(CONFIG.getProperty("server.port", "80"));
		indexPath = CONFIG.getProperty("index.path");
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

	public String getIndexPath() {
		return indexPath;
	}

}
