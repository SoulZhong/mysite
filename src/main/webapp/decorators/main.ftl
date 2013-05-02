<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
  		<#include "includes/header.ftl"/>
  	</head>
  <body>
          <#include "includes/banner.ftl"/>
          
          <!-- chalkboard -->
          <div id="chalkboard">
	            <img id="eraser1" src="${base}/images/eraser.gif"/>
	            <img id="chalk1" src="${base}/images/chalk.gif"/>  
                <!-- content -->
                <div id="content">
                
                <!--left content-->
                  <div id="leftContent">  
                      <#include "includes/leftSide.ftl"/>
                  </div>
                  <!-- left content-->
                                    
                  <!-- outWrapper -->
                  <div id="outWrapper">      
                  <!-- innerWrapper -->
                      <div id="innerWrapper">
                          <!-- rightContent -->
                          <div id="rightContent"> 
                               <#include "includes/rightSide.ftl" />                          
                          </div>
                          <!-- rightContent -->
                       
                          <div id="middleWrapper">
                              <div id="middleContent">
                              		${body}
                              </div> 
                          </div>  
                          
                      </div>
                      <!-- innerWrapper -->
               </div>
               <!-- outWrapper -->
                
               <!-- footer --> 
               <div id="footer">
              	 <#include "includes/footer.ftl"/>
   			   </div>
               <!-- footer -->                      
          </div>
          <!-- content -->
        </div>
        <!-- chalkboard -->
        
			���ǵ�<!-- GoStats JavaScript Based Code -->
<script type="text/javascript" src="http://gostats.cn/js/counter.js"></script>
<script type="text/javascript">_gos='c3.gostats.cn';_goa=355230;
_got=7;_goi=3;_goz=0;_god='visitors';_gol='����ͳ��Դ��';_GoStatsRun();</script>
<noscript><a target="_blank" title="����ͳ��Դ��" 
href="http://gostats.cn"><img alt="����ͳ��Դ��" 
src="http://c3.gostats.cn/bin/count/a_355230/t_7/i_3/z_0/show_visitors/counter.png" 
style="border-width:0" /></a></noscript>
<!-- End GoStats JavaScript Based Code -->λ������
			
			<!-- ShareTo Button BEGIN -->
<script type="text/javascript" src="http://s.shareto.com.cn/js/shareto_float.js#color=0&align=left&move=1" charset="utf-8"></script> 
<!-- ShareTo Button END -->
			
        <!-- Baidu statistic -->
        <script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F9517307949872e77022e1769467088eb' type='text/javascript'%3E%3C/script%3E"));
</script>

<script src="http://s9.cnzz.com/stat.php?id=3819647&web_id=3819647&show=pic" language="JavaScript"></script>     
        
<script type="text/javascript" src="${base}/js/jquery-1.3.2.min.js"></script> 
<script type="text/javascript" src="${base}/js/jquery-ui-1.7.3.custom.min.js"></script>  
<script type="text/javascript" src="${base}/js/clock.js"></script> 
<script type="text/javascript"> 
       $(document).ready(function() {           
            clock();
            $("#eraser1").draggable();
            $("#chalk1").draggable();
        });
</script>
  </body> 
</html>