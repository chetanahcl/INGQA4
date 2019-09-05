package com.ing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ing.base.BaseClass;

import io.qameta.allure.Step;

public class AppHomePage extends BaseClass {

	public AppHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu-item-30240']/a")
	WebElement personalBtn;

	@Step("PersonalBtn clicking")
	public personalBankingPage personalBtnClick() throws Exception {
		personalBtn.click();
		return new personalBankingPage();
	}
}
