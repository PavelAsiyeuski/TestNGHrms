package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.testbase.PageInitializer;

public class LoginTest extends PageInitializer{

	
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
	
	@Test 
	public void validAdminLogin() {
		login.login("Admin","Hum@nhrm123");
		wait(2);
		String actualText=dashboard.welcome.getText();
		String expectedText="Welcome Admin";
		Assert.assertEquals(actualText,expectedText,"Admin is not Logged In");
	}
	
	@Test 
	public void invalidAdminLogin() {
		login.login("Admin","dfsdgfdsf");
		wait(2);
		String expectedText="Invalid credentials";
		String actualText=login.errorMsg.getText();
		Assert.assertEquals(actualText,expectedText,"Error message is not correct");
	}
	
	@Test 
	public void emptyUsername () {
		login.login("","sdfsdffdsf");
		String expectedText="Username cannot be empty";
		String actualText=login.errorMsg.getText();
		Assert.assertEquals(actualText,expectedText,"Error message is not correct");
	}
}
