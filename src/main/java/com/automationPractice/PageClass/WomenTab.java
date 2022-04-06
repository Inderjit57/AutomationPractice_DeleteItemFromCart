package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class WomenTab extends TestBase {
	public WomenTab() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}

	// Move to element: short sleeve
	@FindBy(css = "li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']")
	WebElement moveToItemFadedShortSleeve;

	// Hover mouse to short sleeve
	@FindBy(css = ".product_list.grid.row li:nth-of-type(1) div div div a[class='quick-view']")
	WebElement mouseHoverToShortSleeve;

	// Quick view iframe
	@FindBy(css = "iframe[src='http://automationpractice.com/index.php?id_product=1&controller=product&content_only=1']")
	WebElement iframe;

	// Shopping Cart
	@FindBy(id = "View my shopping cart")
	WebElement viewCart;

	public void hoverToItem() {
		Utils.moveToElement(moveToItemFadedShortSleeve);
	}

	public QuickViewIframe switchToIframe() {
		mouseHoverToShortSleeve.click();
		Utils.switchToFrame(iframe);
		return new QuickViewIframe();
	}

	public ViewCart clickOnCart() {
		Utils.javascriptClick(viewCart);
		return new ViewCart();
	}

}