package com.ing.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ing.base.BaseClass;
import com.ing.pages.HomePage;
import com.ing.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		startReport();
	}

	@BeforeMethod
	public void setExtent() {
		intialization();
		homepage = new HomePage();
		loginPageTest = new LoginPage();
	}

	@Test(priority = 1, description = "BoardPage")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description:Launching URL and entering Username and Password")
	@Story("Story Name: Login to the application")
	public void scrollDown() throws Exception {
		Logger = extent.startTest("Logging into Application");
		Logger.log(LogStatus.INFO, "Login with username and password");
		homepage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		homepage.createBoard();
		System.out.println("Test_Case 1 ");
	}

}
