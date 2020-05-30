package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {
	public static WebDriver driver;
	@BeforeMethod
public static WebDriver setUp () {
	ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
	ConfigsReader.getProperty("browser").toLowerCase();
	switch(ConfigsReader.getProperty("browser").toLowerCase()) {
	case "chrome":
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		driver=new ChromeDriver();
		break;
	case "firefox":
		System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER_PATH);
		driver=new FirefoxDriver();
		break;
		default:
			throw new RuntimeException("Browser is not supported");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	driver.get(ConfigsReader.getProperty("url"));
	
	PageInitializer.initialize();
	return driver;
	
}

	@AfterMethod
	public static void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}

}
