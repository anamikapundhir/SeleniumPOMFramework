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

public class ContactsPageTest extends Base{

	LoginPage loginPage;
	HomePage homepage;
	ContactPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtils util;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		util = new TestUtils();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchToFrame();
		contactPage = homepage.clickOnContact();
	}
	
	@Test
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactPage.verifyContactsLabel(), "Contact label is not displayed");
	}
	
	@Test
	public void verifyCheckBoxIsSelected() {
		Assert.assertTrue(contactPage.selectUserCheckBoxByName("David Cris"), "Checkbox is not selected");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
