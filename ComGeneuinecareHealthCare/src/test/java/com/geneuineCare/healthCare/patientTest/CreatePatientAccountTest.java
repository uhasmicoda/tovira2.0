package com.geneuineCare.healthCare.patientTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.geneuineCare.healthCare.baseTest.BaseClass;
import com.geneuineCare.healthCare.fileUtility.ExcelUtility;
import com.geneuineCare.healthCare.javaUtility.Javautility;
import com.geneuineCare.healthCare.listenerUtility.UtilityObjectClass;
import com.geneuineCare.healthCare.objectRepository.HomePage;
import com.geneuineCare.healthCare.objectRepository.PatientAppointmentPage;
import com.geneuineCare.healthCare.objectRepository.PatientLoginPage;
import com.geneuineCare.healthCare.objectRepository.UserLoginPage;
import com.geneuineCare.healthCare.objectRepository.UserRegistrationPage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;
@Listeners(com.geneuineCare.healthCare.listenerUtility.ListenImpClass.class)
public class CreatePatientAccountTest extends BaseClass {
	@Test(groups = "integration")
	public void createPatientAccountTest() throws InterruptedException, EncryptedDocumentException, IOException {

		WebDriverUtility wu = new WebDriverUtility();
		Javautility ju = new Javautility();
		ExcelUtility eu = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		UserLoginPage up = new UserLoginPage(driver);
		UserRegistrationPage urp = new UserRegistrationPage(driver);
		PatientLoginPage plp = new PatientLoginPage(driver);
		PatientAppointmentPage pap = new PatientAppointmentPage(driver);
		int random = ju.getRandomNumber();

		driver.manage().window().maximize();
		wu.waitForPageLoad(driver);

		driver.get("http://49.249.28.218:8081/AppServer/Hospital_Doctor_Patient_Management_System/");
		hp.getLoginsBtn().click();

		hp.getPatienLoginBtn().click();
		wu.switchToWindow("User-Login", driver);
		up.getCreateActLink().click();

		// Here I'm fetching test data from excel

		String alertmessage = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 21, 0);

		String PatientName = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 3, 0);
		String PatientAdd = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 3, 1);
		String PatientCity = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 3, 2);
		String PatientEmail = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 3, 3);
		String PatientPass = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 3, 4);
		String runtimeEmail = PatientEmail.replace("@", random + "@");
		String password = PatientPass;
		Thread.sleep(2000);

		urp.creatUser(PatientName, PatientAdd, PatientCity, runtimeEmail, PatientPass, PatientPass);

		Thread.sleep(2000);

		wu.switchToAlertAccept(driver);

		wu.scroll(driver, 0, 200);
		Thread.sleep(2000);

		plp.patienLogin(runtimeEmail, password);

		pap.getAppointment();

		Thread.sleep(2000);
		String alertText = wu.switchToAlertGetText(driver);
		wu.switchToAlertAccept(driver);

		// validation
		Assert.assertEquals(alertText, alertmessage, "Appointment function is not working correct");
		UtilityObjectClass.getExtentTest().log(Status.PASS,"Appointment function is not working correct");
		
//		if (alertText.contains(alertmessage)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}

	}
}