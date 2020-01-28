package com.vtiger.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.generic.BaseTest;
import com.vtiger.pages.LoginPage;

public class TestLoginPage extends BaseTest{
	@Test
	public void testLogin() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.userLogin();
	}
}
