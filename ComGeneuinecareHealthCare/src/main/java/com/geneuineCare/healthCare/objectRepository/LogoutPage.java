package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver;
public LogoutPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[@class='username']")
private WebElement ProfileEdt;
@FindBy(xpath = "//a[contains(text(),'Log Out')]")
private WebElement Logout;
public WebElement getProfileEdt() {
	return ProfileEdt;
}
public WebElement getLogout() {
	return Logout;
}

public void LogoutFromApp() {
	ProfileEdt.click();
	Logout.click();
}
}
