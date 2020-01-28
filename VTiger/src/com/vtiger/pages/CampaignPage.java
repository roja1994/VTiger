package com.vtiger.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class CampaignPage {
	
	WebDriverUtils wdu = new WebDriverUtils();
	WebDriver driver ;
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampiagnBTN;
	
	public WebElement getCreateCampiagn_WE() {
		return createCampiagnBTN;
	}
	public CreateCampaignPage clickCreateCampiagn() {
		wdu.waitForElementToBeClickable(driver, getCreateCampiagn_WE());
		createCampiagnBTN.click();
		return new CreateCampaignPage(driver);
	}
	
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(name = "search_text")
	private WebElement searchTB;
	
	public String getCampaignInfo(String campName,String option) {
		wdu.select(searchFieldDD, option);
		searchTB.sendKeys(campName,Keys.ENTER);
		String searchedElement = driver.findElement(By.xpath("(//a[text()='"+campName+"'])[2]")).getText();
		return searchedElement;
	}
	
	
}
