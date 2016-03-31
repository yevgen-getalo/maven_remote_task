package com.aimprosoft.tests.RemoteTask;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test0006 {
	String testId = "01.0006";
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
	public void test0006()throws Exception{
		startPage = new StartPage(driver);
		searchPage = startPage.searchFor("robo");
		searchPage.findLink("Robohunter");
		driver.findElement(By.linkText("НОВОСТИ")).click();
		assertEquals("http://www.robo-hunter.com/news", driver.getCurrentUrl());
		System.out.println("News page - OK");
		driver.findElement(By.linkText("ФОТОРЕПОРТАЖ")).click();
		assertTrue(driver.getCurrentUrl().contains("fotoreportaj"));
		System.out.println("Sorting - OK");
		driver.findElement(By.xpath(".//*[@id='listNews']/div[1]/a[10]/div/div[3]")).click();
		assertTrue(driver.getCurrentUrl().contains("kosmicheskii"));
		System.out.println("Article page - OK");
		driver.findElement(By.xpath("html/body/section/div/header/a/img[1]")).click();
		assertTrue(driver.getCurrentUrl().contains("robo-hunter"));
		System.out.println("Main page - OK");
		System.out.println("Test: " + testId + " PASSED!!!");
}
	@After
	public void end()throws Exception{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		driver.quit();
	}
}
