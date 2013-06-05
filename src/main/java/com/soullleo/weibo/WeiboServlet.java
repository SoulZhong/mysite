/**
 * 
 */
package com.soullleo.weibo;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weibo4j.util.WeiboConfig;

/**
 * @author Soul
 * @date Jun 5, 2013
 */
public class WeiboServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5234727225748584688L;
	private static final WeiboConfig config = WeiboConfig.instance;

	@Override
	public void init() {

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		String action = request.getParameter("do");
		// https://api.weibo.com/oauth2/authorize?client_id=1742025894&redirect_uri=https%3A%2F%2Fsegmentfault.com%2Fuser%2Foauth%2Fweibo&scope=all

		if ("login".equals(action)) {

			try {
				StringBuffer tmpURL = new StringBuffer(config.getAuthorizeURL())
						.append("?client_id=")
						.append(config.getClientId())
						.append("&scope=all")
						.append("&redirect_uri=")
						.append(URLEncoder.encode(config.getRedirectURI(),
								"UTF-8"));
				
				System.out.println(">>>>>>>>>>>>>>>" + tmpURL.toString());
				response.sendRedirect(tmpURL.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
