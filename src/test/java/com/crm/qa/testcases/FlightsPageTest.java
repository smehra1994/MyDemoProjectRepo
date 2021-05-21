package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FlightsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;

public class FlightsPageTest extends TestBase {

	LoginPage loginPage;
	RegisterPage registerPage;
	FlightsPage flightsPage;

	//String sheetName = "contacts";

	public FlightsPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		flightsPage = new FlightsPage();
		loginPage = new LoginPage();
		registerPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// TestUtil.runTimeInfo("error", "login successful");
		// testUtil.switchToFrame();
		flightsPage = registerPage.clickOnFlightsLink();
	}

	@Test(priority = 1)
	public void verifyFlightsPageLabel() {
		Assert.assertTrue(flightsPage.verifyFlightsLabel(), "Flight label is missing on the page");
	}

	@Test(priority = 2)
	public void verifyFlightDetails() {
		flightsPage.verifyFlightDetails();
	}

	/*
	 * If we have a scenario where we have a contacts page with already added few
	 * contacts in form of check box : 
	 * 1) we have to check one
	 * 2) we need to add a new contact
	 */
	/*
	 
	 * @Test(priority=2) 
	 * public void selectSingleContactsTest(){
	 * FlightsPage.selectContactsByName("test2 test2"); }
	 * 
	 * @Test(priority=3) public void selectMultipleContactsTest(){
	 * FlightsPage.selectContactsByName("test2 test2");
	 * FlightsPage.selectContactsByName("ui uiii");
	 * 
	 * }
	 * 
	 * @DataProvider public Object[][] getDemoTestData()
	 * { 
	 * Object data[][] = TestUtil.getTestData(sheetName); //gettestdata class is of excel fetching code in util class
	 * return data;    
	 * }
	 * 
	 * 
	 * @Test(priority=4, dataProvider="getDemoTestData") 
	 * public void validateCreateNewContact(String title, String firstName, String lastName,String company)
	 * { 
	 * registerPage.clickOnNewContactLink();
	 * //flightsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	 * flightsPage.createNewContact(title, firstName, lastName, company);
	 * }
	 */
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
