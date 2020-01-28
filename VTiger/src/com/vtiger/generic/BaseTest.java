package com.vtiger.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class BaseTest implements IAutoConstnt{
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	FileLibUtils flu = new FileLibUtils();
	public WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass(groups = {"SmokeTesting","regTesting"})
	public void openBrowser(String browser) throws IOException {
		//String browser = flu.getDataFromPropertyFile("BROWSER");
		if(browser.equals("chrome")){
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(URL);
	}
	@BeforeMethod(groups = {"SmokeTesting","regTesting"})
	public void testLogin() throws IOException, InterruptedException {
		
		String un=flu.getDataFromPropertyFile("USERNAME");
		String pwd=flu.getDataFromPropertyFile("USERNAME");
		LoginPage lp = new LoginPage(driver);
		//lp.userLogin(un, pwd);
		lp.userLogin();
	}
	@AfterMethod(groups = {"SmokeTesting","regTesting"})
	public void testSignOut(){
		HomePage hp = new HomePage(driver);
		hp.clickSignOutBTN(driver);
	}
	@AfterClass(groups = {"SmokeTesting","regTesting"})
	public void closeApplication() {

		driver.close();
	}
}
