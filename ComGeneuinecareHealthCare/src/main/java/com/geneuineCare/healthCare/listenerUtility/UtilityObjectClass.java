package com.geneuineCare.healthCare.listenerUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObjectClass {
//	Example: Library with Computers 📚💻
//	Imagine a library where students come to study. There are multiple computers available, and each student needs one to do their work.
//
//	Scenario Without ThreadLocal (Shared Computer) ❌
//	If all students use the same computer, their work will get mixed up! One student’s file may overwrite another’s, and everyone will be confused.
//
//	Scenario With ThreadLocal (Separate Computers) ✅
//	To solve this, the library assigns one computer to each student. Now, each student can work on their own tasks without interfering with others.
//
//	How This Relates to the Code
//	Library = Automation framework
//	Students = Multiple test cases running at the same time
//	Computers = WebDriver instances (browsers)
//	Files on Computers = ExtentTest reports
//	If all test cases use the same WebDriver and ExtentTest, their execution results will mix up (like students using the same computer). But ThreadLocal ensures each test gets its own separate WebDriver and ExtentTest, just like each student gets their own computer.
//	Thus, the UtilityObjectClass ensures that parallel test execution works smoothly without interference! 🚀
	
	
	
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
