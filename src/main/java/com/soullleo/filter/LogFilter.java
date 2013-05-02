/**
 * 
 */
package com.soullleo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Soul
 * @date 2011-11-27
 */
public class LogFilter implements Filter {

	private static Log log = LogFactory.getLog(LogFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = ((HttpServletRequest)req);
		long bef = System.currentTimeMillis();
		chain.doFilter(req, res);
		long aft = System.currentTimeMillis();
		log.info("request.getServerName() = " + request.getServerName());
		log.info("request.getServerPort() = " + request.getServerPort());
		log.info("request.getServletPath() = " + request.getServletPath());
		log.info("request.getRemoteAddr() = " + request.getRemoteAddr());
		log.info("request.getRemoteHost() = " + request.getRemoteHost());
		log.info("request.getRemoteUser() = " + request.getRemoteUser());

		log.info("Request to " + request.getRequestURI() 
				+ ": " + (aft - bef));
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
