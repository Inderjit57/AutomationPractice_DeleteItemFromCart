package com.automationPractice.PageClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class QuickViewIframe extends TestBase {

	public QuickViewIframe() {
		PageFactory.initElements(wd, this);
		wd.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/*
	 * First Scenario : Item to be deleted from Cart. So, iframe is closed to go to
	 * Cart
	 */

	// this element is shared between two scenarios
	@FindBy(css = ".box-cart-bottom button[type='submit']")
	WebElement addToCart;

	@FindBy(css = "#layer_cart > div[class='clearfix']")
	WebElement cartTab;

	@FindBy(css = ".layer_cart_product.col-xs-12.col-md-6 > span")
	WebElement closeBtn;

	@FindBy(css = "a[title='View my shopping cart']")
	WebElement goToCart;

	public void addToCart() {
		// Utils.javascriptClick(addToCart);
		addToCart.click();
		// switch back to default content
		wd.switchTo().defaultContent();

	}

	// Close the item selection frame
	public void closeTheframe() {
		Utils.javascriptClick(closeBtn);
	}

	// Go to Cart page
	public ViewCart clickOnCart() {
		Actions actions = new Actions(wd);
		actions.moveToElement(goToCart);
		Utils.javascriptClick(goToCart);
		return new ViewCart();
	}

	// Return to Women Tab page
	public WomenTab goToCart() {
		Utils.javascriptClick(closeBtn);
		return new WomenTab();
	}

	/*
	 * Second Scenario : item to be purchased and proceeded to checkout
	 */

	@FindBy(css = "#quantity_wanted_p :nth-of-type(2) span i")
	WebElement addQuantity;

	@FindBy(css = ".attribute_list div select option:nth-of-type(3)")
	WebElement selectSize;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
//	.layer_cart_cart.col-xs-12.col-md-6 :nth-of-type(4) a
	WebElement checkOutBtn;

	// Using Javascript Executer to click to add quantity
	public void addQuantity() {
		Utils.javascriptClick(addQuantity);
	}

	// Using Javascript Executer to click to select size
	public void sizeSelection() {
		Utils.javascriptClick(selectSize);
	}

	public ViewCart proceedToCheckOut() {
		checkOutBtn.click();
		return new ViewCart();
	}

}