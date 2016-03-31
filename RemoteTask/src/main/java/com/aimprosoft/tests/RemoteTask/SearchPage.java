package com.aimprosoft.tests.RemoteTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
private WebDriver driver;
public SearchPage(WebDriver driver){
	this.driver = driver;

}
public SearchPage findLink(String location){
for(int i = 0; i < 10; i++){
	try{
	WebElement wantedLink = driver.findElement(By.partialLinkText(location));
wantedLink.click();
break;
}catch (RuntimeException e){
	driver.findElement(By.id("pnnext")).click();
}
}
return new SearchPage(driver);
}
}
