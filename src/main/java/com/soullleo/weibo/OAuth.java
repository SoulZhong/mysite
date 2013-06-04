/**
 * 
 */
package com.soullleo.weibo;

/**
 * @author SoulLina
 * 
 */
public final class OAuth {

	private OAuth() {
	}

	public static OAuth instance = new OAuth();

	private final String client_ID = "3245068272";
	private final String client_SERCRET = "96cc479641d90e1b47e055328c64c60a";
	private volatile String access_token;

	public String getClient_ID() {
		return client_ID;
	}

	public String getClient_SERCRET() {
		return client_SERCRET;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
