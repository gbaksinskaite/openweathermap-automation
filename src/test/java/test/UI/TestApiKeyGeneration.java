package test.UI;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.ApiKeysPage;
import page.LoginPage;
import page.MainPage;
import page.UserHomePage;
import utilities.ApiNameGenerator;
import utilities.FileUtils;

public class TestApiKeyGeneration extends AbstractUITest {

	LoginPage loginPage;
	MainPage mainPage;
	UserHomePage userHomePage;
	ApiKeysPage apiKeysPage;	
	String apiKeyNameInitial = ApiNameGenerator.perfom();
	String apiKeyNameAdjusted = ApiNameGenerator.perfom();
	String apiKey;

	@BeforeClass
	public void preconditions() {
		
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		userHomePage = new UserHomePage(driver);
		apiKeysPage = new ApiKeysPage(driver);		

	}
	
	@Parameters({ "email", "password", "filePath"})
	@Test(groups = {"UI"}, priority = 0, enabled = true)
	public void testApiKeysGeneration(String email, String password, String filePath) throws IOException { 
		
		mainPage.clickLinkSignIn();
		loginPage.login(email, password);
				
		userHomePage.clickLinkApiKeys();
		
		apiKeysPage.generateApiKey(apiKeyNameInitial);
		
		assertTrue(apiKeysPage.isGeneratedApiKeyFieldDisplayed(apiKeyNameInitial), "API key wasn't created");
		assertFalse(apiKeysPage.getApiKey(apiKeyNameInitial).isEmpty(), "API key wasn't created");	
		
		apiKeysPage.changeApiKeyName(apiKeyNameInitial, apiKeyNameAdjusted);
		
		apiKey = apiKeysPage.getApiKey(apiKeyNameAdjusted);
		
		FileUtils.writeApiKeyToFile(filePath, apiKey);
		
		
		assertEquals(FileUtils.readApiKeyFromFile(filePath), apiKey, "Api Key wasn't written correctly");

	}

}
