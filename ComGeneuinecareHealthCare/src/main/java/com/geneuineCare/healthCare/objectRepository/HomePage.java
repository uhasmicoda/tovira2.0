package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[.='Home']/../..//a[.='Logins']")
	private WebElement LoginsBtn;
	@FindBy(xpath = "//h6[.='Patient Login']/..//button[.='Click Here']")
	private WebElement PatienLoginBtn;
	@FindBy(xpath = "//h6[.='Doctors login']/..//button[.='Click Here']")
	private WebElement DoctorLoginBtn;
	@FindBy(xpath = "//h6[.='Admin Login']/..//button[.='Click Here']")
	private WebElement AdminLoginBtn;

	public WebElement getLoginsBtn() {
		return LoginsBtn;
	}

	public WebElement getAdminLoginBtn() {
		return AdminLoginBtn;
	}

	public WebElement getDoctorLoginBtn() {
		return DoctorLoginBtn;
	}

	public WebElement getPatienLoginBtn() {
		return PatienLoginBtn;
	}

}
