package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class DeleteDoctorPage {
	WebDriverUtility wd = new WebDriverUtility();
	WebDriver driver;

	public DeleteDoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'data deleted !!')]")
	private WebElement DeleteMessage;
	public WebElement getDeleteMessage() {
		return DeleteMessage;
	}

	@FindBy(xpath = "//span[.=' Doctors ']")
	private WebElement DoctorClick;
	@FindBy(xpath = "//span[.=' Manage Doctors ']")
	private WebElement ManageClick;

	public WebElement getDoctorClick() {
		return DoctorClick;
	}

	public WebElement getManageClick() {
		return ManageClick;
	}

	public void deleteDoctor() {
		DoctorClick.click();
		ManageClick.click();

	}
}
