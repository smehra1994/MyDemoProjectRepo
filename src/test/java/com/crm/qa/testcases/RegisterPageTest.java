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
import com.crm.qa.util.TestUtil;


public class RegisterPageTest extends TestBase {

	LoginPage loginPage;
	RegisterPage registerPage;
	TestUtil testUtil;
	FlightsPage flightsPage;
	HotelPage hotelPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		registerPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyRegisterPageTitleTest() {
		String registerPageTitle = registerPage.verifyRegisterPageTitle();
		Assert.assertEquals(registerPageTitle, "Login: Mercury Tours", "Homepage title did not match");    //if title unmatch will return the other msg
	}

	@Test(priority = 2)
	public void verifyCorrectPageNameTest() {
		//testUtil.switchToFrame();     //in case x path not getting identified and has frame
		Assert.assertTrue(registerPage.verifyCorrectPageName());      //return true or false on condition
	}
	
	@Test(priority=3)
	public void verifyFlightsLinkTest(){
		flightsPage = registerPage.clickOnFlightsLink();
	}
	
	@Test(priority=4)
	public void verifyHotelLinkTest(){
		hotelPage = registerPage.clickOnHotelLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
