/**
 * 
 */
package com.soullleo.struts.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.soullleo.website.util.Constant;

/**
 * @author Soul
 * @date 2011-12-3
 */

public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 4776361900026731626L;


	public String intercept(ActionInvocation actioninvocation) throws Exception {


		Map<String, Object> session = actioninvocation.getInvocationContext().getSession();
		Object obj = session.get(Constant.LOGIN_ACCOUNT);
		
		if (obj == null) {
			String url = ServletActionContext.getRequest().getRequestURI();
			
			session.put(Constant.REQUEST_URL, url);
			
			//return Action.LOGIN;
			return "noPermission";
		} else
			return actioninvocation.invoke();
	}

}
