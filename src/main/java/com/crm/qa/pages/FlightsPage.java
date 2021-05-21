package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class FlightsPage extends TestBase {
	
	@FindBy(xpath = "//img[@src='images/mast_flightfinder.gif']")
	@CacheLookup                        //it will save the label name in cache and next time it runs it will pick from cache and not html DOM
	WebElement FlightsLabel;
	
	@FindBy(xpath = "//input[@value='oneway']")
	WebElement type;
	
	@FindBy(xpath = "//select[@name='passCount']")
	WebElement count;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement FromPort;
	
	@FindBy(xpath = "//select[@name='fromMonth']")
	WebElement FromMonth;
	
	@FindBy(xpath = "//select[@name='fromDay']")
	WebElement FromDay;
	
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement ToPort;
	
	@FindBy(xpath = "//select[@name='toMonth']")
	WebElement ToMonth;
	
	@FindBy(xpath = "//select[@name='toDay']")
	WebElement ToDay;
	
	@FindBy(xpath = "//input[@name='servClass' and @value='Coach']")
	WebElement Class;
	
	@FindBy(xpath = "//select[@name='airline']")
	WebElement Preference;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	WebElement continueBtn;
	
	
	
	// Initializing the Page Objects:
	public FlightsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyFlightsLabel(){
		return FlightsLabel.isDisplayed();
	}
	

	public void verifyFlightDetails()
	{
		
		type.isSelected();
		
		Select a =new Select(count);
		a.selectByIndex(1);
		
		Select d =new Select(FromPort);
		d.selectByIndex(1);
		
		Select b =new Select(FromMonth);
		b.selectByIndex(2);
		
		Select c =new Select(FromDay);
		c.selectByIndex(2);
		
		Select e =new Select(ToPort);
		e.selectByIndex(1);
		
		Select f =new Select(ToMonth);
		f.selectByIndex(2);
		
		Select g =new Select(ToDay);
		g.selectByIndex(2);
		
		Class.click();
		
		Select h =new Select(Preference);
		h.selectByIndex(2);
		
		continueBtn.click();
		
	}
	
	/*
	 * If we have a scenario where we have a contacts page with already added few
	 * contacts in form of check box : 
	 * 1) we have to check one
	 * 2) we need to add a new contact
	 */

	/*
	 * public void selectContactsByName(String name){
	 * driver.findElement(By.xpath("//a[text()='"+name+
	 * "']//parent::td[@class='datalistrow']" +
	 * "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).
	 * click(); }
	 * 
	 * 
	 * public void createNewContact(String title, String ftName, String ltName,
	 * String comp)
	 * { 
	 * Select select = new Select(driver.findElement(By.name("title")));
	 * select.selectByVisibleText(title);
	 * firstName.sendKeys(ftName); 
	 * lastName.sendKeys(ltName);
	 * company.sendKeys(comp); 
	 * saveBtn.click();
	 * }
	 */
	
}
