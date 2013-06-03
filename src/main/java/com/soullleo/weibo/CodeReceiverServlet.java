/**
 * 
 */
package com.soullleo.weibo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Soul
 * @date Jun 3, 2013
 */
public class CodeReceiverServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6677972495568450221L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		if(code != null){
			System.out.println("code>>>>>>>>>>>>>>>>>>>"+code);
		}
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		doGet(request, response);
	}
	
	
}
