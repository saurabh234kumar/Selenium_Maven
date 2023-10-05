package com.suadeo.WEB.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuadeoSearchPage {
	
	private static WebElement element = null;
	
	public static WebElement textbox_search(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[2]/button[2]"));
		element.click();
		return element;
		
	}
	
	public static WebElement search_Enter(WebDriver driver)
	{
		element = driver.findElement(By.id("search-suggest-text"));
		element.sendKeys("lense");
				driver.findElement(By.id("search-suggest-text")).sendKeys(Keys.RETURN);
				return element;
		
	}

}
