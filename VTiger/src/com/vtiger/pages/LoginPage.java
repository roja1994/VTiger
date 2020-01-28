package com.vtiger.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vtiger.generic.FileLibUtils;
import com.vtiger.generic.WebDriverUtils;

public class LoginPage {
	WebDriver driver ;
	FileLibUtils flu = new FileLibUtils();
	WebDriverUtils wdu = new WebDriverUtils();
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//User Name
	@FindBy(name = "user_name")
	private WebElement userNameTB;
	
	public WebElement getUserNameTB_WE() {
		return userNameTB;
	}
	//Password
	@FindBy(name = "user_password")
	private WebElement passwordTB;
	
	public WebElement getPasswordTB_WE() {
		return passwordTB;
	}
	
	//click Login BTN
	@FindBy(id = "submitButton")
	private WebElement loginBTN;
	
	public WebElement getLoginBTN_WE() {
		return loginBTN;
	}
	
	//verify Error msg
	@FindBy(className = "errorMessage")
	private WebElement verifyErrorMSG;
	
	public WebElement getVerifyErrorMSG_WE() {
		return verifyErrorMSG;
	}
	
//	public void displayErrroMSG() {
//		Assert.assertEquals(verifyErrorMSG.getText(), "You must specify a valid username and password.");
//	}
	//Business Method for Login
	public void userLogin(String userName, String password) {
		userNameTB.sendKeys(userName);
		passwordTB.sendKeys(password);
		loginBTN.click();
		//displayErrroMSG();
	}
	public void userLogin() throws IOException, InterruptedException {
		wdu.waitForElementAndClick(driver, userNameTB);
		userNameTB.sendKeys("admin");
		passwordTB.sendKeys("admin");
		loginBTN.click();
		//displayErrroMSG();
	}
}
