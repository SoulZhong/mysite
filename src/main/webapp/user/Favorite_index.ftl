<html>
	<head>
		<style type="text/css">
			#faqbg{
				background-color:#666666; 
				position:absolute; 
				z-index:99; 
				left:0; 
				top:0; 
				display:none; 
				width:100%;
				height:100%;
				opacity:0.5;
				filter: alpha(opacity=50);
				-moz-opacity: 0.5;
			}
			#faqdiv{
				position:absolute;
			/*	width:400px; */
				left:50%; 
				top:50%; 
				margin-left:-200px; 
				height:auto; 
				z-index:100000;
				background-color:#fff; 
				border:1px #8FA4F5 solid; 
				padding:1px;
			}
			#faqdiv h2{ 
				height:25px; 
				font-size:14px; 
				background-color:#8FA4F5; 
				position:relative; 
				padding-left:10px; 
				line-height:25px;
				cursor:move;
			}
			#faqdiv h2 a{
				position:absolute; 
				right:5px; 
				font-size:12px; 
				color:#FF0000
			}
			#faqdiv .form{
				padding:10px;
			}
			.close{
				cursor:pointer;
			}
			
			#favoriteMain{
				margin: auto;
				width: 180px;
				/*background-color: brown;*/
			}
			#favoriteMain ul{
				padding-left: 20px;
			}
			
			#favoriteMain li{
				text-align: left;
			}
		</style>
		<script type="text/javascript">
				function popDiv(){
					  $("#faqbg").css({display:"block"});
					  var yscroll =document.documentElement.scrollTop;
					  $("#faqdiv").css("top","10px");
					  $("#faqdiv").css("display","block");
					  document.documentElement.scrollTop=0;
	           		 $(".pop_box").draggable();
				}
					 
				 function closeDiv(){
					  $("#faqbg").css("display","none");
					  $("#faqdiv").css("display","none");
				 }			 
				
		</script>
	</head>
	<body>
		<div id="favoriteMain">
			<ul>
			<#list favorites?if_exists?sort_by("createTime")?reverse as favorite>
				<li><a href="${favorite.url?if_exists}" target="_blank">${favorite.description?if_exists}</a></li>
			</#list>
				<li><a href="http://114.251.109.193:8080/web" target="_blank">网上约车</a></li>
				<li><a href="http://www.ufula.com/index.html" target="_blank">免费代理</a></li>
				<li><a href="http://www.zhibo8.com" target="_blank">直播吧（体育视频直播录播）</a></li>	
				<li><a onclick="popDiv();">追梦人</a></li>			
			</ul>
			<!--iframe src="http://www.tudou.com/programs/view/popplayer.action?iid_code=Y9Vz4dklqBQ">追梦人</iframe-->
			<!--div><object id='sinaplayer' width='480' height='370' ><param name='allowScriptAccess' value='always' /><embed pluginspage='http://www.macromedia.com/go/getflashplayer' src='http://you.video.sina.com.cn/api/sinawebApi/outplayrefer.php/vid=71391551_6/s.swf' type='application/x-shockwave-flash' name='sinaplayer' allowFullScreen='true' allowScriptAccess='always' width='480' height='370'></embed></object></div-->
     		
			    		
			<div id="faqbg"></div>
			<div id="faqdiv" class="pop_box" style="display:none">
				<h2 class="p_head">追梦人<a class="close" onclick="closeDiv();">X</a></h2>
			    <div class="form">
			    	<iframe width="700px" height="600px" src="http://www.tudou.com/programs/view/popplayer.action?iid_code=Y9Vz4dklqBQ">追梦人</iframe>	
			    </div>
			</div>
		</div>
    </body>
 </html>