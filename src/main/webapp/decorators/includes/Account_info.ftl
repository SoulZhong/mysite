
<@s.url id="logoutURL" value="Account_logout.action"/>
	${Session["_LOGIN_ACCOUNT_"].username?if_exists}
<@sx.a href="%{logoutURL}" targets="loginArea" cssClass="logout"><@s.text name="logout"/></@sx.a>