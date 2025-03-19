package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSpecializationPage {
WebDriver driver;
public DoctorSpecializationPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
private WebElement DoctorSpecialization;
@FindBy(name = "doctorspecilization")
private WebElement EnterSpecialization;
@FindBy(name = "submit")
private WebElement SubmtiBtn;
@FindBy(xpath = "//p[contains(text(),'data deleted !!')]")
private WebElement DeleteMessage;
public WebElement getDeleteMessage() {
	return DeleteMessage;
}
public WebElement getDoctorSpecialization() {
	return DoctorSpecialization;
}
public WebElement getEnterSpecialization() {
	return EnterSpecialization;
}
public WebElement getSubmtiBtn() {
	return SubmtiBtn;
}
public void createSpecialization(String specialization) {
	DoctorSpecialization.click();
	EnterSpecialization.sendKeys(specialization);
	SubmtiBtn.click();
}
}
