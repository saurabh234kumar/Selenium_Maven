package com.suadeo.WEB.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.suadeo.WEB.Locators.SuadeoLocators;
import com.suadeo.browser.utils.WebUtils;

public class SuadeoSignInPage extends WebUtils{




	@FindBy(xpath = SuadeoLocators.LoginAuthentication_Xpath)
	private WebElement LoginAuthentication_Xpath;

	@FindBy(id = SuadeoLocators.	LoginAuthenticationDropDownButton_ID)
	private WebElement 	LoginAuthenticationDropDownButton_ID;

	@FindBy(xpath=SuadeoLocators.LoginUsername_Xpath)
	private WebElement LoginUsername_Xpath;

	@FindBy(id=SuadeoLocators.LoginPassword_ID)
	private WebElement LoginPassword_ID;

	@FindBy(id=SuadeoLocators.LoginButton_ID)
	private WebElement LoginButton_ID;

	@FindBy(xpath = SuadeoLocators.HomePageLogo_Xpath)
	private WebElement HomePageLogo_Xpath;

	@FindBy(xpath = SuadeoLocators.HomeMenu_Xpath)
	private WebElement HomeMenu_Xpath;

	@FindBy(xpath = SuadeoLocators.LogoutButton_Xpath)
	private WebElement LogoutButton_Xpath;

	@FindBy(id = SuadeoLocators.DisconnectButton_ID)
	private WebElement DisconnectButton_ID;




	//	public MagrabiSignInPage(WebDriver driver)
	//	{
	//		this.driver =driver;
	//		PageFactory.initElements(driver, this);
	//	}

	public SuadeoSignInPage(WebDriver testdriver) {
		super(testdriver);
		//SearchContext driver = null;
		PageFactory.initElements(driver, this);

	}

	public boolean logoutLinkClick() throws InterruptedException{
		// explicit wait - to wait for the compose button to be click-able
		waitForWebElementPresent(LogoutButton_Xpath, 10);
		boolean flag=true;
		//Thread.sleep(2000);
		if(LogoutButton_Xpath.isDisplayed()==true){
			//test.log(Status.PASS, "Home page opened");

			//test.log(LogStatus.PASS, "SignIn Button is displayed");
			testLogger.info("SignIn button: " +LogoutButton_Xpath);
			testLogger.info("SignIn Button is displayed ");
			LogoutButton_Xpath.click();
			//Thread.sleep(5000);
			DisconnectButton_ID.click();
			System.out.println("Suadeo site logout");


		}
		return flag;	

	}

	public boolean signInLinkClick() throws InterruptedException{

		boolean flag=true;
		if(LoginAuthentication_Xpath.isDisplayed()==true){
			LoginAuthentication_Xpath.getText();
			testLogger.info("SignIn button: " +LoginAuthentication_Xpath);

			//test.pass("Clicked SignIn button");
			testLogger.info("SignIn Button is displayed ");
			//driver.findElement((By) signInXpath).click();
			LoginAuthentication_Xpath.click();
			LoginAuthenticationDropDownButton_ID.click();
			LoginUsername_Xpath.sendKeys("qatester");
			LoginPassword_ID.sendKeys("&m.XkHUa.4qm7Df");
			LoginButton_ID.click();



		}
		return flag;	

	}


		
//		public boolean signOutClick() {
//			boolean flag=true;
//			// explicit wait - to wait for the compose button to be click-able
//	//		WebDriverWait wait = new WebDriverWait(driver,30);
//	//		wait.until(ExpectedConditions.visibilityOfElementLocated((By) signOutXpath));
//			try{
//	 		   if(signOutXpath.isDisplayed()==true){
//					testLogger.info("The completeCollection ViewAll section at Product Display Page is"+signOutXpath.getText());
//					signOutXpath.click();
//				}
//				else{
//					testLogger.error("The completeCollection ViewAll section is not available at Product Display Page");
//				}
//				
//			}catch( org.openqa.selenium.ElementNotVisibleException ex){
//				testLogger.error("The completeCollection ViewAllsection Object ID might have changed"+ex.getMessage());
//				flag=false;
//			}
//				catch(org.openqa.selenium.NoSuchElementException ex){
//					testLogger.error("The completeCollection ViewAllsection Object ID might have changed"+ex.getMessage());
//					flag=false;
//				}
//			
//			return flag;
//		}





}
