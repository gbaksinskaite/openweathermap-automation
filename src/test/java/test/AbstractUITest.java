package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AbstractUITest {
	protected static WebDriver driver;

	@BeforeClass   //change to BeforeSuite??? //methodName???
	public void beforeMetoh() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://openweathermap.org/");
		driver.manage().window().maximize();
	}

	@AfterClass   //change to AfterSuite
	public void afterMethod() {
		driver.quit(); 
	}
}
