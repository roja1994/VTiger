package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class SelectCampaignsProductPage {
	
	WebDriverUtils wdu = new WebDriverUtils();
	WebDriver driver;
	
	public SelectCampaignsProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	String searchName="";
	
	//Select DropDown List
	@FindBy(name = "search_field")
	private WebElement selectDDList;
	
	public WebElement getSelectDDList_WE() {
		return selectDDList;
	}
	
	public void selectDDList(String name) {
		wdu.select(selectDDList, name);
	}
	
	//Search Text Box
	@FindBy(id = "search_txt")
	private WebElement searchTB;
	
	public WebElement getSearchTB_WE() {
		return searchTB;
	}
	
	public void setSearchTBAndClick(WebDriver driver, String member) {
		searchTB.sendKeys(member,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+member+"']")).click();
	}
	
	//click on search name
//	@FindBy(xpath = "//a[text()='"+searchName+"']")
//	private WebElement clickSearchName;
	
	
	public void selectProduct(String productName) {
		wdu.switchToChildWindow(driver);
		selectDDList("Product Name");
		setSearchTBAndClick(driver, productName);
		wdu.switchToParentWindow(driver);
	}
	
	
}
