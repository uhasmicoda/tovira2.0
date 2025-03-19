package com.geneuineCare.healthCare.listenerUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {
	public static ThreadLocal<ExtentTest> etest= new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static void setExtentTest(ExtentTest test) {
		etest.set(test);
	}
	public static ExtentTest getExtentTest() {
		return etest.get();
	}
	
	public static void setWebDriver(WebDriver driver) {
		UtilityObjectClass.driver.set(driver);
	}
	public static WebDriver getWebDriver() {
		return driver.get();
	}
}
