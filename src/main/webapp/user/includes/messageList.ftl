
<#list messages?if_exists?sort_by("updateTime")?reverse as message>
		<div class="msgSection">
			<div class="userInfo">
				<a href="mailto:${message.account?if_exists.email?if_exists}">@${message.account?if_exists.username?if_exists}</a> 
				<span class="date">${message.updateTime?if_exists?string('yyyy-MM-dd hh:mm:ss')}</span>
				<!--input type="image" class="right" src="${base}/images/delete.gif" /--> 
			</div>
			<div class="message">
				${message.value?if_exists}
			</div>
		</div>
</#list>