package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class SignInSignOut extends TestBase {
	public SignInSignOut() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	@FindBy(css = ".col-xs-12.col-sm-6 div input[id='email']")
	WebElement emailInput;

	@FindBy(css = "#passwd")
	WebElement passwordInput;

	@FindBy(css = "#SubmitLogin")
	WebElement signInBtn;

	public void enterEmail(String email) {
		Utils.sendData(emailInput, email);
	}

	public void enterPassword(String password) {
		Utils.sendData(passwordInput, password);
	}

	public AccountPage clickSignInBtn() {
		signInBtn.click();
		return new AccountPage();
	}

	/*
	 * Scenario : Sign out functionality
	 */

	@FindBy(css = "a[title='Log me out']")
	WebElement signoutBtn;

	public Homepage clickSignout() {
		Utils.javascriptClick(signoutBtn);
		return new Homepage();
	}

}
