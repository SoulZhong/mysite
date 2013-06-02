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
public class TestServer {

	private static String webapp = "/home/soul/git/mysite";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Server server = new Server(9999);

		WebAppContext context = new WebAppContext();
		context.setDescriptor(webapp + "/src/main/webapp/WEB-INF/web.xml");

		context.setResourceBase(webapp + "/src/main/webapp");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);

		server.setHandler(context);
		server.start();
		server.join();

	}

}
