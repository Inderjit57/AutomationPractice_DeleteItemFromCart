package com.Inderjit.AutomationPractice_DeleteItem;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.PageClass.AccountPage;
import com.automationPractice.PageClass.Homepage;
import com.automationPractice.PageClass.SignInSignOut;

public class SignInSignOutTest extends TestBase {
	Homepage homepage;
	SignInSignOut signInPage;
	AccountPage accountPage;

	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// Initializing landing page / Homepage
		homepage = new Homepage();

	}

	@Test
	public void verifySignoutFunctionality() {
		// Click signIn on homepage, Enter Login Credentials and signIn
		// ClickSignInBtn invoke the constructor of the SignInPage.
		signInPage = homepage.clickSignInBtn();
		signInPage.enterEmail(properties.getProperty("email"));
		signInPage.enterPassword(properties.getProperty("password"));

		// SignInPage invokes the constructor of AccountPage.
		accountPage = signInPage.clickSignInBtn();

		// Verify if account is successfully opened
		String successfullSignInText = accountPage.getTextFromMessage();
		String accountMessage = properties.getProperty("accountMessage");
		System.out.println("Account login Message : " + accountMessage);
		Assert.assertEquals(successfullSignInText, accountMessage, "Account name is not present");

		// Click on Signout
		homepage = signInPage.clickSignout();

		boolean isSignInBtnDisplayed = homepage.isSignInDisplayed();
		Assert.assertEquals(isSignInBtnDisplayed, true, "SignIn button is not displayed");
		System.out.println("SignIn Button is displayed after signout: " + isSignInBtnDisplayed);

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
