package weibo4j.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WeiboConfig {

	// client_ID=3245068272
	// client_SERCRET=96cc479641d90e1b47e055328c64c60a
	// redirect_URI=http://www.soullleo.com/sina
	// baseURL=https://api.weibo.com/2/
	// accessTokenURL=https://api.weibo.com/oauth2/access_token
	// authorizeURL=https://api.weibo.com/oauth2/authorize
	// rmURL=https://rm.api.weibo.com/2/

	private String clientId;
	private String clientSercret;
	private String redirectURI;
	private String baseURL;
	private String accessTokenURL;
	private String authorizeURL;
	private String rmURL;

	private WeiboConfig() {
	}

	public static WeiboConfig instance = new WeiboConfig();
	private static Properties props = new Properties();
	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}

	public static Properties getProps() {
		return props;
	}

	public String getClientId() {
		if (this.clientId == null) {
			this.clientId = getValue("client_ID");
		}
		return clientId;
	}

	public String getClientSercret() {
		if (this.clientSercret == null) {
			this.clientSercret = getValue("client_SERCRET");
		}
		return clientSercret;
	}

	public String getRedirectURI() {
		if (this.redirectURI == null) {
			this.redirectURI = getValue("redirect_URI");
		}
		return redirectURI;
	}

	public String getBaseURL() {
		if (this.baseURL == null) {
			this.baseURL = getValue("baseURL");
		}
		return baseURL;
	}

	public String getAccessTokenURL() {
		if (this.accessTokenURL == null) {
			this.accessTokenURL = getValue("accessTokenURL");
		}
		return accessTokenURL;
	}

	public String getAuthorizeURL() {
		if (this.authorizeURL == null) {
			this.authorizeURL = getValue("authorizeURL");
		}
		return authorizeURL;
	}

	public String getRmURL() {
		if (this.rmURL == null) {
			this.rmURL = getValue("rmURL");
		}
		return rmURL;
	}

}
