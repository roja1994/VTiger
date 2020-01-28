package com.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Roja
 *
 */
public class WebDriverUtils extends BaseTest implements IAutoConstnt{
	/**
	 * The select method used to select with the help of Visible text
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select sec = new Select(element);
		sec.selectByVisibleText(option);
	}
	/**
	 * The select method used to select with the help of Index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sec = new Select(element);
		sec.selectByIndex(index);
	}
	/**
	 * The waitForElementToBeClickable is used for waiting for the element to be click 
	 * @param element
	 * @param driver
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * The waitForElementToBeClickable is used, waiting for the element to be click
	 * @param driver
	 * @param locator
	 */
	public void waitForElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForpresenceOfAllElementsLocatedBy(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	/**
	 * The waitForPageTitle is used for loading the page title 
	 * @param driver
	 * @param title
	 */
	public void waitForPageTitle(WebDriver driver, String title) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(title));
	}
	/**
	 * The waitForElementAndClick is used for custom wait
	 * @param driver
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitForElementAndClick(WebDriver driver, WebElement element) throws InterruptedException {
		int count=0;
		while(count<=20) {
			try {
				waitForElementToBeClickable(driver,element);
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * The randomNumber method is used to create the random number for the data 
	 * @return
	 */
	public int randomNumber() {;
		Random randomNum = new Random();
		return randomNum.nextInt(10000);
	}
	public static String parentWindowID;
	public static String childWindowID;
	/**
	 * The switchToChildWindow method is used to switch to next window
	 */
	public void switchToChildWindow(WebDriver driver) {
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> ite = wh.iterator();
		parentWindowID = ite.next();
		childWindowID = ite.next();
		
		driver.switchTo().window(childWindowID);
 	}
	/**
	 * The switchToParentWindow method is used to switch to main window
	 */
	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(parentWindowID);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
//	public static void takesScreenShot(WebDriver driver,String pp) throws IOException {
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File dsc=new File(pp);
//		FileUtils.copyFile(src, dsc);
//	}
	
}
