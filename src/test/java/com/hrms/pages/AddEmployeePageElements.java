package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements {

	@FindBy (id="firstName")
	public WebElement firstName;
	@FindBy (id="lastName")
	public WebElement lastName;
	@FindBy (id="user_name")
	public WebElement username;
	@FindBy (id="user_password")
	public WebElement password;
	@FindBy (id="re_password")
	public WebElement passConfirm;
	@FindBy (id="btnSave")
	public WebElement saveBtn;
	@FindBy (id="chkLogin")
	public WebElement loginCheckbox;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
