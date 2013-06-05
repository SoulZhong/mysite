<html>
	<head>	
 	   <link rel="stylesheet" type="text/css"  href="${base}/css/favoriteStyle.css"/>
    </head>
    <body>
		<div class="msgContent">
			<fieldset>
				<legend><@s.text name="leaveMeAFavorite"/> </legend>
				<div class="msgCreator">
					<#include "includes/favoriteCreator.ftl" />
				</div>
			</fieldset>
			<fieldset>
				<legend><@s.text name="allFavorite"/> </legend>
				<div id="favoriteList">
					<#include "includes/favoriteList.ftl"/>
				</div>
			</fieldset>
		</div>
	</body>
</html>