package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.generic.WebDriverUtils;

public class CreateCampaignPage {
	
	WebDriver driver;
	WebDriverUtils wdu = new WebDriverUtils();
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//campaign Name
	
	@FindBy(name = "campaignname")
	private WebElement campaignNameTB;
	
	public WebElement getCampaignNama_WE() {
		return campaignNameTB;
	}
	public void enterCampaignName(String name) {
		campaignNameTB.sendKeys(name);
	}
	
	
	//Assigned To
	@FindBy(xpath = "//input[@value='T']")
	private WebElement selectGroupRB;
	
	public WebElement getSelectGroupRB_WE() {
		return selectGroupRB;
	}
	public void selectGroupRB() {
		selectGroupRB.click();
	}
	
	//product Btn
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement productBTN;
	
	public WebElement getProductBTNWebElement() {
		return productBTN;
	}
	
	public void clickProductBTN() {
		productBTN.click();
	}
	
	//save BTN
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public WebElement getSaveBTN_WE() {
		return saveBTN;
	}
	public void clickSaveBTN() {
		saveBTN.click();
	}

	@FindBy(name = "actualcost")
	private WebElement actualCostTB;
	
	public WebElement getActualCost() {
		return actualCostTB;
	}
	
	@FindBy(name = "expectedrevenue")
	private WebElement expectedRevenueTB;
	
	public WebElement getExpectedRevenue() {
		return expectedRevenueTB;
	}
	
	
	public void enterCampaignDetails(WebDriver driver, String campaignName, String productName) throws InterruptedException {
		campaignNameTB.sendKeys(campaignName);
		selectGroupRB();
		
		clickProductBTN();
		
		SelectCampaignsProductPage scmp = new SelectCampaignsProductPage(driver);
		scmp.selectProduct(productName);
		wdu.waitForElementToBeClickable(driver, getSaveBTN_WE());
		clickSaveBTN();
	}

	public void enterCampaignDetails(WebDriver driver, String campaignName, String productName, String actualCost) throws InterruptedException {
		campaignNameTB.sendKeys(campaignName);
		selectGroupRB();
		
		clickProductBTN();
		
		SelectCampaignsProductPage scmp = new SelectCampaignsProductPage(driver);
		scmp.selectProduct(productName);

		
		wdu.waitForElementAndClick(driver, actualCostTB);
		actualCostTB.sendKeys(actualCost);
		
		
		wdu.waitForElementToBeClickable(driver, getSaveBTN_WE());
		clickSaveBTN();
	}
	
	
	public void enterCampaignDetails(WebDriver driver, String campaignName, String productName, String actualCost, String expectedRevenue) throws InterruptedException {
		campaignNameTB.sendKeys(campaignName);
		selectGroupRB();
		
		clickProductBTN();
		SelectCampaignsProductPage scmp = new SelectCampaignsProductPage(driver);
		scmp.selectProduct(productName);

		
		wdu.waitForElementAndClick(driver, actualCostTB);
		actualCostTB.sendKeys(actualCost);
		expectedRevenueTB.sendKeys(expectedRevenue);
		
		wdu.waitForElementToBeClickable(driver, getSaveBTN_WE());
		clickSaveBTN();
	}

}
