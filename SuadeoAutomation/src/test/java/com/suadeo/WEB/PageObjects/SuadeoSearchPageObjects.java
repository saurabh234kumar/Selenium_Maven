package com.suadeo.WEB.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SuadeoSearchPageObjects {
	WebDriver driver = null;
	
	
	By textbox_search = By.xpath("//body[1]/div[2]/header[1]/div[2]/div[1]/div[1]/div[2]/button[2]");
	By search_Enter = By.id("search-suggest-text");
	
	public SuadeoSearchPageObjects(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSearchbutton()
	{
		driver.findElement(textbox_search).click();
		
	}
	
	public void searchproduct_Enter(String text)
	{
		driver.findElement(search_Enter).sendKeys(text);
		driver.findElement(search_Enter).sendKeys(Keys.RETURN);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
