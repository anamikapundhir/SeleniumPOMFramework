package com.crm.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	LoginPage loginPage;
	HomePage homepage;

//	public LoginPageTest() {
//		super();
//	}

	@BeforeMethod
	public void setIp() {
		init();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void validateLoginPageTitle() {
		String pageTitle = loginPage.validatePageTitle();
		Assert.assertEquals(pageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void validateLogo() {
		Boolean logoflag = loginPage.validateCrmLogo();
		Assert.assertTrue(logoflag);
	}

	@Test(priority = 3)
	public void validateLogin() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
