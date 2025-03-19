package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geneuineCare.healthCare.javaUtility.Javautility;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class PatientAppointmentPage {
	WebDriverUtility wu = new WebDriverUtility();
	Javautility ju = new Javautility();
	WebDriver driver;

	public PatientAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.=' Book Appointment ']")
	private WebElement PatientApointBtn;
	@FindBy(name = "Doctorspecialization")
	private WebElement SpecializatonDp;
	@FindBy(name = "doctor")
	private WebElement DoctorDp;
	@FindBy(name = "appdate")
	private WebElement AppointmenDate;
	@FindBy(name = "submit")
	private WebElement SubmitBtm;
	public WebElement getPatientApointBtn() {
		return PatientApointBtn;
	}
	public WebElement getSpecializatonDp() {
		return SpecializatonDp;
	}
	public WebElement getDoctorDp() {
		return DoctorDp;
	}
	public WebElement getAppointmenDate() {
		return AppointmenDate;
	}
	public WebElement getSubmitBtm() {
		return SubmitBtm;
	}

	public void getAppointment() {
		PatientApointBtn.click();
		wu.dropDown(SpecializatonDp, "Dermatologist");
	    
		wu.scroll(driver, 0, 250);
		wu.dropDown(DoctorDp, "9");
		AppointmenDate.click();
	    String date = ju.getRequiredDateYYMMDD(30);
	    AppointmenDate.sendKeys(date);
	    SubmitBtm.click();
	    
	}
	

}
