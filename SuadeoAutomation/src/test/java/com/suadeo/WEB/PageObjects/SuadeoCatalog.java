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

public class SuadeoCatalog extends WebUtils {



	@FindBy(xpath = SuadeoLocators.MMenuCataloguesXpath)
	private WebElement MMenuCataloguesXpath;

	@FindBy(xpath = SuadeoLocators.CataloguesXpath)
	private WebElement CataloguesXpath;



	@FindBy(xpath = SuadeoLocators.CataloguesNewButtonXpath)
	private WebElement CataloguesNewButtonXpath;

	@FindBy(xpath = SuadeoLocators.CataloguesNameXpath)
	private WebElement CataloguesNameXpath;

	@FindBy(xpath = SuadeoLocators.CataloguesMessageXpath)
	private WebElement CataloguesMessageXpath;
	
	@FindBy(xpath = SuadeoLocators.ModelsNameXpath)
	private WebElement ModelsNameXpath;
	
	
	
	@FindBy(xpath = SuadeoLocators.ModelsMessageXpath)
	private WebElement ModelsMessageXpath;

	@FindBy(xpath = SuadeoLocators.CataloguesSaveXpath)
	private WebElement CataloguesSaveXpath;
	
	
	@FindBy(xpath = SuadeoLocators.ModelsSaveXpath)
	private WebElement ModelsSaveXpath;
	

	@FindBy(xpath = SuadeoLocators.ModelsXpath)
	private WebElement ModelsXpath;
	
	



	/*
	1. Constructor that will be automatically called as soon as the object of the class is created
	2. the constructor to initialize the actual driver.
	when we create a SuadeoCatalog object in the test class, we pass the driver(which is also initialized in the test class) 
	as an argument to the class. Now the same driver is passed as an argument to the constructor. The locally declared driver 
	in the SuadeoCatalog class is then initialized with the test class's actual driver
	*/
	
	public SuadeoCatalog(WebDriver testdriver) {
		super(testdriver);
		//SearchContext driver = null;
		PageFactory.initElements(driver, this); 
		/*
		PageFactory initialization of Page objects
		PageFactory in Selenium, we use annotations @FindBy to find WebElement. 
		We use initElements method to initialize web elements
		 */
	}

	public boolean MenuCatalog_Click() throws InterruptedException{
		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(MMenuCataloguesXpath, 10);
		boolean flag=true;
		if(MMenuCataloguesXpath.isDisplayed()==true){
			MMenuCataloguesXpath.getText();
			testLogger.info("Menu button: " +MMenuCataloguesXpath);
			MMenuCataloguesXpath.click();
			//CataloguesXpath.click();
		}
		return flag;	

	}
	

	public boolean NewCatalog() throws InterruptedException{

		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(CataloguesXpath, 10);
		String arr[]=UUID.randomUUID().toString().split("-");
		//String inputValue = "TestCatalog";

		System.out.print(arr[0]);//046b6c7f
		boolean flag=true;
		if(CataloguesXpath.isDisplayed()==true){
			Reporter.log("=====Browser Session End=====", true);
			CataloguesXpath.click();
			System.out.println("New Button");
			CataloguesNewButtonXpath.click();
			CataloguesNameXpath.sendKeys("TestCatalog"+arr[0]);
			CataloguesMessageXpath.click();
			CataloguesMessageXpath.sendKeys("TestCatalog"+arr[0]);
			CataloguesSaveXpath.click();


		}
		return flag;	
	}
	
	public boolean NewModels() throws InterruptedException{

		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(ModelsXpath, 10);
		String arr[]=UUID.randomUUID().toString().split("-");
		//String inputValue = "TestCatalog";

		System.out.print(arr[0]);//046b6c7f
		boolean flag=true;
		if(ModelsXpath.isDisplayed()==true){
			Reporter.log("=====Browser Session End=====", true);
			testLogger.info("Menu button: " +ModelsXpath);
			ModelsXpath.click();
			System.out.println("New Button");
			CataloguesNewButtonXpath.click();
			ModelsNameXpath.sendKeys("TestCatalog"+arr[0]);
			ModelsMessageXpath.click();
			ModelsMessageXpath.sendKeys("TestCatalog"+arr[0]);
			ModelsSaveXpath.click();


		}
		return flag;	
	}
	



}
