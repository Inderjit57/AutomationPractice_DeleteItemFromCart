package com.Inderjit.AutomationPractice_DeleteItem;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.PageClass.ContactUsPage;
import com.automationPractice.PageClass.Homepage;

public class CustomerServiceTest extends TestBase{
	
	Homepage homepage;
	ContactUsPage contactUsPage;
	
	
	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// Initializing landing page / Homepage
		homepage = new Homepage();

	}
	
	@Test
	public void verifyFunctionalityOfSendingMessagae() {	
		contactUsPage= homepage.clickContactUs();
		
		contactUsPage.chooseFromSubjectHeading();
		contactUsPage.inputEmail(properties.getProperty("email"));
		contactUsPage.inputOrderReference(properties.getProperty("orderReferenceNumber"));
		contactUsPage.inputMessage(properties.getProperty("writeTextInTheBox"));
		contactUsPage.clickSubmit();
		String message = contactUsPage.successfulMessageSubmitText();
		Assert.assertEquals(message, properties.getProperty("messageSentSuccessfuly"), "Successfull Message not found after submit");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
