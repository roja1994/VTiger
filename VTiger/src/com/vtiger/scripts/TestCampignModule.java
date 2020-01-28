package com.vtiger.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.FileLibUtils;
import com.vtiger.generic.WebDriverUtils;
import com.vtiger.pages.CampaignPage;
import com.vtiger.pages.CreateCampaignPage;
import com.vtiger.pages.CreateNewProductPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.ProductPage;
import com.vtiger.pages.SelectCampaignsProductPage;
import com.vtiger.pages.SelectOrganizationMemberPage;

public class TestCampignModule extends BaseTest{
	String productName = "";
	FileLibUtils flu = new FileLibUtils();
	WebDriverUtils wdu = new WebDriverUtils();
//	@DataProvider(name = "createProduct")
//	public Object[][] dataCreateProduct() throws EncryptedDocumentException, FileNotFoundException, IOException{
//		return flu.dataInput("CreateProduct");
//	}
	
	@Test(priority = 1, groups = {"SmokeTesting","regTesting"})
	public void testCreateProduct() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		productName = flu.read_XL_Data("CreateProduct", 1, 0)+wdu.randomNumber();
		
		HomePage hp = new HomePage(driver);
		
		ProductPage pp = hp.clickProductModule();
		
		CreateNewProductPage cnpp = pp.clickCreateProduct();
		
		cnpp.enterDetailsAndClickOnSaveBTN(productName);
		
		hp.clickProductModule();
		
		String actProduct =pp.getProductInfo(productName, "Product Name");
		
		Assert.assertEquals(actProduct, productName);
	
	}
	
//	@DataProvider(name = "createCampaign")
//	public Object[][] inputCreateCampaign() throws EncryptedDocumentException, FileNotFoundException, IOException{
//		return flu.dataInput("CreateCampaigns");
//	}
	
	@Test(priority = 2, groups = "SmokeTesting")
	public void testCreateCampaigns() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		
		String campaignName = flu.read_XL_Data("CreateCampaigns", 1, 0)+wdu.randomNumber();
		
		HomePage hp = new HomePage(driver);
		
		CampaignPage cp = hp.clickCampaignModule();
		
		CreateCampaignPage ccp = cp.clickCreateCampiagn();
		
		ccp.enterCampaignDetails(driver,campaignName, productName);
		
		hp.clickCampaignModule();
		
		String actProduct =cp.getCampaignInfo(campaignName, "Campaign Name");
		
		Assert.assertEquals(actProduct, campaignName);
		
	}
	
	
	
	
	@Test(priority = 3, groups = "regTesting")
	public void testCreateCampaignsWithActualCost() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		String campaignName = flu.read_XL_Data("CreateCampaigns", 1, 0)+wdu.randomNumber();
		
		HomePage hp = new HomePage(driver);
		
		CampaignPage cp = hp.clickCampaignModule();
		
		CreateCampaignPage ccp = cp.clickCreateCampiagn();
		
		ccp.enterCampaignDetails(driver, campaignName, productName,flu.read_XL_Data("CreateCampaigns", 1, 1));
		
		hp.clickCampaignModule();
		
		String actProduct =cp.getCampaignInfo(campaignName, "Campaign Name");
		
		Assert.assertEquals(actProduct, campaignName);
		
	}
	
	@Test(priority = 4, groups = "regTesting")
	public void testCreateCampaignsWithExpectedRevenue() throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException {
		
		String campaignName = flu.read_XL_Data("CreateCampaigns", 1, 0)+wdu.randomNumber();
		
		HomePage hp = new HomePage(driver);
		
		CampaignPage cp = hp.clickCampaignModule();
		
		CreateCampaignPage ccp = cp.clickCreateCampiagn();
		
		ccp.enterCampaignDetails(driver, campaignName, productName, flu.read_XL_Data("CreateCampaigns", 1, 1), flu.read_XL_Data("CreateCampaigns", 1, 2));
		
		hp.clickCampaignModule();
		
		String actProduct =cp.getCampaignInfo(campaignName, "Campaign Name");
		
		Assert.assertEquals(actProduct, campaignName);
		
	}
	

}