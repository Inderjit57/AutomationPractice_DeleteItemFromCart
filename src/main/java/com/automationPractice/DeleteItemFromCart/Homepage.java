package com.automationPractice.DeleteItemFromCart;

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

	public SignInPage clickSignInBtn() {
		signInBtn.click();
		return new SignInPage();
	}
	
	// Verify if Sign in is displayed
	public boolean isSignInDisplayed() {
		return signInBtn.isDisplayed();
	}
	
}
