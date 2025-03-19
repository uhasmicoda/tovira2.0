package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientPage {
	WebDriver driver;
	public ManagePatientPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement ManagePatient;
	public WebElement getManagePatient() {
		return ManagePatient;
	}
	
}
