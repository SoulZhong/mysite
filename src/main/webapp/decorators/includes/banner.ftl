<div class="banner">
	<@s.text name="home.title1" />
	<img src="${base}/images/flag.jpg" style="width:99px; height:66px;" />
	<@s.text name="home.title2"/>
</div> 


<div id="loginArea">
<div id="showarea"></div>

</div>

<script type='text/javascript'>
WB2.anyWhere(function(W){
    W.widget.connectButton({
        id: "showarea",
        type: '3,2',
        callback : {
            login:function(o){
//                alert(o.screen_name)
            },
            logout:function(){
//                alert('logout');
            }
        }
    });
});
</script>


<div id="languageSelector">
	<#include "languageSelector.ftl"/>
</div>