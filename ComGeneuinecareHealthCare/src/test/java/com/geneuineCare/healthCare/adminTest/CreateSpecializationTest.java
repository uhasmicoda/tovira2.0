package com.geneuineCare.healthCare.adminTest;

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
import com.geneuineCare.healthCare.objectRepository.AddDoctor;
import com.geneuineCare.healthCare.objectRepository.AdminLoginPage;
import com.geneuineCare.healthCare.objectRepository.DoctorSpecializationPage;
import com.geneuineCare.healthCare.objectRepository.HomePage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

@Listeners(com.geneuineCare.healthCare.listenerUtility.ListenImpClass.class)
public class CreateSpecializationTest extends BaseClass {
	@Test(groups = "integration")
	public void createSpecializationTest() throws EncryptedDocumentException, IOException, InterruptedException {

		WebDriverUtility wd = new WebDriverUtility();
		HomePage hp = new HomePage(driver);
		AdminLoginPage alp = new AdminLoginPage(driver);
		AddDoctor ad = new AddDoctor(driver);
		ExcelUtility eu = new ExcelUtility();
		Javautility ju = new Javautility();
		DoctorSpecializationPage dsp = new DoctorSpecializationPage(driver);
		wd.windowMaximize(driver);
		// wd.waitForPageLoad(driver);

		hp.getLoginsBtn().click();
		hp.getAdminLoginBtn().click();

		String username = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 15, 0);
		String password = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 15, 1);
		String speciality = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 18, 0) + ju.getRandomNumber();

		// Login to admin module

		wd.switchToWindow("Admin-Login", driver);
		alp.loginToAdmin(username, password);

		// Navigate to doctor
		ad.getDoctorClick().click();
		//
		dsp.createSpecialization(speciality);
		Thread.sleep(2000);
		wd.scrollTillBottom(driver);
		driver.findElement(By
				.xpath("//td[text()='" + speciality + "']/following-sibling::td//i[@class='fa fa-times fa fa-white']"))
				.click();
		wd.switchToAlertAccept(driver);

		// varification

		boolean message = dsp.getDeleteMessage().isDisplayed();
		Assert.assertFalse(message, "Speacialization could not get successfully Deleted");
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Speacialization  got successfully Deleted");

//		if (message) {
//			System.out.println("Speacialization got successfully Deleted");
//
//		} else {
//			System.out.println("Speacialization failed to Delete ");
//		}

	}
}
