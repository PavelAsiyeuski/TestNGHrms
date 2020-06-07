package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ReportPageElements extends CommonMethods{


	@FindBy (id="menu_core_viewDefinedPredefinedReports")
	public WebElement reportBtn;
	
	@FindBy (name="btnAdd")
	public WebElement addReportBtn;
	
	@FindBy (id="report_report_name")
	public WebElement reportName;
	
	@FindBy (id="report_criteria_list")
	public WebElement empCriteria;

	@FindBy (xpath="//fieldset/ol/li/select[@id='report_include_comparision']")
	public WebElement empInclude;
	
	@FindBy (id="report_display_groups")
	public WebElement fieldGroups;
	
	@FindBy (id="report_display_field_list")
	public WebElement fieldList;
	
	@FindBy (id="btnAddDisplayField")
	public WebElement addDispFieldCheckbox;
	
	@FindBy (id="btnSave")
	public WebElement saveBtn;
	
	public ReportPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}

