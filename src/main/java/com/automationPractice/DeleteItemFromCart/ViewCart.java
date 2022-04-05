package com.automationPractice.DeleteItemFromCart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class ViewCart extends TestBase {
	public ViewCart() {
		PageFactory.initElements(wd, this);
	}

	/*
	 * Scenario : Item to be Deleted from Cart
	 */
	@FindBy(css = "a[title='Delete']")
	WebElement deleteItemFromCart;

	public void clickDelete() {
		// Close the tab
		Utils.javascriptClick(deleteItemFromCart);
	}

	public ShoppingCartSummary goToShoppingCart() {
		return new ShoppingCartSummary();
	}
	
	/*
	 * Scenario :Purchase Item
	 */
	@FindBy(css = "#total_price_container")
	WebElement totalPriceDisplayed;
	
	@FindBy(css = ".cart_navigation.clearfix a[title='Proceed to checkout'] span i")
	WebElement proceedToCheckOutBtnOnViewCart;
	
	public void getTotalPriceDisplayed() {
		Utils.getTextFromWebelement(totalPriceDisplayed);
	}
	public DeliveryAddress clickOnProceedToCheckout() {
		Utils.javascriptClick(proceedToCheckOutBtnOnViewCart);
		return new DeliveryAddress();
	}

}
