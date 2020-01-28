package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class CreateContactPage {
	
	WebDriver driver;
	WebDriverUtils wdu = new WebDriverUtils();
	public CreateContactPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name = "firstname")
	private WebElement fnameTB;
	
	@FindBy(name = "lastname")
	private WebElement lnameTB;
	
	@FindBy(id = "phone")
	private WebElement phnoTB;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBTN;
	
	public WebElement getFnameTB() {
		return fnameTB;
	}

	public WebElement getLnameTB() {
		return lnameTB;
	}

	public WebElement getPhnoTB() {
		return phnoTB;
	}
	
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	public void enterContactDetails(String lname) {
		
		lnameTB.sendKeys(lname);
		wdu.waitForElementToBeClickable(driver, saveBTN);
		saveBTN.click();
	}
	
	public void enterContactDetails(String fname,String lname) {
		
		fnameTB.sendKeys(fname);
		lnameTB.sendKeys(lname);
		wdu.waitForElementToBeClickable(driver, saveBTN);
		saveBTN.click();
	}
	
	public void enterContactDetails(String fname,String lname, String phno) {
		
		fnameTB.sendKeys(fname);
		phnoTB.sendKeys(phno);
		lnameTB.sendKeys(lname);
		wdu.waitForElementToBeClickable(driver, saveBTN);
		saveBTN.click();

	}
	
	
	
}
