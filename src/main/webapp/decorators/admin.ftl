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
                               <#include "includes/navigation.ftl" />                          
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
        
  </body> 
</html>