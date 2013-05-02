
<div>
	<form action="Account_login.action">
		<div><@s.text name="username"/><input type="text" name="account.username"/></div>
		<div><@s.text name="password"/><input type="password" name="account.password"/></div>
		<div><input type="submit" value="${action.getText('submit')}"/></div>
	</form>
</div>