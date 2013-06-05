		
	<@s.form name="commentForm" action="Comment_create.action">
		<@s.hidden name="comment.blog.id" value="${blog.id}"/>
							
		<@s.textfield label="${action.getText('username')}" name="username"  theme="css_xhtml"/>
	
		<@s.textfield label="${action.getText('email')}" name="email"  theme="css_xhtml"/>
	
		<@s.textarea label="${action.getText('comment')}" cols="3" rows="2" name="comment.value" theme="css_xhtml" />		
	
		<input type="submit" value="${action.getText('sendMsg')}"/>
	
	</@s.form>