package com.ing.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ing.base.BaseClass;
import com.ing.pages.AppHomePage;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AppHomeTest extends BaseClass {

	AppHomePage apphometest;

	public AppHomeTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		startReport();
	}

	@BeforeMethod
	public void setExtent() {
		intialization();
		apphometest = new AppHomePage();
	}

	@Test(priority = 1, description = "Login Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: scrolldown and write data into Notepad")
	@Story("Story Name: Scroll and write details to Notepad")
	public void scrollDown() throws Exception {
		Logger = extent.startTest("Fetching Data into Notepad");
		Logger.log(LogStatus.INFO,
				"Launching the Application and Scrolling Down and then writing the Page Details into Notepad");
		apphometest.personalBtnClick();
		System.out.println("Test_Case 1 ");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			// to add name in extent report
			Logger.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
			// to add error/exception in extent report
			Logger.log(LogStatus.FAIL, "TEST CASE FAILED ");
			String screenshotPath = AppHomeTest.getScreenshot(driver, result.getName());
			// to add screenshot in extent report
			Logger.log(LogStatus.FAIL, Logger.addScreenCapture(screenshotPath));
			// extentTest.log(LogStatus.FAIL,
			// extentTest.addScreencast(screenshotPath)); //to add
			// screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			Logger.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			Logger.log(LogStatus.PASS, "Test Case PASSED ");

			// String screenshotPath = UtilClass.getScreenshot(driver,
			// result.getName());
			// extentTest.log(LogStatus.FAIL,
			// extentTest.addScreenCapture(screenshotPath));
		}

		extent.endTest(Logger); // ending test and ends the current test and
								// prepare to create html report
	}

	@AfterTest
	public void endReport() {

		extent.flush();
		extent.close();
		driver.close();
	}

}
