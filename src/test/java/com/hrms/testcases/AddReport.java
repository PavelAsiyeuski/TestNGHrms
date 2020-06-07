package com.hrms.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class AddReport extends CommonMethods{

	//As an Admin I should be able to define different Reports
	
	@Test
	public void createReport() {
		driver.manage().window().maximize();
		test.info("Logging in on website...");
		login.login("Admin", "Hum@nhrm123");
		test.info("Navigating to Report tab");
		click(dashboard.PIM);
		wait(1);
		click(report.reportBtn);
		wait(2);
 		test.info("Creating a new report");
		click(report.addReportBtn);
		sendText(report.reportName,"Test Report");
		Select empNameSelect=new Select(report.empCriteria);
		test.info("Checking every option in Criteria Dropdowns");
		for (int i=0;i<empNameSelect.getOptions().size();i++) {
	    empNameSelect.selectByIndex(i);
		}
		Select includeSelect=new Select(report.empInclude);
		for (int i=0;i<includeSelect.getOptions().size();i++) {
			includeSelect.selectByIndex(i);
		}
		Select dispGroupSelect=new Select(report.fieldGroups);
		for (int i=0;i<dispGroupSelect.getOptions().size();i++) {
			dispGroupSelect.selectByIndex(i);
		}
		Select fieldSelect=new Select(report.fieldList);
		for (int i=0;i<fieldSelect.getOptions().size();i++) {
			fieldSelect.selectByIndex(i);
		}
		test.info("Adding Display Fields");
		click(report.addDispFieldCheckbox);
		click(report.saveBtn);
		wait(2);
		takeScreenshot("addEmp");
		Assert.assertTrue(driver.findElement(By.xpath("//td [text()='Test Report']")).isDisplayed());
		
}
}
