package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.ApiKeysPage;
import page.LoginPage;
import page.MainPage;
import page.UserHomePage;

public class TestApiKeyGeneration extends AbstractTest {

	LoginPage loginPage;
	MainPage mainPage;
	UserHomePage userHomePage;
	ApiKeysPage apiKeysPage;

	@BeforeClass
	public void preconditions() {

		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		userHomePage = new UserHomePage(driver);
		apiKeysPage = new ApiKeysPage(driver);

	}

	@Test(groups = { "" }, priority = 0, enabled = true)
	public void testApiKeysGeneration() {

		mainPage.clickLinkSignIn();
		loginPage.enterInputEmail("gbaksinskaite@gmail.com");
		loginPage.enterInputPassword("ifJ8g@a9jYe8Qy7");
		loginPage.clickButtonSubmit();
		userHomePage.clickLinkApiKeys();
		apiKeysPage.enterInputApiKeyName("apiKey1");		
		apiKeysPage.clickButtonGenerate();
		assertFalse(apiKeysPage.getApiKey("apiKey1").isEmpty(), "API key wasn't created");
		
		//2efbdf2787060ed9253fe4589bc56816 API key
		
		//assertTrue(driver.findElement(By.xpath("//td[contains(text(),'" + p1 + "')]")).isDisplayed(),
	//"doc type was not created");
		

	}

}
