package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class Shipping extends TestBase {
	public Shipping() {
		PageFactory.initElements(wd, this);
	}

	// Click checkBox and proceed To Checkout which returns Payment class
	@FindBy(css = ".checkbox div input[type='checkbox']")
	WebElement checkBox;

	@FindBy(css = ".cart_navigation.clearfix button[type='submit']")
	WebElement proceedToCheckoutOnShipping;

	public void clickCheckBox() {
		Utils.javascriptClick(checkBox);
	}

	public ItemPurchasedPayment clickProceedToCheckout() {
		proceedToCheckoutOnShipping.click();
		return new ItemPurchasedPayment();
	}
}
