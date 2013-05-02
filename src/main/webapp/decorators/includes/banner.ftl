<div class="banner">
	<@s.text name="home.title1" />
	<img src="${base}/images/flag.jpg" style="width:99px; height:66px;" />
	<@s.text name="home.title2"/>
</div> 

<div id="loginArea">
<#--
	<#if Session['_LOGIN_ACCOUNT_']?exists>
		<@s.text name="welcome"  theme="simple"/> 
		<span class="accountInfo">
			<#include "Account_info.ftl"/>
		</span>
	<#else>
		<#include "Account_login.ftl" />
	</#if>
 -->
</div>
<div id="languageSelector">
	<#include "languageSelector.ftl"/>
</div>