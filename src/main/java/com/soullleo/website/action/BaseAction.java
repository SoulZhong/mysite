/**
 * 
 */
package com.soullleo.website.action;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soullleo.website.domain.Account;
import com.soullleo.website.util.Constant;

/**
 * @author Soul
 * @date 2011-10-25
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final static String DONE = "done";
	protected Account getLoginAccount(){
		
		return (Account) ActionContext.getContext().getSession().get(Constant.LOGIN_ACCOUNT);
	}
	
	protected String getClientIp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String ip = request.getHeader("x-forwarded-for");
		
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	        ip = request.getRemoteAddr();
	    }
	    
	    return ip; 
	}
	
	public Map<String, Locale> getLocales() {
	       Map<String, Locale> locales =new Hashtable<String, Locale>(2);
	       locales.put("English", Locale.US);
	       locales.put("简体中文", Locale.CHINA);
	       return locales;
	}

}
