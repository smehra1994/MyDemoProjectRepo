package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FlightsPage;
import com.crm.qa.pages.HotelPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;

public class HotelPageTest extends TestBase{

	LoginPage loginPage;
	RegisterPage registerPage;
	HotelPage hotelPage;

	String sheetName = "contacts";

	public HotelPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		hotelPage = new HotelPage();
		loginPage = new LoginPage();
		registerPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		// TestUtil.runTimeInfo("error", "login successful");
		// testUtil.switchToFrame();
		hotelPage = registerPage.clickOnHotelLink();
	}

	@Test(priority = 1)
	public void verifyHotelPageLabel() {
		Assert.assertTrue(hotelPage.verifyHotelLabel(), "Hotel label is missing on the page");
	}
	
	@Test(priority = 2)
	public void verifyHotelDetails() {
		//registerPage.clickOnHotelLink();
		hotelPage.verifyHotelDetails();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
