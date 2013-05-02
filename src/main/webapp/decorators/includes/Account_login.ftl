<@s.form action="Account_login" cssStyle="float: left;">
	${action.getText('username')}: <@s.textfield name="account.username" nameValue="${action.getText('username')}" cssClass="w80px" />
	${action.getText('password')}: <@s.password name="account.password" cssClass="w80px"/>
	<@sx.submit type="submit" theme="ajax" targets="loginArea" value="${action.getText('login')}"/>
</@s.form>