<@s.form action="Account_login" cssStyle="float: left;">
	${action.getText('username')}: <@s.textfield name="account.username" nameValue="${action.getText('username')}" cssClass="w80px" />
	${action.getText('password')}: <@s.password name="account.password" cssClass="w80px"/>
	<input type="submit" value="${action.getText('login')}"/>
</@s.form>