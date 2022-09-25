package com.Inderjit.AutomationPractice_DeleteItem;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.PageClass.AccountPage;
import com.automationPractice.PageClass.Homepage;
import com.automationPractice.PageClass.SignInSignOut;
import com.automationPractice.Utils.ExcelUtils;

public class SignInSignOutTest extends TestBase {
	Homepage homepage;
	SignInSignOut signInPage;
	AccountPage accountPage;
	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// Initializing landing page / Homepage
		homepage = new Homepage();

	}

//	@Test(dataProvider = "signUpDataProvider")
	@Test(enabled = true)
	public void verifySignoutFunctionality(String email, String password) {
		// Click signIn on homepage, Enter Login Credentials and signIn
		// ClickSignInBtn invoke the constructor of the SignInPage.
		signInPage = homepage.clickSignInBtn();
		signInPage.enterEmail(email);
		signInPage.enterPassword(password);

		// SignInPage invokes the constructor of AccountPage.
		accountPage = signInPage.clickSignInBtn();

		// Verify if account is successfully opened and signout button is displayed
		boolean signoutPresent = accountPage.isSignOutBtnDisplayed();
		System.out.println("Is Signout btn displayed : " + signoutPresent);
		sf.assertEquals(signoutPresent, true, "Log button is not present");

		// Click on Signout
		homepage = signInPage.clickSignout();

		boolean isSignInBtnDisplayed = homepage.isSignInDisplayed();
		sf.assertEquals(isSignInBtnDisplayed, true, "SignIn button is not displayed");
		System.out.println("SignIn Button is displayed after signout: " + isSignInBtnDisplayed);

		sf.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	// Get the login Credentials from Excel file
	@DataProvider(name = "signUpDataProvider")
	public String[][] readAndFeebLoginDataFromExcel() throws IOException {
		// First need to locate the file path
		String filePath = "C:\\Everything\\Sheet1.xlsx";

		// Locate the Row in a sheet
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

		// Locate the column to go to a cell
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", rows);

		// Create 2 Diamensional Array in the memory of java to fetch data from rows and
		// column
		String[][] loginData = new String[rows][col];

		// Using Loop to fill data in cells
		// For loop is used to pick Row first
		for (int i = 1; i < rows; i++) {
			// nested For loop to get data from column in a particular row
			for (int j = 0; j < col; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}

		}
		return loginData;
	}
}
