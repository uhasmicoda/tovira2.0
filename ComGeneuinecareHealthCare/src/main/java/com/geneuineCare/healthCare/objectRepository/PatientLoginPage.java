package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	WebDriver driver;

	public PatientLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(), 'Log-in')]")
	private WebElement PLoginBtn;

	@FindBy(name = "username")
	private WebElement userNameEdt;
	@FindBy(name = "password")
	private WebElement passwordEdt;
	@FindBy(name = "submit")
	private WebElement submitBtn;

	public WebElement getPLoginBtn() {
		return PLoginBtn;
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void patienLogin(String username, String password) {
		PLoginBtn.click();
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();

	}
	public void patienLogin2(String username, String password) {
		
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();

	}
}
