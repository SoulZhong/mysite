
    <div id="navigation">
      <fieldset>
        <legend align="center"><@s.text name="home.menu"/></legend>
          <ul>
            <li><a href="${base}/user/index.action"><@s.text name="menu.home"/></a></li>
            <li><a href="${base}/user/Blog_index.action"><@s.text name="menu.blog"/></a></li>
            <li><a href="${base}/user/Contact_index.action"><@s.text name="menu.contact"/></a></li>
            <li><a href="${base}/user/Message_index.action"><@s.text name="menu.message"/></a></li>
            <li><a href="${base}/user/Favorite_index.action"><@s.text name="menu.favorite"/></a></li>
            <li><a href="${base}/user/Gallery_index.action" target="_blank"><@s.text name="menu.gallery"/></a></li>
            <!--li><a href="${base}/user/Resume_index.action"><@s.text name="menu.resume"/></a></li-->
          </ul>
      </fieldset>
    </div>
    
	<div class="friendsLink">
		<fieldset>
			<legend align="center"><@s.text name="friendsLink"/></legend>
			<ul style="text-align:left;">
				<li><a href="http://shop62182677.taobao.com" target="_blank">E.Zhong…Ëº∆(Ã‘±¶µÍ)</a></li>	
                <li><a href="http://blog.nxyouxi.com/" target="_blank">Mchen</a></li>
                <li><a href="http://www.nealjin.com/" target="_blank">Neal</a></li>
			</ul>
		</fieldset>
	</div>
	
	<!--  
  <div>
    <fieldset>
      <legend align="center"><@s.text name="blogList"/></legend>
		<ul>
		  	<#list last10Blogs?if_exists as blog>
				<li><a href="Blog_view.action?blogId=${blog.id}" target="_blank">${blog.title?if_exists}</a></li>
		  	</#list>
		</ul>
	</fieldset>
  </div>
  
  -->