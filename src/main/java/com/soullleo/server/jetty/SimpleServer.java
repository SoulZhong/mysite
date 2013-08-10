/**
 * 
 */
package com.soullleo.server.jetty;

import java.io.File;
import java.io.FileInputStream;

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

		if(args.length > 0){
			Config.INSTANCE.load(new FileInputStream(args[0]));
		}else{
			Config.INSTANCE.load(SimpleServer.class.getClassLoader().getResourceAsStream("config.properties"));
		}

		Server server = new Server(Config.INSTANCE.getPort());

		WebAppContext context = new WebAppContext();
		context.setDescriptor(Config.INSTANCE.getWebfilepath());
		context.setResourceBase(Config.INSTANCE.getResourcepath());
		context.setContextPath(Config.INSTANCE.getContextpath());
		context.setParentLoaderPriority(true);

		server.setHandler(context);
		server.start();
		server.join();

	}

}
