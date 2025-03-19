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
import com.geneuineCare.healthCare.objectRepository.DeleteDoctorPage;
import com.geneuineCare.healthCare.objectRepository.HomePage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;
@Listeners(com.geneuineCare.healthCare.listenerUtility.ListenImpClass.class)
public class CreateAndDeleteDoctorbyAdminTest extends BaseClass {
	@Test(groups = "system")
	public void createAndDeleteDoctorbyAdminTest() throws EncryptedDocumentException, IOException, InterruptedException {


		WebDriverUtility wd = new WebDriverUtility();
		HomePage hp = new HomePage(driver);
		AdminLoginPage alp = new AdminLoginPage(driver);
		AddDoctor ad = new AddDoctor(driver);
		ExcelUtility eu = new ExcelUtility();
		Javautility ju = new Javautility();
		DeleteDoctorPage ddp = new DeleteDoctorPage(driver);
		wd.windowMaximize(driver);
		wd.waitForPageLoad(driver);
		hp.getLoginsBtn().click();
		hp.getAdminLoginBtn().click();

		String username = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 15, 0);
		String password = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 15, 1);
		String docname = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 1, 0) + ju.getRandomNumber();
		String add = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 1, 1);
		String fees = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 1, 2);
		String cont = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 1, 3);
		String mail = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 1, 6).replace("@",
				ju.getRandomNumber() + "@");
		String pass = eu.getDataFromEXcel("./TestScriptData/Admin.xlsx", "Sheet1", 1, 5);

		wd.switchToWindow("Admin-Login", driver);
		alp.loginToAdmin(username, password);

		ad.getDoctorClick().click();
		ad.getAddDoctorClick().click();

		ad.addDoctor(docname, add, fees, cont, mail, pass, pass);

		// Delete doctor
		ddp.deleteDoctor();
		wd.scrollTillBottom(driver);
		driver.findElement(
				By.xpath("//td[text()='" + docname + "']/following-sibling::td//i[@class='fa fa-times fa fa-white']"))
				.click();
		wd.switchToAlertAccept(driver);
		boolean deletemessage = ddp.getDeleteMessage().isDisplayed();
		Assert.assertFalse(deletemessage, "Doctor could not get deleted successfully");

		UtilityObjectClass.getExtentTest().log(Status.PASS, "Doctor got deleted successfully");
		
//		if (deletemessage) {
//			System.out.println("Doctor got deleted successfully");
//		} else {
//			System.out.println("Doctor could not get deleted successfully");
//		}

	}
}
