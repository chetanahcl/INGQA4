package com.ing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ing.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='board-tile mod-add']")
	WebElement CreateBoard;

	public BoardsPage createBoard() {
		CreateBoard.click();
		return new BoardsPage();
	}

}
