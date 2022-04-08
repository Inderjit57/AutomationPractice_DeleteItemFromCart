package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class Dresses extends TestBase{
	public Dresses() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}
	Actions actions;
	
	@FindBy(css = ".block  div form div > div ul[class='col-lg-12 layered_filter_ul color-group'] :nth-of-type(4)")
	WebElement colorSelection;
	
	public void dragMaxSlider() {
		Utils.scrollIntoViewUsingJavascript(colorSelection);
		Utils.clickOnElement(colorSelection);
	}

}
