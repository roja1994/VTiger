package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class ContactListPage {
	
	WebDriver driver;
	WebDriverUtils wdu = new WebDriverUtils();
	
	public ContactListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBTN;
	
	public WebElement getCreateContactBTN() {
		return createContactBTN;
	}
	
	public CreateContactPage clickCreateContact() {
		wdu.waitForElementToBeClickable(driver, createContactBTN);
		createContactBTN.click();
		return new CreateContactPage(driver);
	}
	
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(name = "search_text")
	private WebElement searchTB;
	
	public String getContactInfo(String contactName,String option) throws InterruptedException {
		wdu.waitForElementAndClick(driver, searchFieldDD);
		wdu.select(searchFieldDD, option);
		searchTB.sendKeys(contactName,Keys.ENTER);
		String searchedElement = driver.findElement(By.xpath("//a[text()='"+contactName+"']")).getText();
		return searchedElement;
	}
	
	
}
