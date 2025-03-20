package com.geneuineCare.healthCare.doctorTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.geneuineCare.healthCare.baseTest.BaseClass;
import com.geneuineCare.healthCare.fileUtility.ExcelUtility;
import com.geneuineCare.healthCare.javaUtility.Javautility;
import com.geneuineCare.healthCare.listenerUtility.UtilityObjectClass;
import com.geneuineCare.healthCare.objectRepository.AddPatientPage;
import com.geneuineCare.healthCare.objectRepository.DoctorLoginPage;
import com.geneuineCare.healthCare.objectRepository.HomePage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;
@Listeners(com.geneuineCare.healthCare.listenerUtility.ListenImpClass.class)
public class CreatePatientAndSearchbyNameTest extends BaseClass {
	@Test(groups = "integration")
	public void createPatientAndSearchbyNameTest()
			throws InterruptedException, EncryptedDocumentException, IOException {

		// Object creation of different classes

		HomePage hp = new HomePage(driver);
		WebDriverUtility wd = new WebDriverUtility();
		ExcelUtility eu = new ExcelUtility();
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		AddPatientPage app = new AddPatientPage(driver);
		Javautility ju = new Javautility();

		wd.waitForPageLoad(driver);
		wd.windowMaximize(driver);

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
		String expectedPname = Pname;
		String runtimeEmail = Pemail;

		// Login as Doctor
		dlp.doctorLogin(username, password);

		// Navigating to Add Patient
		app.getPatient().click();
		app.getAddPatient().click();

		// Entering mandatory details
		app.createPatients(Pname, Pcontact, runtimeEmail, Paddress, Page, Phistory);

		// Search patient by patient name
		app.serachPatienbyName(expectedPname);

		// validation
		WebElement Patienverify = app.getPatientVerify();
		String actualPname = Patienverify.getText();
		Assert.assertEquals(actualPname, expectedPname, "Patient is not added successfully by doctor");
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Patient is added successfully by docter");
		
//		if (actualPname.equals(expectedPname)) {
//			System.out.println("Patient added successfully by doctor");
//		} else {
//			System.out.println("Patient is not added successfully by docter");
//		}

	}
}
