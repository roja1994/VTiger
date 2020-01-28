package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class SelectOrganizationMemberPage {
	WebDriverUtils wdu = new WebDriverUtils();
	WebDriver driver;
	public SelectOrganizationMemberPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(name = "search_field")
	private WebElement searchFieldDD;
	
	public WebElement getSearchFieldDD_WE() {
		return searchFieldDD;
	}
	
	public void selectSearchField(String option) {
		wdu.select(searchFieldDD, option);
	}
	public void selectSearchField(int index) {
		wdu.select(searchFieldDD, index);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTB;
	
	public WebElement SearchTB_WE() {
		return searchTB;
	}
	public void enterSearchTBAndClick(String member) {
		searchTB.sendKeys(member,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+member+"']")).click();
	}
	public void selectMember(String member) throws InterruptedException {
		
		wdu.switchToChildWindow(driver);
		wdu.waitForElementToBeClickable(driver, getSearchFieldDD_WE());
		selectSearchField("Organization Name");
		enterSearchTBAndClick(member);
		wdu.acceptAlert(driver);
		wdu.switchToParentWindow(driver);
	}
}
