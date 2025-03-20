package com.geneuineCare.healthCare.baseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.geneuineCare.healthCare.fileUtility.PropertyFile;
import com.geneuineCare.healthCare.objectRepository.LogoutPage;
import com.geneuineCare.healthCare.webDriverUtility.WebDriverUtility;

public class BaseClass {
	WebDriverUtility wd = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public PropertyFile pf = new PropertyFile();
	

	@BeforeSuite(alwaysRun = true)
	public void configBS() {
		System.out.println("Before Starts from here");
      
	}

	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException {
		String BROWSER = pf.getDatafromProperty("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
        wd.waitForPageLoad(driver);
	}

	@BeforeMethod(alwaysRun = true)

	public void configBM() throws Exception {
		System.out.println("BaseTest: @BeforeMethod");
		String URL = pf.getDatafromProperty("url");
		System.out.println("URL:"+URL);
		driver.get(URL);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		System.out.println("BaseTest: @AfterMethod");
		LogoutPage lp = new LogoutPage(driver);
		lp.LogoutFromApp();

	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("BaseTest: @AfterClass");

		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() {
		System.out.println("BaseTest: @AfterSuite");
	}
}
