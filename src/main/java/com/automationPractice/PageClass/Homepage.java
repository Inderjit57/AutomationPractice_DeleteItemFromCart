package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class Homepage extends TestBase {
	public Homepage() {

		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	@FindBy(css = "div.header_user_info")
	WebElement signInBtn;

	public SignInSignOut clickSignInBtn() {
		signInBtn.click();
		return new SignInSignOut();
	}

	// Verify if Sign in is displayed
	public boolean isSignInDisplayed() {
		return signInBtn.isDisplayed();
	}

	// Verify if search button is working
	@FindBy(css = ".lighter")
	WebElement searchedText;

	public String getSearchedText() {
		return Utils.getTextFromWebelement(searchedText);

	}

	// Verify if search Bar is working
	@FindBy(id = "search_query_top")
	WebElement searchBox;

	// Search button
	@FindBy(css = ".col-sm-4.clearfix button[type='submit']")
	WebElement searchBtn;

	public void writeIteminSearchBar(String text) {
		// Search bar
		searchBox.sendKeys(text);

	}

	// Search page
	public PageAfterClickingSearchBtn clickSearch() {
		Utils.javascriptClick(searchBtn);
		return new PageAfterClickingSearchBtn();
	}

	// Contact us page
	// Locator for Contact us
	@FindBy(css = "a[title='Contact Us']")
	WebElement contactUsBtn;
	
	public ContactUsPage clickContactUs() {
		Utils.javascriptClick(contactUsBtn);
		return new ContactUsPage();
	}

}
