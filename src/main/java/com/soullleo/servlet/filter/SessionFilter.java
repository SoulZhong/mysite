/**
 * 
 */
package com.soullleo.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soullleo.website.util.Constant;

/**
 * @author Soul
 * @date 2011-12-3
 */
public class SessionFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute(Constant.LOGIN_ACCOUNT) == null ){
			((HttpServletResponse)response).sendRedirect(Constant.LOGIN_URL);
			
		}else{
			filterChain.doFilter(request, response);
		}
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
