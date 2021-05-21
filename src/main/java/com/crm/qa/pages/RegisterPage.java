package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(xpath = "//img[@src='images/logo.gif']")
	WebElement PageLabel;

	@FindBy(xpath = "//a[contains(text(),'Flights')]")
	WebElement flightLink;

	@FindBy(xpath = "//a[contains(text(),'Hotels')]")
	WebElement hotelLink;
	
	/*
	 * @FindBy(xpath = "//a[contains(text(),'Contacts')]") 
	 * WebElement contactsLink;
	 * 
	 * @FindBy(xpath = "//a[contains(text(),'New Contact')]") 
	 * WebElement newContactLink;
	 */

	// Initializing the Page Objects:
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyRegisterPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectPageName() {
		return PageLabel.isDisplayed();
	}

	public FlightsPage clickOnFlightsLink() {
		flightLink.click();
		return new FlightsPage();
	}

	public HotelPage clickOnHotelLink() {
		hotelLink.click();
		return new HotelPage();
	}
	
	/*
	 * public void clickOnNewContactLink(){ 
	 * Actions action = new Actions(driver);
	 * action.moveToElement(contactsLink).build().perform(); 
	 * newContactLink.click();
	 * 
	 * }
	 */

}
