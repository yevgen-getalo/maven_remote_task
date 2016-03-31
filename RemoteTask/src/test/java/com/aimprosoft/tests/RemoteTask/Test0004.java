package com.aimprosoft.tests.RemoteTask;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test0004 {
	String testId = "01.0004";
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
	public void test0004()throws Exception{
		startPage = new StartPage(driver);
		searchPage = startPage.searchFor("robo");
		searchPage.findLink("Robohunter");
		
		driver.findElement(By.linkText("СОБЫТИЯ")).click();
		driver.findElement(By.id("book-third")).click();
		driver.findElement(By.xpath(".//*[@id='book-and-article']/div/div[2]/div[2]/b")).click();
		driver.findElement(By.xpath(".//*[@id='book-and-article']/div/div[2]/div[3]/ul/li[6]")).click();
	    driver.findElement(By.xpath(".//*[@id='book-and-article']/div/div[3]/input")).click();
	   try {
			assertFalse(driver.findElement(By.cssSelector("body")).getText()
					.matches("^[\\s\\S]*Марта[\\s\\S]*$"));
			System.out.println("Test: " + testId + " PASSED!!!");
		} catch (Error e) {
			System.out.println("Test: " + testId + " FAILED!!!");
		}
}

	@After
	public void end()throws Exception{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		driver.quit();
	}
}