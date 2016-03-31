package com.aimprosoft.tests.RemoteTask;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test0003 {
	String testId = "01.0003";
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
	public void test0003()throws Exception{
		startPage = new StartPage(driver);
		searchPage = startPage.searchFor("robo");
		searchPage.findLink("Robohunter");
		
		driver.findElement(By.linkText("НОВОСТИ")).click();
	    driver.findElement(By.linkText("НАУЧНАЯ ФАНТАСТИКА")).click();
	    Assert.assertEquals("http://www.robo-hunter.com/tags/nauchnaya-fantastika", driver.getCurrentUrl());
		System.out.println("Test: " + testId + " PASSED!!!");
	
	}
	
@After
	public void tearDown() throws Exception {
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		driver.quit();


}
}
