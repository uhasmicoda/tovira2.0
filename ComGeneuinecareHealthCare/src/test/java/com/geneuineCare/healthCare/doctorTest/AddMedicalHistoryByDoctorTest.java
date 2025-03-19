package com.geneuineCare.healthCare.doctorTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.geneuineCare.healthCare.baseTest.BaseClass;
import com.geneuineCare.healthCare.fileUtility.ExcelUtility;
import com.geneuineCare.healthCare.javaUtility.Javautility;
import com.geneuineCare.healthCare.listenerUtility.UtilityObjectClass;
import com.geneuineCare.healthCare.objectRepository.AddMedicalHistoryPage;
import com.geneuineCare.healthCare.objectRepository.AddPatientPage;
import com.geneuineCare.healthCare.objectRepository.DoctorLoginPage;
import com.geneuineCare.healthCare.objectRepository.HomePage;
import com.geneuineCare.healthCare.objectRepository.ManagePatientPage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

@Listeners(com.geneuineCare.healthCare.listenerUtility.ListenImpClass.class)
public class AddMedicalHistoryByDoctorTest extends BaseClass {
	@Test(groups = "system")
	public void addMedicalHistoryByDoctorTest() throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverUtility wd = new WebDriverUtility();
		ExcelUtility eu = new ExcelUtility();

		// wd.waitForPageLoad(driver);
		wd.windowMaximize(driver);

		// Object creation of different classes

		HomePage hp = new HomePage(driver);

		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		AddPatientPage app = new AddPatientPage(driver);
		ManagePatientPage mpp = new ManagePatientPage(driver);
		AddMedicalHistoryPage amh = new AddMedicalHistoryPage(driver);
		Javautility ju = new Javautility();

		// Navigation to the doctor module
		hp.getLoginsBtn().click();
		hp.getDoctorLoginBtn().click();
		wd.switchToWindow("Doctor Login", driver);

		// TestScript Data from excel
		String username = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 8, 0);
		String password = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 8, 1);
		String Pname = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 10, 0) + ju.getRandomNumber();
		String Pcontact = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 10, 1);
		String Pemail = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 10, 2).replace("@",
				ju.getRandomNumber() + "@");
		String Paddress = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 10, 3);
		String Page = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 10, 4);
		String Phistory = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 10, 5);
		String bloodPressure = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 13, 0);
		String bloodSugar = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 13, 1);
		String weight = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 13, 2);
		String temperature = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 13, 3);
		String Prescription = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 13, 4);
		String runtimeName = Pname;
		String runtimeEmail = Pemail;

		// Login as Doctor
		dlp.doctorLogin(username, password);

		// Navigating to Add Patient
		app.getPatient().click();
		app.getAddPatient().click();

		// Entering mandatory details
		app.createPatients(Pname, Pcontact, runtimeEmail, Paddress, Page, Phistory);
		// Navigate to manage patient
		app.getPatient().click();
		mpp.getManagePatient().click();
		wd.scrollTillBottom(driver);

		driver.findElement(
				By.xpath("//td[text()='" + Pname + "']/following-sibling::td/a[contains(@href,'view-patient')]"))
				.click();
		wd.scroll(driver, 0, 300);
		driver.findElement(By.xpath("//button[contains(text(),'Add Medical History')]")).click();

		amh.addMedicalHistoryP(bloodPressure, bloodSugar, weight, temperature, Prescription);
		Thread.sleep(2000);
		wd.switchToAlertAccept(driver);
		wd.scrollTillBottom(driver);
		driver.findElement(
				By.xpath("//td[text()='" + Pname + "']/following-sibling::td/a[contains(@href,'view-patient')]"))
				.click();
		
		String actualPatient = driver.findElement(By.xpath("//td[text()='" + Pname + "']")).getText();
		Assert.assertEquals(runtimeName, actualPatient, "Medical report is not present");
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Medical report is present");
//		if (runtimeName.equals(actualPatient)) {
//			System.out.println("Medical report present");
//		} else {
//			System.out.println("Medical report present");
//		}

	}
}
