package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class ProductPage {
	WebDriver driver;
	WebDriverUtils wdu = new WebDriverUtils();
	//Initialization
	public ProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//Deceleration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductBTN;
	
	public WebElement getCreateProductBTNWebElement() {
		return createProductBTN;
	}
	
	public CreateNewProductPage clickCreateProduct() {
		wdu.waitForElementToBeClickable(driver, getCreateProductBTNWebElement());
		createProductBTN.click();
		return new CreateNewProductPage(driver);
	}
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(name = "search_text")
	private WebElement searchTB;
	
	public String getProductInfo(String productName,String option) throws InterruptedException {
		wdu.waitForElementAndClick(driver, searchFieldDD);
		wdu.select(searchFieldDD, option);
		searchTB.sendKeys(productName,Keys.ENTER);
		String searchedElement = driver.findElement(By.xpath("(//a[text()='"+productName+"'])[2]")).getText();
		return searchedElement;
	}
}
