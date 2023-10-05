import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		//		WebDriverManager.chromedriver().browserVersion("104.0.5112.79").setup();//By using webdriverManager you dont need to download and set browser path
		//		WebDriver driver = new ChromeDriver();

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("ignoreProtectedModeSettings", true);
		WebDriverManager.iedriver().setup();

		WebDriver driver = new InternetExplorerDriver();

		//String projectPath=System.getProperty("user.dir");// To set project path
		//System.setProperty("webdriver.gecko.driver",projectPath+ "\\drivers\\geckodriver\\geckodriver.exe");//To set firefox geckoriver
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://magrabi.c2ojrqqoqj-magrabiop2-d1-public.model-t.cc.commerce.ondemand.com/dm-en/");
		//WebElement SigninSignup = driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[1]/a[1]"));
		//		WebElement SigninSignup = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-login']"));
		//		SigninSignup.click();

		List<WebElement> SigninSignup = driver.findElements(By.xpath("//a"));
		int count = SigninSignup.size();
		System.out.println("Count of SignSignup"+count);
		((WebElement) SigninSignup).click();
		System.out.println("Clicked");


		System.out.println("Clicked");
		driver.close();
		driver.quit();


	}

}
