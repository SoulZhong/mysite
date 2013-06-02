/**
 * 
 */
package com.soullleo.server.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Soul
 * @date May 30, 2013
 */
public class SimpleServer {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Config config;
		if(args.length > 0){
			config = new Config(args[0]);
		}else{
			config = new Config(SimpleServer.class.getClassLoader().getResourceAsStream("config.properties"));
		}

		Server server = new Server(config.getPort());

		WebAppContext context = new WebAppContext();
		context.setDescriptor(config.getWebfilepath());
		context.setResourceBase(config.getResourcepath());
		context.setContextPath(config.getContextpath());
		context.setParentLoaderPriority(true);

		server.setHandler(context);
		server.start();
		server.join();

	}

}
