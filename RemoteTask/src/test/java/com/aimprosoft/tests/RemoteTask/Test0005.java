package com.aimprosoft.tests.RemoteTask;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test0005 {
	String testId = "01.0005";
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
	public void test0005()throws Exception{
		startPage = new StartPage(driver);
		searchPage = startPage.searchFor("robo");
		searchPage.findLink("Robohunter");
		
		driver.findElement(By.linkText("УСЛУГИ")).click();
		//Select doesn't work with hidden elements, so I use clicks by xpath
		driver.findElement(By.xpath("//*[@id='tabs']/form/div/div[1]/div[2]/b")).click();
		driver.findElement(By.xpath(".//*[@id='tabs']/form/div/div[1]/div[3]/ul/li[1]")).click();
		WebElement input = driver.findElement(By.id("q"));
		input.sendKeys("robot");
		input.submit();
			try {
			assertFalse(driver.findElement(By.cssSelector("body")).getText()
					.matches("^[\\s\\S]*ВСЕГО НАШЛИСЬ 0 РЕЗУЛЬТАТА[\\s\\S]*$"));
			System.out.println("Test: " + testId + " PASSED!!!");
		} catch (Error e) {
			System.out.println("Test: " + testId + " FAILED!!!");
			}
	}

	@After
	public void end() throws Exception {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		driver.quit();
		}
}
