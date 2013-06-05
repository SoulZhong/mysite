<html>
	<head>
		<link rel="stylesheet" type="text/css"  href="${base}/css/blogStyle.css"/>
		<link rel="stylesheet" type="text/css"  href="${base}/js/jquery-1.7.1.js"/>	
 	   <link rel="stylesheet" type="text/css"  href="${base}/css/messageStyle.css"/>	
	</head>
	<body>
	    <div class="blogMain">
			<div class="blogSection">
				<div class="blogTitle">
					<h2><a href="Blog_view.action?blogId=${blog.id}" target="_blank">${blog.title?if_exists}</a></h2>
				</div>
				<div class="blogSubTitle">
					<span class="blogAuthor"><@s.text name="author"/>: ${blog.author?if_exists.username?if_exists}| </span>
					<span class="blogCreateTime"><@s.text name="time"/>: ${blog.createTime?if_exists?string('yyyy-MM-dd hh:mm:ss')}</span>
					<span ><a href="Blog_edit.action?blogId=${blog.id}"><@s.text name="Edit"/></a></span>
				</div>
				<div class="blogContent">
					${blog.content?if_exists}
				</div>
				<div class="blogFooter">
					<span class="blogKeyWords"><@s.text name="keyWord"/>: ${blog.keyWords?if_exists} |</span>
					<span class="blogTag"><@s.text name="tag"/>: ${blog.tags?if_exists} |</span>
					<span class="comment"><@s.text name="comment"/>:${blog.comments?if_exists?size}</span>
				</div>
				<br/>
				<hr style="color: #fff;"/>
				<br/>
				<div id="commentList">
			    <#assign comments=blog.comments />
					<#include "includes/commentList.ftl" />
				</div>
			</div>
			    
	    </div>
	    
    </body>