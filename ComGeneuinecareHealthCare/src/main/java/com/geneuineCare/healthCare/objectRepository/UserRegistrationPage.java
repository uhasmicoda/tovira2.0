package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class UserRegistrationPage {
	WebDriverUtility wu = new WebDriverUtility();
	WebDriver driver;

	public UserRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "full_name")
	private WebElement PatientName;
	@FindBy(name = "address")
	private WebElement PatientAdd;
	@FindBy(name = "city")
	private WebElement PatientCit;
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement PatientGender;
	@FindBy(name = "email")
	private WebElement PatientEmail;
	@FindBy(name = "password")
	private WebElement PatientPass;
	@FindBy(name = "password_again")
	private WebElement PatientAgainPass;
	@FindBy(name = "submit")
	private WebElement submitBtm;

	public WebElement getPatientName() {
		return PatientName;
	}

	public WebElement getPatientAdd() {
		return PatientAdd;
	}

	public WebElement getPatientCit() {
		return PatientCit;
	}

	public WebElement getPatientGender() {
		return PatientGender;
	}

	public WebElement getPatientEmail() {
		return PatientEmail;
	}

	public WebElement getPatientPass() {
		return PatientPass;
	}

	public WebElement getPatientAgainPass() {
		return PatientAgainPass;
	}

	public WebElement getSubmitBtm() {
		return submitBtm;
	}

	public void creatUser(String name, String address, String city, String email, String pass, String passAgain) {
		PatientName.sendKeys(name);
		PatientAdd.sendKeys(address);
		PatientCit.sendKeys(city);
		PatientGender.click();
		PatientEmail.sendKeys(email);
		PatientPass.sendKeys(pass);
		PatientAgainPass.sendKeys(passAgain);
		wu.scroll(driver, 0, 200);
		submitBtm.click();

	}

}
