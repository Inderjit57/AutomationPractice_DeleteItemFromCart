package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class ItemPurchasedPayment extends TestBase {
	public ItemPurchasedPayment() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = ".bankwire")
	WebElement clickPayWithBank;

	@FindBy(css = ".page-subheading")
	WebElement bankWireHeading;

	@FindBy(css = "p> button[type='submit']")
	WebElement confirmOrderbtn;

	@FindBy(css = ".cheque-indent strong[class='dark']")
	WebElement orderConfirmationMessage;

	public void payByBankClick() {
		// write a return statement if needed to return confirmation page
		clickPayWithBank.click();
	}

	public void clickConfirm() {
		confirmOrderbtn.click();
	}

	public String getConfirmationMessage() {
		return Utils.getTextFromWebelement(orderConfirmationMessage);
	}

}
