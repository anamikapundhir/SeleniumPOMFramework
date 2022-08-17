package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

	// Object Repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@class='navbar-brand']/img")
	WebElement crmLogo;

	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;

	// Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions :
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateCrmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
