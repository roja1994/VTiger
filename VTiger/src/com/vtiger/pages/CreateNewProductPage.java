package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	//Initialization
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(name = "productname")
	private WebElement productNameTXB;
	
	public WebElement getProductNameWebElement() {
		return productNameTXB;
	}
	public void setProductName(String name) {
		productNameTXB.sendKeys(name);
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;

	public void clickSave() {
		saveBTN.click();
	}
	
	public void enterDetailsAndClickOnSaveBTN(String name) {
		productNameTXB.sendKeys(name);
		saveBTN.click();
	}
}