package com.aimprosoft.tests.RemoteTask;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test0001 {
	String testId = "01.0001";
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
	public void test0001()throws Exception{
		startPage = new StartPage(driver);
		searchPage = startPage.searchFor("robo");
		searchPage.findLink("Robohunter");
		String originalWindow = driver.getWindowHandle();
		final Set<String> oldWindowsSet = driver.getWindowHandles();
		driver.get("http://www.robo-hunter.com/");
		ArrayList<WebElement> sites = new ArrayList<WebElement>();
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[1]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[2]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[3]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[4]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[5]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[6]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[7]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[8]/a")));
		sites.add(driver.findElement(By.xpath("html/body/section/div/header/ul/li[9]/a")));
		for (WebElement item : sites) {
			item.click();
			String newWindow = (new WebDriverWait(driver, 10))
					.until(new ExpectedCondition<String>() {
						public String apply(WebDriver driver) {
							Set<String> newWindowsSet = driver
									.getWindowHandles();
							newWindowsSet.removeAll(oldWindowsSet);
							return newWindowsSet.size() > 0 ? newWindowsSet
									.iterator().next() : null;
								}
					});
			driver.switchTo().window(newWindow);
			System.out.println(driver.getCurrentUrl());
			driver.close();
			driver.switchTo().window(originalWindow);
		}
		System.out.println("Test: " + " PASSED!!!");
	}
	@After
	public void down()throws Exception{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	driver.quit();
	}
}

