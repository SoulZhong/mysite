<@s.form name="messageForm" action="Message_create.action">
						
	<@s.textfield label="${action.getText('username')}" name="username"  theme="css_xhtml"/>

	<@s.textfield label="${action.getText('email')}" name="email"  theme="css_xhtml"/>

	<@s.textarea label="${action.getText('comment')}" cols="3" rows="2" name="message.value" theme="css_xhtml" />		

	<@sx.submit targets="msgList" value="${action.getText('sendMsg')}" theme="ajax" />

</@s.form>

<script type="text/javascript" >

	function cleanInput(){
	}
</script>