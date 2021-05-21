package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;


public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	RegisterPage registerPage;

	public LoginPageTest() {
		super(); // this will run first in this class and will directly call parent class i.e
					// TestBase
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours"); // get this value of title by right
																					// click on main page and view
																					// source code
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateTPImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {

		registerPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
