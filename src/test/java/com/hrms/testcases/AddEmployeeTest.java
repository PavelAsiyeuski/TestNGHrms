package com.hrms.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods{
	
	@Test(dataProvider="employee")
	public void loginTest(String firstName,String lastName,String username,String pass) throws IOException {
//	test.info("Logging in on website...");
		login.login("Admin","Hum@nhrm123");
	wait(3);
	click(driver.findElement(By.linkText("PIM")));
	wait(2);
	click(driver.findElement(By.linkText("Add Employee")));
	wait(2);
	sendText(addEmp.firstName, firstName);
	sendText(addEmp.lastName,lastName);
	click(addEmp.loginCheckbox);
	sendText(addEmp.username,username);
	sendText(addEmp.password,pass);
	sendText(addEmp.passConfirm,pass);
	click(addEmp.saveBtn);
	wait(3);
//	test.info("Creating a screenshot...");
	takeScreenshot("addEmployee");
		Assert.assertTrue(driver.findElement(By.id("empPic")).isDisplayed());
	}
	
	@DataProvider
	public Object [][] employee(){
		Object[][] data= {
				{"Paul","Walker","PaulDG","10293847Qazwsx!!"},
				{"Magie","Hop","MaggieDH","10293847Qazwsx!!"},
				{"Justin","Timberlake","JustDinT","10293847Qazwsx!!"},
				{"Robbie","Mar","RobbiDeM","10293847Qazwsx!!"},
				{"John","Smith","JohnFMM","10293847Qazwsx!!"}
		};
		return data;
	}
	
	@DataProvider(name="userDataFromExcel")
	public Object [][] getData(){
		return  ExcelUtility.excelToArray(Constants.TESTDATA_FILEPATH,"Sheet1");
		
	}
}
