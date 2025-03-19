package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class AddPatientPage {
	WebDriverUtility wu = new WebDriverUtility();
	WebDriver driver;

	public AddPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.=' Patients ']")
	private WebElement Patient;
	@FindBy(xpath = "//span[.=' Add Patient']")
	private WebElement AddPatient;
	@FindBy(name = "patname")
	private WebElement PatientName;
	@FindBy(name = "patcontact")
	private WebElement PatientContact;
	@FindBy(name = "patemail")
	private WebElement PatientEmail;
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement MaleRadioBtn;
	@FindBy(name = "pataddress")
	private WebElement PatientAdd;
	@FindBy(name = "patage")
	private WebElement PatientAge;
	@FindBy(name = "medhis")
	private WebElement PatientHistory;
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	@FindBy(xpath = "//span[.=' Search ']")
	private WebElement Psearch;
	@FindBy(name = "searchdata")
	private WebElement SearchInput;
	@FindBy(xpath = "//button[@name='search']")
	private WebElement SearchBtn;
	@FindBy(xpath = "//tbody//td[@class='hidden-xs']")
	private WebElement PatientVerify;

	public WebElement getPatient() {
		return Patient;
	}

	public WebElement getPatientName() {
		return PatientName;
	}

	public WebElement getPatientContact() {
		return PatientContact;
	}

	public WebElement getPatientEmail() {
		return PatientEmail;
	}

	public WebElement getAddPatient() {
		return AddPatient;
	}

	public WebElement getPatientAge() {
		return PatientAge;
	}

	public WebElement getPatientHistory() {
		return PatientHistory;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getPsearch() {
		return Psearch;
	}

	public WebElement getPatientVerify() {
		return PatientVerify;
	}

	public WebElement getSearchInput() {
		return SearchInput;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	
	public void createPatients(String name, String contact, String email, String address, String age, String history) {
		PatientName.sendKeys(name);
		PatientContact.sendKeys(contact);
		PatientEmail.sendKeys(email);
		wu.scroll(driver, 0, 200);
		MaleRadioBtn.click();
		PatientAdd.sendKeys(address);
		PatientAge.sendKeys(age);
		PatientHistory.sendKeys(history);
		SubmitBtn.click();

	}

	public void serachPatienbyName(String name) {
		Psearch.click();
		SearchInput.sendKeys(name);
		SearchBtn.click();
	}
	public void serachPatienbyContact(String contatc) {
		Psearch.click();
		SearchInput.sendKeys(contatc);
		SearchBtn.click();
	}
	
}
