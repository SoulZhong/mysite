/**
 * 
 */
package com.soullleo.weibo;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			String code = request.getParameter("code");
			if (code != null) {
				System.out.println("code>>>>>>>>>>>>>>>>>>>" + code);

				Oauth oauth = new Oauth();
				AccessToken accessToken = oauth.getAccessTokenByCode(code);
				
				System.out.println("accessToken>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.\n"+accessToken);
				
				OAuth.instance.setAccess_token(accessToken.getAccessToken());
			}
			
			response.getOutputStream().write(("code is " + code).getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
