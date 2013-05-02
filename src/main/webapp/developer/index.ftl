
<@s.fielderror/>
<div class="app">
	<h3>Task List</h3>
	<hr/>
	<@s.form name="summaryMonthlyReport" action="summaryMonthlyReport" method="POST">
		<@s.textfield label="Month" name="month"  onfocus="showDatePicker(this,event);" class="flatTextField"/>
		<br/>	
		<@s.submit name="summaryMonthlyReport" value="Summary Monthly Report"/>			
	</@s.form>
	<hr/>
	<@s.form name="importEAIForm" action="importEAI" method="POST">
		<@s.textfield label="Date" name="date"  onfocus="showDatePicker(this,event);" class="flatTextField"/>
		<br/>
		<@s.select label="Site" name="site" list="siteList"/>		
		<@s.submit name="importEAIInformation" value="Import EAI Information"/>			
	</@s.form>
	<hr/>
	<@s.form name="importEAIForm1" action="importEAIByDate" method="POST">
		<@s.textfield label="From Date" name="fromDate"  onfocus="showDatePicker(this,event);" class="flatTextField"/>
		<@s.textfield label="To Date" name="toDate"  onfocus="showDatePicker(this,event);" class="flatTextField"/>
		<br/>
		<!--@s.select label="Site" name="site" list="siteList"/-->		
		<@s.submit name="importEAIInformationByDate" value="Import EAI Information By Date"/>			
	</@s.form>
	
	<!--		-->
		<hr/>
		<a href="securityComeIn.action">Security Maintain</a>
		<hr/>
		<a href="permissionComeIn.action">Permisstion Maintain</a>
		<hr/>
		<a href="importShiftTypeFromEAI.action">Import ShiftType Form EAI System</a>
		<hr/>
		<a href="deleteResignPerson.action">Delete Resign Person</a>
		<hr/>
		<a href="taskComeIn.action">Task Information</a>
		<hr/>
</div>