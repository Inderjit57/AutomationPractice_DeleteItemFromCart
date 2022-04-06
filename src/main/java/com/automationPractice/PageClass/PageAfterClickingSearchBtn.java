package com.automationPractice.PageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Utils.Utils;

public class PageAfterClickingSearchBtn extends TestBase{
	public PageAfterClickingSearchBtn() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}

    @FindBy(css = ".lighter")
    WebElement searchedText;

    public String getSearchedText(){
       return Utils. getTextFromWebelement(searchedText);
         
    }

}
