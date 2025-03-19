package com.geneuineCare.healthCare.patientTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.geneuineCare.healthCare.baseTest.BaseClass;
import com.geneuineCare.healthCare.fileUtility.ExcelUtility;
import com.geneuineCare.healthCare.listenerUtility.UtilityObjectClass;
import com.geneuineCare.healthCare.objectRepository.HomePage;
import com.geneuineCare.healthCare.objectRepository.PatientLoginPage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;
@Listeners(com.geneuineCare.healthCare.listenerUtility.ListenImpClass.class)
public class PatientLogingTest extends BaseClass {

	@Test(groups = "smoke")
	public void patientLogingTest() throws InterruptedException, EncryptedDocumentException, IOException {

		WebDriverUtility wu = new WebDriverUtility();
		ExcelUtility eu = new ExcelUtility();
		HomePage hp = new HomePage(driver);
		PatientLoginPage plp = new PatientLoginPage(driver);
		wu.windowMaximize(driver);
		wu.waitForPageLoad(driver);

		// TestScript data from excel

		String username = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 3, 0);
		String userEmail = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 6, 0);
		String password = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 6, 1);
		wu.windowMaximize(driver);
		wu.waitForPageLoad(driver);
		driver.get("http://49.249.28.218:8081/AppServer/Hospital_Doctor_Patient_Management_System/");

		// Navigating to the Patient login Page

		hp.getLoginsBtn().click();
		hp.getPatienLoginBtn().click();
		wu.switchToWindow("User-Login", driver);

		// Login into the application

		plp.patienLogin2(userEmail, password);

		// Validation
	
		String ActUsername = driver.findElement(By.xpath("//span[contains(text(),'Sadeek')]")).getText();
		Assert.assertEquals(ActUsername, username, "Login function is not working correct");
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Login function is working correct");
		
//		if (ActUsername.equals(username)) {
//			System.out.println("Login function is working correct");
//		} else {
//			System.out.println("Login function is working correct");
//		}

	}
}
