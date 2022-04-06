package com.automationPractice.DeleteItemFromCart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class DeliveryAddress extends TestBase {
	public DeliveryAddress() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	/*
	 * Check Billing Address, Write in the Text Box and Proceed to checkout
	 */
	@FindBy(css = "textarea[name='message']")
	WebElement writeInTextBox;

	@FindBy(css = ".cart_navigation.clearfix button[type='submit']")
	WebElement proceedTocheckOutBtnOnAddressPage;

	public void writeinTextBox(String text) {
		writeInTextBox.sendKeys(text);
	}

	public Shipping proceedToShipping() {
		Utils.javascriptClick(proceedTocheckOutBtnOnAddressPage);
		return new Shipping();
	}

}
