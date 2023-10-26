package com.suadeo.WEB.Tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.suadeo.WEB.Config.PropertiesFile;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver=null;
	public static String browserName=null;
	public static String url=null;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;


	//The @BeforeSuite annotated method will run only once before the execution of all the test methods in the suite.
	@BeforeSuite 
	public void setUpTest()
	{
//		Date d = new Date();
//		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
		htmlReporter = new ExtentHtmlReporter("SuadeoTestReport.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		PropertiesFile.getProperties();
		deleteScreenshots();

	}
	//This will be executed before first @Test method execution. It will be executed one only time throughout the test case.
	@BeforeClass
	public void beforeTest() throws InterruptedException
	{
		PropertiesFile.getProperties();

		if(browserName.equalsIgnoreCase("chrome")) //Chrome driver instantiates using an object of WebDriver class.
		
		{
			ChromeOptions chromeOptions = new ChromeOptions();
		if (System.getProperty("os.name").toLowerCase().contains("linux")) {
			chromeOptions.addArguments("--headless");
		}
		
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(4000);
			
		}

		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
		Reporter.log("=====Application Started=====", true);
		//		logger.info("This is information message");
		//		logger.error("This is error message");
		//		logger.warn("This is warning message");
		//	logger.fatal("This is fatal message");
		System.out.println("Test started to launch Suadeo site");
	}



	// This will be executed after every @test annotated method.
 
//	public void tearDownn(ITestResult result)
//	{
//
//		// Here will compare if test is failing then only it will enter into if condition
//		if(ITestResult.SUCCESS==result.getStatus())
//		{
//			try 
//			{
//				// Create refernce of TakesScreenshot
//				TakesScreenshot ts=(TakesScreenshot)driver;
//
//				// Call method to capture screenshot
//				File source=ts.getScreenshotAs(OutputType.FILE);
//				//logger.log(LogStatus.FAIL, result.getThrowable());
//
//				// Copy method  specific location here it will save all screenshot in our project home directory and
//				// result.getName() will return name of test case so that screenshot name will be same
//
//				FileHandler.copy(source, new File("C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//"+result.getName()+".png"));
//				System.out.println("Screenshot taken");
//				logger.info("Details of " + "Test screenshot",
//						MediaEntityBuilder.createScreenCaptureFromPath("C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//"+result.getName()+".png").build());
//
//			} 
//			catch (Exception e)
//			{
//				System.out.println("Exception while taking screenshot "+e.getMessage());
//			}
//		}
//	}
	
	public static String timestamp() {
        return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
    }
	
	// This will be executed after every @test annotated method.
	@AfterMethod
	public void tearDownn(ITestResult result) throws IOException
	{
//	      Date d = new Date();
//	        String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		
		// Create refernce of TakesScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;

		// Call method to capture screenshot
		File source=ts.getScreenshotAs(OutputType.FILE);
		//logger.log(LogStatus.FAIL, result.getThrowable());

		// Copy method  specific location here it will save all screenshot in our project home directory and
		// result.getName() will return name of test case so that screenshot name will be same

		FileHandler.copy(source, new File("C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//"+result.getName()+timestamp()+".png"));
		System.out.println("Screenshot taken");

		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{

				logger.info("Details of " + "failed Test screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath("C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//"+result.getName()+timestamp()+".png").build());
		}
		else if(result.getStatus()==ITestResult.SKIP){
			logger.log(Status.SKIP, "Test Case SKIPPED IS:  " + result.getName());
//			logger.info("Details of " + "failed Test screenshot",
//					MediaEntityBuilder.createScreenCaptureFromPath("C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//"+result.getName()+".png").build());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
        	//logger.log(Status.PASS, "Test Case PASSED IS:  " + result.getName());
        	logger.info("Details of " + "passed Test screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath("C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//"+result.getName()+timestamp()+".png").build());

        }
	}
	
	// to delete all previous screenshots before running new tests
	public static void deleteScreenshots() {
        // Set the directory path where your screenshots are stored
        String screenshotsDir = "C://local_repository//SuadeoTesting//Automation//SuadeoAutomation//screenshot//";
        
        // Create a File object representing the directory
        File directory = new File(screenshotsDir);
        
        // Get all the files in the directory
        File[] files = directory.listFiles();
        
        if (files != null) {
            // Iterate over the files and delete them
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                    System.out.println("Deleted file: " + file.getName());
                }
            }
        }
    }

//This will be executed after the execution of all tests in the suite is complete.
	@AfterSuite
	public void tearDown()
	{

		extent.flush();
		driver.close();
		driver.quit();
//		try {
//			driver.close();
//		driver.quit();
//		}
//		catch(Exception e)
//		{
//			driver.quit();
//			System.out.println("Browser closed already"+e.getMessage());
//		}
		PropertiesFile.setProperties();
		Reporter.log("=====Browser Session End=====", true);


	}

}


