package com.aimprosoft.tests.RemoteTask;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test0002 {
	String testId = "01.0002";
	private WebDriver driver = new FirefoxDriver();
	private SearchPage searchPage;
	private StartPage startPage;
	@Before
	public void setUp() throws Exception {
		System.out.println("Test: " + testId + " START");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test0002()throws Exception{
		startPage = new StartPage(driver);
		searchPage = startPage.searchFor("robo");
		searchPage.findLink("Robohunter");
		
	driver.findElement(By.className("search-button")).click();
	Assert.assertEquals("Robohunter", driver.getTitle());
	System.out.println("Search page - OK");
	WebElement input = driver.findElement(By.className("site-search"));
	input.sendKeys("tesla motors");
	input.submit();
	if (existsElement("TESLA MOTORS")) {
		System.out.println("Test: " + testId + " PASSED!!!");
	} else {
		System.out.println("Test: " + testId + " FAILED!!!");
	}

}
	@After
	public void end() throws Exception{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		driver.quit();
	}
	private boolean existsElement(String linkText) {
		try {
			driver.findElement(By.linkText(linkText));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	}
