package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AbstractTest {
	protected static WebDriver driver;

	@BeforeClass   //change to BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://openweathermap.org/");
		driver.manage().window().maximize();
	}

	@AfterClass   //change to AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
