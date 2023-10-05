package com.suadeo.WEB.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
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
import com.relevantcodes.extentreports.LogStatus;
import com.suadeo.WEB.Config.PropertiesFile;
import com.suadeo.WEB.PageObjects.SuadeoSignInPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.ScreenShot;

public class Test_SignInPage extends  BaseClass {

	SuadeoSignInPage SignInObj;


	//private static Logger logger = LogManager.getLogger(Test_SignInPage.class);



	@Test(priority=1)
	//public void magrabiSignIn() throws IOException
	public void TestCase_Verify_SignInPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_SignIn Page", "to validate SignIn page");

		SignInObj = new SuadeoSignInPage(driver);

		try {

			Assert.assertTrue(SignInObj.signInLinkClick(),"SignIn is displayed :");
			logger.pass("Test Pass:");
			logger.log(Status.PASS,"Test Pass: SignIn page is displayed and Clicked");


		}
		catch(Exception e)
		{
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Test Failed: SignIn button is not displayed");
		}

	}


	@Test(priority=2)
	public void TestCase_Verify_SignOutPage() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		logger = extent.createTest("TestCase_Verify_Signout Page", "to validate Signout page");
		SignInObj = new SuadeoSignInPage(driver);

		try
		{



			Assert.assertTrue(SignInObj.logoutLinkClick(),"Signout is displayed :");
			logger.pass("Clicked SignOut button");
			logger.pass("SignOut page is displayed");
			logger.log(Status.INFO, "This step shows usage of log(status, details)");
			logger.info("This step shows usage of info(details)");
			logger.pass("Test Pass:");
			logger.log(Status.PASS,"Test Pass: Signout page is displayed and Clicked");

		}
		catch(Exception e)
		{
			logger.fail("Test Failed:");
			logger.log(Status.FAIL, "Test Failed: Signout button is not displayed");
		}

	} 

	// Taking Screen shot on test fail
	//	@AfterMethod
	//	public void screenshot(ITestResult result)
	//	{
	//		i = i+1;
	//		String name = "ScreenShot";
	//		String x = name+String.valueOf(i);
	//		if(ITestResult.SUCCESS == result.getStatus())
	//		{
	//			ScreenShot.captureScreenShot(driver, x);
	//		}
	//	}




}

