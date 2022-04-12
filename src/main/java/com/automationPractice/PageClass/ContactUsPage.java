package com.automationPractice.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class ContactUsPage extends TestBase {
	public ContactUsPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	@FindBy(id = "id_contact")
	WebElement subjectHeadingInput;

	// Input email address
	@FindBy(id = "email")
	WebElement emailAddressInput;

	@FindBy(id = "id_order")
	WebElement orderReferenceInput;

	@FindBy(xpath = "//textarea[@name='message']")
	WebElement messageInput;

	@FindBy(css = "button[name='submitMessage']")
	WebElement submitInput;

	@FindBy(css = ".alert.alert-success")
	WebElement validationText;

	public void chooseFromSubjectHeading() {
		Utils.javascriptClick(subjectHeadingInput);
		Select select = new Select(subjectHeadingInput);
		select.selectByIndex(1);
	}

	public void inputEmail(String email) {
		Utils.sendData(emailAddressInput, email);
	}

	public void inputOrderReference(String orderRefernce) {
		Utils.sendData(orderReferenceInput, orderRefernce);
	}

	public void inputMessage(String inputText) {
		Utils.sendData(messageInput, inputText);

	}

	public void clickSubmit() {
		Utils.clickOnElement(submitInput);
	}

	public String successfulMessageSubmitText() {
		return Utils.getTextFromWebelement(validationText);
	}
}
