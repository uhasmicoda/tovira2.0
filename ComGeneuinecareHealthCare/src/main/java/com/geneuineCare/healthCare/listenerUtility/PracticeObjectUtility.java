package com.geneuineCare.healthCare.listenerUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class PracticeObjectUtility {
 public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
 public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
 
 public static void setExtentTest(ExtentTest test) {
	 PracticeObjectUtility.test.set(test);
 }
 public static ExtentTest getExtentTest() {
	return  PracticeObjectUtility.test.get();
 }
 public static void setWebDriver(WebDriver driver) {
	 PracticeObjectUtility.driver.set(driver);
 }
 public static WebDriver  getWebDriver() {
	return PracticeObjectUtility.driver.get();
 }
}
