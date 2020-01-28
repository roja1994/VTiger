package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class HomePage {
	WebDriverUtils wdu = new WebDriverUtils();
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//Product Module
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productModule;
	
	public WebElement getProductModule_WE() {
		return productModule;
	}
	public ProductPage clickProductModule() {
		wdu.waitForElementToBeClickable(driver, getProductModule_WE());
		productModule.click();
		return new ProductPage(driver);
	}
	
	//More Module
	@FindBy (xpath = "//a[text()='More']")
	private WebElement moreModule;
	
	public WebElement getMoreModule_WE() {
		return moreModule;
	}
	
	public void clickMoreModule(WebDriver driver) {
		wdu.moveToElement(driver, moreModule);
	}
	
	//Campaigns Module
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaignsModule;

	public WebElement getCampaignsModule_WE() {
		return campaignsModule;
	}
	
	public CampaignPage clickCampaignModule() {
		moreModule.click();
		campaignsModule.click();
		return new CampaignPage(driver);
	}
	
	//Organizations Module
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationsModule;
	
	public WebElement getOrganizationsModule_WE() {
		return organizationsModule;
	}
	
	public OrganizationListPage clickOrganizationsModule() throws InterruptedException {
		//wdu.waitForElementToBeClickable(driver, getOrganizationsModule_WE());
		
		wdu.waitForElementAndClick(driver,getOrganizationsModule_WE());
		driver.navigate().refresh();
		organizationsModule.click();
		return new OrganizationListPage(driver);
	}
	
	//sign Out
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBTN;
	
	@FindBy(xpath = "(//td[@class='small']/img)[1]")
	private WebElement imgSign;
	
	public WebElement getSignOutBTN_WE() {
		return signOutBTN;
	}
	public void clickSignOutBTN(WebDriver driver) {
		wdu.moveToElement(driver, imgSign);
		signOutBTN.click();
	}
	
	//Contacts Module
	@FindBy(xpath = "(//a[text()='Contacts'])[1]")
	private WebElement contactModule;
	
	public WebElement getContactModule() {
		return contactModule;
	}
	
	public ContactListPage clickContactModule() {
		wdu.moveToElement(driver, contactModule);
		contactModule.click();
		return new ContactListPage(driver);
	}
}
