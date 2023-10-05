package com.suadeo.WEB.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suadeo.WEB.Locators.SuadeoLocators;
import com.suadeo.browser.utils.WebUtils;


public class SuadeoMenuPage extends WebUtils{




	@FindBy(xpath = SuadeoLocators.HomeMenu_Xpath)
	private WebElement HomeMenu_Xpath;

	@FindBy(id = SuadeoLocators.HomeLang_ID)
	private WebElement HomeLang_ID;

	@FindBy(xpath = SuadeoLocators.HomeLang_Eng_Xpath)
	private WebElement HomeLang_Eng_Xpath;

	@FindBy(xpath = SuadeoLocators.HomeMessage_Xpath)
	private WebElement HomeMessage_Xpath;

	@FindBy(xpath = SuadeoLocators.HomeCalender_Xpath)
	private WebElement HomeCalender_Xpath;

	@FindBy(xpath = SuadeoLocators.HomePageLogo_Xpath)
	private WebElement HomePageLogo_Xpath;
	
	
	@FindBy(xpath = SuadeoLocators.HomeSearch_Xpath)
	private WebElement HomeSearch_Xpath;
	
	
	@FindBy(xpath = SuadeoLocators.HomeSearchinput_Xpath)
	private WebElement HomeSearchinput_Xpath;
	
	



	public SuadeoMenuPage(WebDriver testdriver) {
		super(testdriver);
		//SearchContext driver = null;
		PageFactory.initElements(driver, this);

	}

	public  boolean  HomeMenu_Click() throws InterruptedException{

		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(HomeMenu_Xpath, 10);
		boolean flag=true;
		if(HomeMenu_Xpath.isDisplayed()==true){
			HomeMenu_Xpath.getText();
			testLogger.info("Menu button: " +HomeMenu_Xpath);
			HomeMenu_Xpath.click();


		}
		return flag;	

	}



	public boolean HomeLanguage_Selection() throws InterruptedException { 
		boolean flag = true;
		{

			if (HomeLang_ID.isEnabled() == true)

				HomeLang_ID.click();
			HomeLang_Eng_Xpath.click();
			//driver.navigate().back();
			Thread.sleep(5000);
		}
		return flag;
	}


	public  boolean  HomeMessage_Selection() throws InterruptedException{

		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(HomeMessage_Xpath, 10);
		boolean flag=true;
		if(HomeMessage_Xpath.isDisplayed()==true){
			HomeMessage_Xpath.getText();
			HomeMessage_Xpath.click();
			testLogger.info("Message button: " +HomeMessage_Xpath);
			//HomePageLogo_Xpath.click();
			//driver.navigate().back();

		}
		return flag;	

	}


	public  boolean  HomeCalender_Selection() throws InterruptedException{

		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(HomeCalender_Xpath, 10);
		boolean flag=true;
		if(HomeCalender_Xpath.isDisplayed()==true){
			HomeCalender_Xpath.getText();
			testLogger.info("Calender button: " +HomeCalender_Xpath);
			HomeCalender_Xpath.click();
	

		}
		return flag;	

	}
	
	
	public  boolean  HomeSearch_Selection() throws InterruptedException{

		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(HomeSearch_Xpath, 10);
		boolean flag=true;
		if(HomeSearch_Xpath.isDisplayed()==true){
			testLogger.info("Calender button: " +HomeCalender_Xpath);
			HomeSearch_Xpath.click();
			HomeSearchinput_Xpath.sendKeys("Test");
			HomeSearchinput_Xpath.sendKeys(Keys.RETURN);

		}
		return flag;	

	}
}
