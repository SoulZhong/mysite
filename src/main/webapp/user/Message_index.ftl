<html>
	<head>	
 	   <link rel="stylesheet" type="text/css"  href="${base}/css/messageStyle.css"/>
	   <@sx.head theme="ajax" debug="true"/>
    </head>
    <body>
		<div class="msgContent">
			<fieldset>
				<legend><@s.text name="leaveMeAMessage"/> </legend>
				<div class="msgCreator">
					<#include "includes/messageCreator.ftl" />
				</div>
			</fieldset>
			<fieldset>
				<legend><@s.text name="allMessage"/> </legend>
				<div id="msgList">
					<#include "includes/messageList.ftl"/>
				</div>
			</fieldset>
		</div>
	</body>
</html>