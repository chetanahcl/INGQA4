package com.ing.pages;

import org.openqa.selenium.support.PageFactory;

import com.ing.base.BaseClass;

public class personalBankingPage extends BaseClass {

	public personalBankingPage() {

		PageFactory.initElements(driver, this);
	}
}
