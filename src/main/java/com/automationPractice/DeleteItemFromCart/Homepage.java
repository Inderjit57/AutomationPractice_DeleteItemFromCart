package com.automationPractice.DeleteItemFromCart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class Homepage extends TestBase {
	public Homepage() {

		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div.header_user_info")
	WebElement signInBtn;

	public SignInPage clickSignInBtn() {
		signInBtn.click();
		return new SignInPage();

	}
}
