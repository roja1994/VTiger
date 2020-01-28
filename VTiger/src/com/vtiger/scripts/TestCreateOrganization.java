package com.vtiger.scripts;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.omg.PortableInterceptor.HOLDING;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.FileLibUtils;
import com.vtiger.generic.WebDriverUtils;
import com.vtiger.pages.CreateOrganizatonPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.OrganizationListPage;
import com.vtiger.pages.SelectOrganizationMemberPage;

public class TestCreateOrganization extends BaseTest {
	WebDriverUtils wdu = new WebDriverUtils();
	String member = ""; 
	FileLibUtils flu = new FileLibUtils();
//	@DataProvider(name = "preCondOrg")
//	public Object[][] dataPreConditionOrganization() throws EncryptedDocumentException, FileNotFoundException, IOException{
//		return flu.dataInput("PreConditionOrganization");
//	}
	
	
	@Test(priority = 2, groups = {"SmokeTesting", "regTesting"})
	public void testCreateOrganizationPre() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		int ranNum = wdu.randomNumber();
		String orgName = flu.read_XL_Data("PreConditionOrganization", 1, 0)+ranNum;
		String phone = flu.read_XL_Data("PreConditionOrganization", 1, 1);
		String email = flu.read_XL_Data("PreConditionOrganization", 1, 2)+ranNum+"@gmail.com";
		member = orgName;
		
		HomePage hp = new HomePage(driver);
		OrganizationListPage olp =hp.clickOrganizationsModule();
		
		CreateOrganizatonPage cop= olp.clickCreateOrganization();
		
		cop.createOrganizationMD(orgName, email);
	
		hp.clickOrganizationsModule();
		
		String actORg = olp.getOrgNameInfo(orgName,"Organization Name");
		
		Assert.assertEquals(actORg, orgName);
		
	}
	
	
//	@DataProvider(name = "org")
//	public Object[][] dataCreateOrganization() throws EncryptedDocumentException, FileNotFoundException, IOException{
//		return flu.dataInput("CreateOrganization");
//	}
	
	@Test(priority = 3, groups = "SmokeTesting")
	public void testCreateOrganization() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		
		int ranNum = wdu.randomNumber();
		String orgName = flu.read_XL_Data("CreateOrganization", 1, 0)+ranNum;
		String email = flu.read_XL_Data("CreateOrganization", 1, 2)+ranNum+"@gmail.com";
		
		HomePage hp = new HomePage(driver);
		OrganizationListPage olp =hp.clickOrganizationsModule();
		
		CreateOrganizatonPage cop= olp.clickCreateOrganization();
		
		cop.createOrganizationMD(orgName, email,member);
		
		hp.clickOrganizationsModule();
		String actORg = olp.getOrgNameInfo(orgName,"Organization Name");
		Assert.assertEquals(actORg, orgName);
	}
	
	@Test(priority = 4, groups = "regTesting")
	public void testCreateOrganizationWithPhoneNo() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		
		int ranNum = wdu.randomNumber();
		String orgName = flu.read_XL_Data("CreateOrganization", 1, 0)+ranNum;
		String phone = flu.read_XL_Data("CreateOrganization", 1, 1);
		String email = flu.read_XL_Data("CreateOrganization", 1, 2)+ranNum+"@gmail.com";
		
		HomePage hp = new HomePage(driver);
		OrganizationListPage olp =hp.clickOrganizationsModule();
		
		CreateOrganizatonPage cop= olp.clickCreateOrganization();
		
		cop.createOrganizationMD(orgName, phone, email,member);
		
		hp.clickOrganizationsModule();
		String actORg = olp.getOrgNameInfo(orgName,"Organization Name");
		Assert.assertEquals(actORg, orgName);
	}
}
