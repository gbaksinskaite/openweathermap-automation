package test.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractUITest {
	protected static WebDriver driver;

	@BeforeClass
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://openweathermap.org/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

}
