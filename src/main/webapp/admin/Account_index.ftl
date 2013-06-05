<html>
	<head>
	    <link rel="stylesheet" type="text/css"  href="${base}/css/sortabletable.css"/>
	    <script type="text/javascript" src="${base}/js/sortabletable.js"></script> 
    </head>
    <body>
    
    		<@s.form action="Account_create.action">
				<table id="accountInput">
					<tr>
						<th><@s.text name="role"/></th><td><@s.textfield name="account.role"  theme="css_xhtml"/></td>
					</tr>
					<tr>
						<th><@s.text name="username"/></th><td><@s.textfield name="account.username"  theme="css_xhtml"/></td>
					</tr>
					<tr>
						<th><@s.text name="password"/></th><td><@s.textfield name="account.password"  theme="css_xhtml"/></td>
					</tr>
					<tr>
						<th><@s.text name="email"/></th><td><@s.textfield name="account.email"  theme="css_xhtml"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="${action.getText('submit')}"/>
						</td>
					</tr>
				</table>
			</@s.form>
			<div id="accountList">			
				<#include "includes/accountList.ftl"/>							
			</div>

	</body>
<html>