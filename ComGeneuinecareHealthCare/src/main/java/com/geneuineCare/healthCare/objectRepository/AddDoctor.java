package com.geneuineCare.healthCare.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class AddDoctor {
	WebDriverUtility wd = new WebDriverUtility();
	WebDriver driver;

	public AddDoctor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath = "//span[.=' Doctors ']")
    private WebElement DoctorClick;
    @FindBy(xpath = "//span[contains(text(), 'Add Doctor')]")
    private WebElement AddDoctorClick;
    public WebElement getDoctorClick() {
		return DoctorClick;
	}
	public WebElement getAddDoctorClick() {
		return AddDoctorClick;
	}
	
	@FindBy(name = "Doctorspecialization")
	private WebElement SpecializationDp;
	@FindBy(name = "docname")
	private WebElement DocName;
	@FindBy(name = "clinicaddress")
	private WebElement DocAddress;
	@FindBy(name = "docfees")
	private WebElement DocFees;
	@FindBy(name = "doccontact")
	private WebElement DocContact;
	@FindBy(name = "docemail")
	private WebElement DocMail;
	@FindBy(name = "npass")
	private WebElement DocPass;
	@FindBy(name = "cfpass")
	private WebElement DocCfPass;
	@FindBy(name = "submit")
	private WebElement SubmitBtn;

	public WebElement getSpecializationDp() {
		return SpecializationDp;
	}
	public WebElement getDocName() {
		return DocName;
	}
	public WebElement getDocAddress() {
		return DocAddress;
	}
	public WebElement getDocFees() {
		return DocFees;
	}
	public WebElement getDocContact() {
		return DocContact;
	}
	public WebElement getDocMail() {
		return DocMail;
	}
	public WebElement getDocPass() {
		return DocPass;
	}
	public WebElement getDocCfPass() {
		return DocCfPass;
	}
	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public void addDoctor(String name, String add, String fees, String contact, String mail, String pass, String cfPass) throws InterruptedException {
		wd.dropDown(SpecializationDp, "Dermatologist");
		DocName.sendKeys(name);
		DocAddress.sendKeys(add);
		DocFees.sendKeys(fees);    
		DocContact.sendKeys(contact);
		DocMail.sendKeys(mail);
		wd.scrollTillBottom(driver);
		DocPass.sendKeys(pass);
		DocCfPass.sendKeys(cfPass);
		SubmitBtn.click();
		Thread.sleep(2000);
		wd.switchToAlertAccept(driver);
	}
}
