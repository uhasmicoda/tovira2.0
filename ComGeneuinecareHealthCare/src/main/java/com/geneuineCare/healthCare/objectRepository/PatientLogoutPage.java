package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLogoutPage {

	WebDriver driver;

	public PatientLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='username']")
	private WebElement ProfileEdt;
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement PatientLogout;
	@FindBy(xpath = "//h6[.='Patient Login']/..//button[.='Click Here']")
	private WebElement PatientLoginBtn;
	@FindBy(xpath = "//span[text()='You have successfully logout']")
	private WebElement LogoutMessage;

	public WebElement getLogoutMessage() {
		return LogoutMessage;
	}

	public WebElement getPatientLoginBtn() {
		return PatientLoginBtn;
	}

	public WebElement getProfileEdt() {
		return ProfileEdt;
	}

	public WebElement getPatientLogout() {
		return PatientLogout;
	}

	public void logoutPatient() {
		ProfileEdt.click();
		PatientLogout.click();
	}
}
