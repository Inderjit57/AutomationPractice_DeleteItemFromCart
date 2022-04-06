package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class SearchBar extends TestBase {
	public SearchBar() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}

	@FindBy(css = "#searchbox")
	WebElement searchBar;

	// Search button
	@FindBy(css = ".col-sm-4.clearfix button[type='submit']")
	WebElement searchBtn;

	public void writeItemAndSearch(String text) {
		// Search bar
		Utils.sendData(searchBar, text);

		// Click search button
		Utils.clickOnElement(searchBtn);
	}

}
