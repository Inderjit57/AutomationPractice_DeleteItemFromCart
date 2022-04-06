package com.automationPractice.PageClass;

import com.automationPractice.BasePackage.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class AccountPage extends TestBase {
	public AccountPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	@FindBy(css = "a[title='View my customer account'] span")
	WebElement welcomeMessageText;

	@FindBy(css = "a[title='Women']")
	WebElement womenTab;

	public String getTextFromMessage() {
		return welcomeMessageText.getText();
	}

	public WomenTab clickOnWomenTab() {
		womenTab.click();
		return new WomenTab();

	}
}
