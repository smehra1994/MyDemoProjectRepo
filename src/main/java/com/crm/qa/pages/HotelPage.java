package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HotelPage extends TestBase {

	@FindBy(xpath = "//img[@src='images/mast_construction.gif']")
	WebElement HotelLabel;

	@FindBy(xpath = "//img[@src='images/home.gif']")
	WebElement okbtn;

	// Initializing the Page Objects:
	public HotelPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHotelLabel() {
		return HotelLabel.isDisplayed();
	}

	public void verifyHotelDetails() {

		okbtn.click();

	}
}
