package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class OrganizationListPage {
	WebDriverUtils wdu = new WebDriverUtils();
	WebDriver driver;
	public OrganizationListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationBTN;
	
	public WebElement getCreateOrganizationBTN_WE() {
		return createOrganizationBTN;
	}
	public CreateOrganizatonPage clickCreateOrganization() {
		wdu.waitForElementToBeClickable(driver, getCreateOrganizationBTN_WE());
		createOrganizationBTN.click();
		return new CreateOrganizatonPage(driver);
	}
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(name = "search_text")
	private WebElement searchTB;
	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}
	public WebElement getSearchTB() {
		return searchTB;
	}
	
	public String getOrgNameInfo(String orgName, String option) throws InterruptedException{
		selectOrganizationNameandget(orgName,option);
		String searchedElement = driver.findElement(By.xpath("(//a[text()='"+orgName+"'])[2]")).getText();
		return searchedElement;
	}
	
	public void selectOrganizationNameandget(String orgName, String option) throws InterruptedException {
		wdu.waitForElementAndClick(driver, searchFieldDD);
		wdu.select(searchFieldDD, option);
		searchTB.sendKeys(orgName,Keys.ENTER);
	}
	
	
}
