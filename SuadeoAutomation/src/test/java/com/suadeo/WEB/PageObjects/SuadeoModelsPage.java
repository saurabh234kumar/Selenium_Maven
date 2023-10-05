package com.suadeo.WEB.PageObjects;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.suadeo.WEB.Locators.SuadeoLocators;
import com.suadeo.browser.utils.WebUtils;
import com.suadeo.browser.utils.WebUtils;
import com.suadeo.WEB.PageObjects.SuadeoCatalog;

public class SuadeoModelsPage extends WebUtils {



	@FindBy(xpath = SuadeoLocators.ModelsXpath)
	private WebElement ModelsXpath;





	/*
	1. Constructor that will be automatically called as soon as the object of the class is created
	2. the constructor to initialize the actual driver.
	when we create a SuadeoCatalog object in the test class, we pass the driver(which is also initialized in the test class) 
	as an argument to the class. Now the same driver is passed as an argument to the constructor. The locally declared driver 
	in the SuadeoCatalog class is then initialized with the test class's actual driver
	*/
	
	public SuadeoModelsPage(WebDriver testdriver) {
		super(testdriver);
		//SearchContext driver = null;
		PageFactory.initElements(driver, this); 
		/*
		PageFactory initialization of Page objects
		PageFactory in Selenium, we use annotations @FindBy to find WebElement. 
		We use initElements method to initialize web elements
		 */
	}

	public boolean Models_Click() throws InterruptedException{
		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(ModelsXpath, 10);
		boolean flag=true;
		if(ModelsXpath.isDisplayed()==true){
			ModelsXpath.getText();
			testLogger.info("Menu button: " +ModelsXpath);
			//MMenuCataloguesXpath.click();
			ModelsXpath.click();
		}
		return flag;	

	}
}
