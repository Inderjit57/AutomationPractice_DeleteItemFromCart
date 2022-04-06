package com.Inderjit.AutomationPractice_DeleteItem;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.PageClass.Homepage;
import com.automationPractice.PageClass.PageAfterClickingSearchBtn;
import com.automationPractice.PageClass.SearchBar;

public class SearchBarTest extends TestBase {
	Homepage homepage;
	PageAfterClickingSearchBtn pageAfterClickingSearchBtn;

	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// Initializing landing page / Homepage
		homepage = new Homepage();

	}

	@Test
	public void verifySearchBarIsWorking() {

		homepage.writeIteminSearchBar(properties.getProperty("writeTextInSearchBar"));
		pageAfterClickingSearchBtn= homepage.clickSearch();

		String searchedContext = pageAfterClickingSearchBtn.getSearchedText();
		String actualContext = properties.getProperty("actualTextPresentAfterSearching");
		Assert.assertEquals(searchedContext, actualContext, "Text not present");
		System.out.println("Text displayed after cliking search :" + searchedContext);
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
