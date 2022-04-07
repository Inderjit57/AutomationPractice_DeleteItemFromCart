package com.Inderjit.AutomationPractice_DeleteItem;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.PageClass.AccountPage;
import com.automationPractice.PageClass.ItemPurchaseConfirmation;
import com.automationPractice.PageClass.Homepage;
import com.automationPractice.PageClass.ItemPurchasedPayment;
import com.automationPractice.PageClass.QuickViewIframe;
import com.automationPractice.PageClass.Shipping;
import com.automationPractice.PageClass.SignInSignOut;
import com.automationPractice.PageClass.ViewCart;
import com.automationPractice.PageClass.WomenTab;

public class ItemPurchaseConfirmationTest extends TestBase {

	Homepage homepage;
	AccountPage accountPage;
	QuickViewIframe quickViewIframe;
	SignInSignOut signInPage;
	ViewCart viewCart;
	WomenTab womenTab;
	ItemPurchaseConfirmation itemPurchaseConfirmation;
	ItemPurchasedPayment itemPurchasedPayment;
	Shipping shipping;

	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// Initializing landing page / Homepage
		homepage = new Homepage();

	}

	@Test
	public void verifyItemPurchased() {
		// Click signIn on homepage, Enter Login Credentials and signIn
		// ClickSignInBtn invoke the constructor of the SignInPage.
		signInPage = homepage.clickSignInBtn();
		signInPage.enterEmail(properties.getProperty("email"));
		signInPage.enterPassword(properties.getProperty("password"));

		// SignInPage invokes the constructor of AccountPage.
		accountPage = signInPage.clickSignInBtn();

		// Verify if account is successfully opened
		String successfullSignInText = accountPage.getTextFromMessage();
		String accountMessage = properties.getProperty("accountMessage");
		System.out.println("Account login Message : " + accountMessage);
		Assert.assertEquals(successfullSignInText, accountMessage, "Account name is not present");

		// Go to Women Tab
		// AccountPage invokes the constructor of WomenTab.
		womenTab = accountPage.clickOnWomenTab();
		// hover to item quick view
		womenTab.hoverToItem();

		// WomenTab invokes the constructor of QuickViewIFrame
		quickViewIframe = womenTab.switchToIframe();

		// Add quantity and size
		quickViewIframe.addQuantity();
		quickViewIframe.addToCart();

		// Proceed to checkout
		viewCart = quickViewIframe.proceedToCheckOut();

		// Verify if price is displayed
		String priceDisplayed = viewCart.getTotalPriceDisplayed();
		String actualDisplayedText = properties.getProperty("totalPriceDisplayedFor2Items");
		System.out.println("Total Price Displayed For 2 Items: " + priceDisplayed);
		Assert.assertEquals(priceDisplayed, actualDisplayedText, "Expected Price is not Displayed");

		// Proceed to checkout
		itemPurchaseConfirmation = viewCart.clickOnProceedToCheckout();

		// Write message in the TextBox.
		itemPurchaseConfirmation.writeinTextBox(properties.getProperty("WritingMessageInATextBox"));

		// Proceed to shipping by clicking checkout
		shipping = itemPurchaseConfirmation.proceedToShipping();

		// Click checkBox and proceed To Checkout
		shipping.clickCheckBox();

		itemPurchasedPayment = shipping.clickProceedToCheckout();

		// Click Pay By Bank Checkbox and click confirm
		itemPurchasedPayment.payByBankClick();
		itemPurchasedPayment.clickConfirm();

		// Verify successfull message after item is purchased
		String successfulMessage = itemPurchasedPayment.getConfirmationMessage();
		String actualMessage = properties.getProperty("successfullMessageAfterItemPurchased");

		Assert.assertEquals(successfulMessage, actualMessage, "Successful item purchased message is not displayed");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
