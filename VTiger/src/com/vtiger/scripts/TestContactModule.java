package com.vtiger.scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.generic.FileLibUtils;
import com.vtiger.generic.WebDriverUtils;
import com.vtiger.pages.ContactListPage;
import com.vtiger.pages.CreateContactPage;
import com.vtiger.pages.HomePage;

public class TestContactModule extends BaseTest {
	FileLibUtils flu = new FileLibUtils();
	WebDriverUtils wdu = new WebDriverUtils();
	@Test(priority = 1, groups = "SmokeTesting")
	public void createContact() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		
		String cname = flu.read_XL_Data("CreateContact", 1, 1) + wdu.randomNumber();
		
		HomePage hp = new HomePage(driver);
		ContactListPage clp = hp.clickContactModule();
		CreateContactPage ccp = clp.clickCreateContact();
		ccp.enterContactDetails(cname);
		hp.clickContactModule();
		String actcontact = clp.getContactInfo(cname, "Last Name");
		
		Assert.assertEquals(actcontact, cname);
		
	}
	@Test(priority = 2, groups = "regTesting")
	public void createContactWithFname() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		int ran = wdu.randomNumber();
		String cname = flu.read_XL_Data("CreateContact", 1, 1 )+ ran;
		
		String fname = flu.read_XL_Data("CreateContact", 1, 0) + ran;
		
		HomePage hp = new HomePage(driver);
		ContactListPage clp = hp.clickContactModule();
		CreateContactPage ccp = clp.clickCreateContact();
		ccp.enterContactDetails(fname,cname);
		hp.clickContactModule();
		String actcontact = clp.getContactInfo(cname, "Last Name");
		
		Assert.assertEquals(actcontact, cname);
		
	}
	@Test(priority = 3, groups = "regTesting")
	public void createContactWithPhno() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		int ran = wdu.randomNumber();
		String cname = flu.read_XL_Data("CreateContact", 1, 1) + ran;
		String fname = flu.read_XL_Data("CreateContact", 1, 0) + ran;
		String phno = flu.read_XL_Data("CreateContact", 1, 2);
		
		HomePage hp = new HomePage(driver);
		ContactListPage clp = hp.clickContactModule();
		CreateContactPage ccp = clp.clickCreateContact();
		ccp.enterContactDetails(fname,cname,phno);
		hp.clickContactModule();
		String actcontact = clp.getContactInfo(cname, "Last Name");
		
		Assert.assertEquals(actcontact, cname);
		
	}


}
