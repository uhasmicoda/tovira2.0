package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	WebDriver driver;

	public DoctorLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement Username;
	@FindBy(name = "password")
	private WebElement Password;
	@FindBy(name = "submit")
	private WebElement SubmitBtn;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public void doctorLogin(String username, String password) {

		Username.sendKeys(username);
		Password.sendKeys(password);
		SubmitBtn.click();
	}

}
