package com.Inderjit.AutomationPractice_DeleteItem;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.PageClass.Homepage;
import com.automationPractice.PageClass.PageAfterClickingSearchBtn;
import com.automationPractice.PageClass.SearchBar;
import com.automationPractice.Utils.ExcelUtils;

public class SearchBarTest extends TestBase {
	Homepage homepage;
	PageAfterClickingSearchBtn pageAfterClickingSearchBtn;
	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// Initializing landing page / Homepage
		homepage = new Homepage();

	}

//	@Test(dataProvider = "signUpDataProvider")
	@Test(enabled = false)
	public void verifySearchBarIsWorking(String text) {
		
		homepage.writeIteminSearchBar(text);
		
//		homepage.writeIteminSearchBar(properties.getProperty("writeTextInSearchBar"));
		pageAfterClickingSearchBtn = homepage.clickSearch();

		String searchedContext = pageAfterClickingSearchBtn.getSearchedText();
		String actualContext = properties.getProperty("actualTextPresentAfterSearching");
		sf.assertEquals(searchedContext, actualContext, "Text not present");
		System.out.println("Text displayed after cliking search :" + searchedContext);
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
		int rows = ExcelUtils.getRowCount(filePath, "Sheet2");

		// Locate the column to go to a cell
		int col = ExcelUtils.getCellCount(filePath, "Sheet2", rows);

		// Create 2 Diamensional Array in the memory of java to fetch data from rows and
		// column
		String[][] loginData = new String[rows][col];

		// Using Loop to fill data in cells
		// For loop is used to pick Row first
		for (int i = 1; i < rows; i++) {
			// nested For loop to get data from column in a particular row
			for (int j = 0; j < col; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet2", i, j);
			}

		}
		return loginData;
	}

}
