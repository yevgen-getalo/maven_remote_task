package com.aimprosoft.tests.RemoteTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {
WebDriver driver;
public StartPage(WebDriver driver){
	this.driver = driver;
	String url = "https://www.google.com.ua/?gfe_rd=cr&ei=Oy7xVpu6F6Ot8weTmYGYAg&gws_rd=ssl";
	driver.get(url);	
}
public SearchPage searchFor(String location){
	try{
		WebElement searchField = driver.findElement(By.id("lst-ib"));
	searchField.sendKeys(location);
	searchField.submit();
	}catch (RuntimeException e){}
	return new SearchPage(driver);
}
}
