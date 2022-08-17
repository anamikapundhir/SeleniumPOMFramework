package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class ContactPage extends Base{

	// OR:
	@FindBy (xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	// initialization
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public boolean selectUserCheckBoxByName(String name) {
		WebElement checkBox = driver.findElement(By.xpath("//a[@_name ='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		checkBox.click();
		return checkBox.isEnabled();
	}
	
}
