package com.suadeo.WEB.Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
import com.suadeo.WEB.PageObjects.SuadeoMenuPage;
import com.suadeo.WEB.PageObjects.SuadeoSignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

//import com.suadeo.WEB.Tests.BaseClass;

public class Test_FutureReference extends  BaseClass {

	//SignUpPage signUp;

/*	private static WebDriver driver=null;
	public static String browserName=null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	*/

	SuadeoSignInPage SignInObj; 
	
	SuadeoMenuPage menuObj;
	
	//private static Logger logger = LogManager.getLogger(Test_Menu2.class);



	@Test(priority=1)
	public void menu() throws IOException, InterruptedException
	{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("TestCase_VerifyMenu", "to validate menu page");
		//signIn = SuadeoSignInPage(driver);
		SignInObj = new SuadeoSignInPage(driver);
		SignInObj.signInLinkClick();

		SuadeoMenuPage menuObj = new SuadeoMenuPage(driver);

		Assert.assertTrue(menuObj.HomeMenu_Click(), "Suadeo Menu button is displayed");
		test.pass("Clicked menu button");
		//test.log(LogStatus.PASS, "This is a pass message");


		test.log(Status.INFO, "This step shows usage of log(status, details)");
		//test.info("This step shows usage of info(details)");
		//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		//test.addScreenCaptureFromPath("screenshot.png");
	}


}


