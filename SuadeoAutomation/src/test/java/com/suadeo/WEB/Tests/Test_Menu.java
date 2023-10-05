package com.suadeo.WEB.Tests;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.LogStatus;
import com.suadeo.WEB.Config.PropertiesFile;
import com.suadeo.WEB.PageObjects.SuadeoMenuPage;
import com.suadeo.WEB.PageObjects.SuadeoSignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import library.ScreenShot;


public class Test_Menu extends  BaseClass {

	//public static ExtentTest logger;

	//SuadeoSignInPage signIn;
	SuadeoSignInPage SignInObj; 

	SuadeoMenuPage menuObj;
	// int i = 0;
	//
	//	//private static Logger logger = LogManager.getLogger(Test_Menu.class);



	@Test(priority=1)
	public void TestCase_Verify_MenuPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_Menu", "to validate menu page");
		SignInObj = new SuadeoSignInPage(driver);
		SignInObj.signInLinkClick();
		menuObj = new SuadeoMenuPage(driver);

		try {
			Assert.assertTrue(menuObj.HomeMenu_Click(), "Suadeo Menu button is displayed");

			logger.pass("Test Pass");
			logger.log(Status.PASS,"Menu is displayed and clicked");
		}
		catch(Exception e)
		{
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Menu is not displayed");
		}

		//		//test.log(LogStatus.PASS, "This is a pass message");
		//		logger.log(Status.INFO, "This step shows usage of log(status, details)");
		//		//test.info("This step shows usage of info(details)");

	}


	@Test(priority=2)
	public void TestCase_Verify_LangauagebuttonPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_LangauageChange", "to validate Langauge change to english");
		//test = extent.startTest("VerifyTitle");
		menuObj = new SuadeoMenuPage(driver);
		try {
			Assert.assertTrue(menuObj.HomeLanguage_Selection(), "Suadeo Language selection button is displayed");
			logger.pass("Test Pass:");
			logger.log(Status.PASS," Switch menu button is displayed and clicked");
		}
		catch(Exception e){
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Switch language menu button is not displayed");
		}

	}



	@Test(priority=3)
	public void TestCase_Verify_MessagebuttonPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_Messagebutton", "to validate Message button is clickable or not");
		menuObj = new SuadeoMenuPage(driver);

		try {
			Assert.assertTrue(menuObj.HomeMessage_Selection(), "Suadeo Message selection button is displayed");
			logger.pass("Test Pass:");
			logger.log(Status.PASS, "Switch language menu button is not displayed");
		}
		catch (Exception e) {
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Message menu button is not displayed");
		}

	}


	@Test(priority=4)
	public void TestCase_Verify_CalenderrbuttonPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("TestCase_Verify_Calenderrbutton", "to validate Calenderr button is clickable or not");
		menuObj = new SuadeoMenuPage(driver);


		try {
			Assert.assertTrue(menuObj.HomeCalender_Selection(), "Suadeo calender selection button is displayed");
			test.pass("Test Pass: ");
			logger.log(Status.PASS, "Calender menu button is displayed and clicke");
		}

		catch(Exception e)
		{
			test.fail("Test Failed:");
			logger.log(Status.FAIL, "Calender menu button is displayed and clicke");
		}

	}


	@Test(priority=5)
	public void TestCase_Verify_SearchbuttonPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_Searchbutton", "to validate search button is clickable or not");
		menuObj = new SuadeoMenuPage(driver);


		try {
			Assert.assertTrue(menuObj.HomeSearch_Selection(), "Suadeo search selection button is displayed");
			logger.pass("Test Pass: ");
			logger.log(Status.PASS, "Search menu button is displayed and SLP page displayed");
		}
		catch(Exception e)
		{
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Search button is not displayed");
		}

	}


//	@Test(priority=6)
//	public void menuu(ITestResult result) throws IOException, InterruptedException
//	{
//		ExtentTest logger = extent.createTest("TestCase_Verify_failed", "to validate menu page");
//
//		try {
//			Assert.assertEquals(driver.getTitle(), "abcd");
//			//test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//
//		}
//		catch(Exception e){
//			logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("abcd.png").build());
//			logger.addScreenCaptureFromPath("abcdabcd.png");
//			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//
//		}
//	}


	// Taking Screen shot on test fail

	//		@AfterMethod
	//	    public void screenshot(ITestResult result)
	//	    {
	//	               i = i+1;
	//	               String name = "ScreenShott";
	//              // String x = name+String.valueOf(i);
	//
	//
	//	              if(ITestResult.FAILURE == result.getStatus())
	//	            	  
	//	           
	//	                {
	//	                               ScreenShot.captureScreenShot(driver, x);
	//	                 }
	//	}



}


