package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	WebDriver driver;
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	@FindBy(name = "username")
	private WebElement UserName;
	@FindBy(name = "password")
	private WebElement Password;
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	public WebElement getUserName() {
		return UserName;
	}
	
	public WebElement getPassword() {
		return Password;
	}
	
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public void loginToAdmin(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		SubmitBtn.click();
	}
}
