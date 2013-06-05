<@s.form name="favoriteForm" action="Favorite_create.action">
	<table style="color: #fff;">
		<tr>
			<td>${action.getText('name')}</td><td><@s.textfield  name="favorite.name"  theme="css_xhtml"/></td>
		</tr>
		<tr>
			<td>${action.getText('description')}</td><td><@s.textfield name="favorite.description"  theme="css_xhtml"/></td>
		</tr>
		<tr>
			<td>${action.getText('url')}</td><td><@s.textfield  name="favorite.url"  theme="css_xhtml"/></td>
		</tr>
	</table>					
		
	<input type="submit" value="${action.getText('save')}" />

</@s.form>