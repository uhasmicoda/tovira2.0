package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class AddMedicalHistoryPage {
	WebDriverUtility wu = new WebDriverUtility();
	WebDriver driver;
	public AddMedicalHistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}

	@FindBy(name = "bp")
	private WebElement PatientBp;
	@FindBy(name = "bs")
	private WebElement PatientBs;
	@FindBy(name = "weight")
	private WebElement Patientweight;
	@FindBy(name = "temp")
	private WebElement PatientTemp;
	@FindBy(name = "pres")
	private WebElement PatientPresscription;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement SubmitBtn;

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getPatientBp() {
		return PatientBp;
	}

	public WebElement getPatientBs() {
		return PatientBs;
	}

	public WebElement getPatientweight() {
		return Patientweight;
	}

	public WebElement getPatientTemp() {
		return PatientTemp;
	}

	public WebElement getPatientPresscription() {
		return PatientPresscription;
	}
	public void addMedicalHistoryP(String bp, String bs, String weight, String temp, String prescription) {
		PatientBp.sendKeys(bp);
		PatientBs.sendKeys(bs);
		Patientweight.sendKeys(weight);
		PatientTemp.sendKeys(temp);
		PatientPresscription.sendKeys(prescription);
		wu.scrollTillBottom(driver);
		SubmitBtn.click();
		
	}

}
