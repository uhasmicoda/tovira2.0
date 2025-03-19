package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	WebDriver driver;
	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
@FindBy(partialLinkText ="Create ")	
private WebElement CreateActLink;
public WebElement getCreateActLink() {
	return CreateActLink;
}
}
