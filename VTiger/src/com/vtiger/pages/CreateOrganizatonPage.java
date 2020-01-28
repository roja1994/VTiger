package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtils;

public class CreateOrganizatonPage {
	
	WebDriverUtils wdu = new WebDriverUtils();
	WebDriver driver;
	public CreateOrganizatonPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Account Name
	@FindBy(name = "accountname")
	private WebElement accountNameTB;
	
	public WebElement getAccountNameTB_WE() {
		return accountNameTB;
	}
		
	@FindBy(id = "phone")
	private WebElement phoneTB;
	
	public WebElement getPhoneTB_WE() {
		return phoneTB;
	}
		
	@FindBy(id = "email1")
	private WebElement emailTB;

	public WebElement getEmailTB_WE() {
		return emailTB;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	public WebElement getSaveBTN_WE() {
		return saveBTN;
	}
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectBTN;
	
	public WebElement getSelectBTN_WE() {
		return selectBTN;
	}
	
	public void clickselectBTN() {
		selectBTN.click();
	}
	
	
	
	
	
	//Business Method for Create Organization
	
	public void createOrganizationMD(String orgName, String email) {
		
		//Enter the elements
				
		accountNameTB.sendKeys(orgName);
		emailTB.sendKeys(email);
		
		wdu.waitForElementToBeClickable(driver, getSaveBTN_WE());
		saveBTN.click();
	
	}
	

	public void createOrganizationMD(String orgName, String email, String member) throws InterruptedException {
		
		//Enter the elements
				
		accountNameTB.sendKeys(orgName);
		emailTB.sendKeys(email);
		
		//click on  member Number
		clickselectBTN();
		
		SelectOrganizationMemberPage somp = new SelectOrganizationMemberPage(driver);
		somp.selectMember(member);
		
		wdu.waitForElementToBeClickable(driver, getSaveBTN_WE());
		saveBTN.click();
	
	}
	
public void createOrganizationMD(String orgName, String phone, String email, String member) throws InterruptedException {
		
		//Enter the elements
				
		accountNameTB.sendKeys(orgName);
		phoneTB.sendKeys(phone);
		emailTB.sendKeys(email);
		
		//click on  member Number
		clickselectBTN();
		
		SelectOrganizationMemberPage somp = new SelectOrganizationMemberPage(driver);
		somp.selectMember(member);
		
		wdu.waitForElementToBeClickable(driver, getSaveBTN_WE());
		saveBTN.click();
	
	}
}
