package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CancelAppointmentPage {
WebDriver driver;
public CancelAppointmentPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}

}
