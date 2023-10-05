package com.suadeo.browser.utils;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.log4j.Logger;

public abstract class WebUtils {

	protected WebDriver driver;
	protected static WebDriverWait ajaxWait;
	private long TIME_OUT;
	protected static Logger testLogger;
	private Wait<WebDriver> wait;

	public WebUtils(WebDriver driver) {
		this.driver = driver;
		ajaxWait = new WebDriverWait(driver, TIME_OUT);
		testLogger = LogManager.getLogger(Logger.class.getName());
	}

	/**
	 * This method will wait for Webelement to appear
	 * 
	 * @param element
	 * @param timeout
	 */
	// Wait for element present for WebElement
	public static void waitForWebElementPresent(WebElement element, int timeout) {
		ajaxWait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method is used to execute a Java script
	 * 
	 * @param we
	 */
	public void javaScriptExecute(WebElement we) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", we);
	}

	/**
	 * This method will wait for a web element present
	 */
	

	// Wait for element present for lists WebElement

	public static void waitForListOfWebElementsPresent(List<WebElement> elements, int timeout) {
		ajaxWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

//	public void fluentWait(WebDriver driver, long withTimeoutDuration) {
//
////		wait = new FluentWait<WebDriver>(driver).withTimeout(withTimeoutDuration, TimeUnit.SECONDS).pollingEvery(3,
////				TimeUnit.SECONDS);
//		Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
//                .ignoring(NoSuchElementException.class);
//
//	}

//	public boolean isAlertPresent(WebElement element, long withTimeoutDuration) {
//		fluentWait(driver, withTimeoutDuration);
//		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
//			testLogger.info("Alert not present");
//			return false;
//		} else
//			testLogger.info("Alert not present");
//		return true;
//	}
//
//	public void visibilityOf(WebElement element, long withTimeoutDuration) {
//		fluentWait(driver, withTimeoutDuration);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
//
//	public boolean textToBePresentInElementAttributeValue(WebElement element, String attributeValue) {
//		fluentWait(driver, 10);
//		return wait.until(ExpectedConditions.textToBePresentInElementValue(element, attributeValue));
//
//	}
//
//	public boolean titleContains(String title) {
//		fluentWait(driver, 10);
//		return wait.until(ExpectedConditions.titleContains(title));
//
//	}

//	public void waitForElementToBeClickable(WebElement element, long withTimeoutDuration) {
//		fluentWait(driver, withTimeoutDuration);
//
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//
//	}

	public boolean isElementDisplayed(WebElement element, long withTimeoutDuration) {
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}

	

	public void scrollDown(Object x, Object y) {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		Scroller.executeScript("scroll(x, y);");

	}

	public void dragAndDrop(WebElement element, int x, int y) {
		Actions price = new Actions(driver);
		price.dragAndDropBy(element, x, y).release().perform();

	}

	public void waitForPageToLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public static org.openqa.selenium.By byLocator(final String locator) {
		By result = null;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("Link=")) {
			result = By.linkText(locator.replace("Link=", ""));
		} else if (locator.startsWith("xpath=")) {
			result = By.xpath(locator);
		}

		else if (locator.startsWith("(//")) {
			result = By.xpath(locator);
		} else {
			result = By.id(locator);
		}
		return result;
	}

	// Assert element present
	public Boolean isElementPresent(final String locator) {
		Boolean result = false;
		try {
			driver.findElement(byLocator(locator));
			result = true;
		} catch (final Exception ex) {
		}
		return result;
	}

	public void scrollUp() {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		Scroller.executeScript("scroll(0, -250);");

	}
	
	public void scrolldown() {
		JavascriptExecutor Scroller = (JavascriptExecutor) driver;
		Scroller.executeScript("scroll(0, 250);");

	}

	// Wait
	public void waitForElementPresent(int Seconds) {
		int miliseconds;
		try {
			miliseconds = Seconds * 1000;
			Thread.sleep(miliseconds);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void elementMouseClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	
}
