package com.suadeo.WEB.Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.suadeo.WEB.Config.PropertiesFile;
import com.suadeo.WEB.PageObjects.SuadeoCatalog;
import com.suadeo.WEB.PageObjects.SuadeoMenuPage;
import com.suadeo.WEB.PageObjects.SuadeoSignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import library.ScreenShot;
import com.suadeo.WEB.PageObjects.SuadeoModelsPage;

public class Test_Models extends  BaseClass {



	SuadeoSignInPage SignInObj; 
	SuadeoMenuPage menu;
	SuadeoCatalog CatalogObj;
	SuadeoModelsPage obj;
	int i = 0;


	//private static Logger logger = LogManager.getLogger(Test_Catalogs.class);



	@Test(priority=1)
	public void TestCase_Verify_ModelsPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_Models button", "to validate menu page");

		SignInObj = new SuadeoSignInPage(driver);
		SignInObj.signInLinkClick(null, null);
		logger.pass("SignIn page displayed and user loggedIn successfully");
		menu = new SuadeoMenuPage(driver);
		menu.HomeMenu_Click();
		logger.pass("Menu page is displayed and user clicked on menu button succesfully");
		CatalogObj = new SuadeoCatalog(driver);

		try {
			Assert.assertTrue(CatalogObj.MenuCatalog_Click(), "Suadeo Menu catalog button is displayed");
			logger.pass("Test Pass:");
			logger.log(Status.PASS, "Test step PASS: Clicked catalog from menu button");
		}
		catch(Exception e)
		{
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Test Failed: SignIn button is not displayed"+e.getMessage());

		}
	}

	@Test(priority=2)
	public void TestCase_Verify_Newmodels() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify__Models button", "to validate model page");
		SuadeoCatalog obj = new SuadeoCatalog(driver);
		//objj.NewCatalog();

		try
		{
			Assert.assertTrue(	obj.NewModels(), "Suadeo Menu catalog button is displayed");
			//objj.NewCatalog();
			logger.pass("Test Pass:");
			logger.log(Status.PASS, "Test step PASS: Created new model ");
			logger.pass("Created new model ");

		}
		catch(Exception e)
		{

			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "New model button is not dispaled"+e.getMessage());
		}
	}

}


