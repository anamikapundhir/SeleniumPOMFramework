package com.crm.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends Base {

	LoginPage loginPage;
	HomePage homepage;
	ContactPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtils util;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		util = new TestUtils();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
	}
	
	@Test
	public void verifyHomepageTitle() {
		String title = homepage.validatePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Homepage title is incorrect");
	}
	
	@Test
	public void verifyUserIsLoggedIn() {
		Assert.assertTrue(homepage.validateUserLabel(), "User is not logged in");
	}
	
	@Test
	public void verifyContactsLink() {
		contactPage = homepage.clickOnContact();
	}
	
	@Test
	public void verifyDealssLink() {
		dealsPage = homepage.clickOnDeals();
	}
	
	@Test
	public void verifyContactsTasks() {
		tasksPage = homepage.clickOnTasks();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
