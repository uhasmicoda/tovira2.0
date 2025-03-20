package com.geneuineCare.healthCare.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.geneuineCare.healthCare.baseTest.BaseClass;

public class ListenImpClass implements ITestListener, ISuiteListener {
	ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
/// saddamS
		String time = new Date().toString().replace(" ", "_").replace("-", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReporter/report_" + time + ".html");
		spark.config().setDocumentTitle("GeneuineCare Management System Test Suite Result");
		spark.config().setReportName("GeneuineCare Management System Report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("Browser", "Chrome 32.54");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + "This Test Start from here");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityObjectClass.setExtentTest(test);
		UtilityObjectClass.getExtentTest().log(Status.INFO, result.getMethod().getMethodName() + "This script starts from here");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + "===test end");
		UtilityObjectClass.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + "This script got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "-");

		UtilityObjectClass.getExtentTest().addScreenCaptureFromBase64String(src, testName + "_" + time);

		UtilityObjectClass.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + "This script got failed");
		UtilityObjectClass.getExtentTest().log(Status.FAIL, result.getThrowable());

	}

	@Override

	public void onTestSkipped(ITestResult result) {
		UtilityObjectClass.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + "This script got skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {

	}
}
