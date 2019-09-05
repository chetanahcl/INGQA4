package com.ing.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ing.base.BaseClass;
import com.ing.pages.AppHomePage;
import com.ing.pages.HomePage;
import com.ing.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseClass {

	LoginPage loginPageTest;

	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		startReport();
	}

	@BeforeMethod
	public void setExtent() {
		intialization();
		loginPageTest = new LoginPage();
		homepage = new HomePage();
	}

	@Test(priority = 1, description = "LoginPage")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description:Launching URL and entering Username and Password")
	@Story("Story Name: Login to the application")
	public void scrollDown() throws Exception {
		Logger = extent.startTest("Logging into Application");
		Logger.log(LogStatus.INFO, "Login with username and password");
		homepage = loginPageTest.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		System.out.println("Test_Case 1 ");
	}

}
