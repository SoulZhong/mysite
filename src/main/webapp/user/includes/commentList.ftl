

	<@s.form name="commentForm" action="Comment_create.action">
		<#if blogId?has_content>
			<@s.hidden name="comment.blog.id" value="${blogId}"/>
		<#else>
			<@s.hidden name="comment.blog.id"/>
		</#if>
		<table style="color: #fff;">
			<tr>
				<td>${action.getText('username')}</td><td><@s.textfield  name="username"  theme="css_xhtml"/></td>
			</tr>
			<tr>
				<td>${action.getText('email')}</td><td><@s.textfield  name="email"  theme="css_xhtml"/></td>
			</tr>
			<tr>
				<td>${action.getText('comment')}</td><td width="80%"><@s.textarea name="comment.value" theme="css_xhtml" /></td>
			</tr>
		</table>			
		
	
		
	
	
		<input type='submit' value="${action.getText('sendMsg')}"/>
	
	</@s.form>
	
	
	<#list comments?if_exists?sort_by("updateTime")?reverse as comment>
		<div class="msgSection">
			<div class="userInfo">
				<a href="mailto:${comment.account?if_exists.email?if_exists}">@${comment.account?if_exists.username?if_exists}</a> 
				<span class="date">${comment.updateTime?if_exists?string('yyyy-MM-dd hh:mm:ss')}</span>
				<!--input type="image" class="right" src="${base}/images/delete.gif" /--> 
			</div>
			<div class="comment">
				${comment.value?if_exists}
			</div>
		</div>
	</#list>