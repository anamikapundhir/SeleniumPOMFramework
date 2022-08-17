package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class HomePage extends Base{
	
	// OR :
	@FindBy(xpath="//td[contains(text(), 'User')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	// initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions :
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateUserLabel() {
		return usernameLabel.isDisplayed();
	}
	
	public ContactPage clickOnContact() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		tasksLink.click();
		return new TasksPage();
	}
}
