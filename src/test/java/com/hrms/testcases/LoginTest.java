package com.hrms.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class LoginTest extends CommonMethods{

	
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//	 
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}
	
	@Test (groups="smoke")
	public void validAdminLogin() {
		login.login("Admin","Hum@nhrm123");
		wait(2);
		String actualText=dashboard.welcome.getText();
		String expectedText="Welcome Admin";
		Assert.assertEquals(actualText,expectedText,"Admin is not Logged In");
	}
	
	@Test (groups="regression")
	public void invalidAdminLogin() {
		login.login("Admin","dfsdgfdsf");
		wait(2);
		String expectedText="Invalid credentials";
		String actualText=login.errorMsg.getText();
		Assert.assertEquals(actualText,expectedText,"Error message is not correct");
	}
	
	@Test (groups="regression")
	public void emptyUsername () {
		login.login("","sdfsdffdsf");
		String expectedText="Username cannot be empty";
		String actualText=login.errorMsg.getText();
		Assert.assertEquals(actualText,expectedText,"Error message is not correct");
	}
	
	@Test 
	public void timeStamp() {
		Date d=new Date();
		d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		sdf.format(d.getTime());
	}
}
