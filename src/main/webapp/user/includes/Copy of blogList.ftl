
  <#list blogs?if_exists?sort_by('createTime')?reverse as blog>
	  	<div class="blogSection">
	  		<div class="blogTitle">
	  			<h2><a href="Blog_view.action?blogId=${blog.id}" target="_blank">${blog.title?if_exists}</a></h2>
	  		</div>
	  		<div class="blogSubTitle">
	  			<span class="blogAuthor"><@s.text name="author"/>: ${blog.author.username?if_exists}| </span>
	  			<span class="blogCreateTime"><@s.text name="time"/>: ${blog.createTime?if_exists?string('yyyy-MM-dd hh:mm:ss')}|</span>
	  			<span ><a href="Blog_edit.action?blogId=${blog.id}"><@s.text name="Edit"/></a></span>
	  		</div>
	  		<div class="blogContent">
	  			${blog.content?if_exists}
	  		</div>
	  		<div class="blogFooter">
	  			<span class="blogKeyWords"><@s.text name="keyWord"/>: ${blog.keyWords?if_exists} |</span>
	  			<span class="blogTag"><@s.text name="tag"/>: ${blog.tags?if_exists} |</span>
	  			<span class="comment"><@s.text name="comment"/>: <a href="#"> ${blog.comments?if_exists?size}</a></span>
	  		</div>
	  	</div>
	</#list>