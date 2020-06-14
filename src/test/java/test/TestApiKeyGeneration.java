package test;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.ApiKeysPage;
import page.LoginPage;
import page.MainPage;
import page.UserHomePage;

public class TestApiKeyGeneration extends AbstractUITest {

	LoginPage loginPage;
	MainPage mainPage;
	UserHomePage userHomePage;
	ApiKeysPage apiKeysPage;
	File f;
	FileWriter fileWriter; //is it necessary???>

	@BeforeClass
	public void preconditions() {

		
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		userHomePage = new UserHomePage(driver);
		apiKeysPage = new ApiKeysPage(driver);		

	}
	//@Parameters({ "email", "password", "apiKeyNameInitial", "apiKeyNameAdjusted", "filePath" })
	@Parameters({ "email", "password", "filePath"})
	@Test(groups = {"UI"}, priority = 0, enabled = true)
	public void testApiKeysGeneration(String email, String password, String filePath) throws IOException { ///handle exception!!

		mainPage.clickLinkSignIn();
		
		loginPage.enterInputEmail(email);
		loginPage.enterInputPassword(password);
		loginPage.clickButtonSubmit();
		
		userHomePage.clickLinkApiKeys();
		
		apiKeysPage.enterInputApiKeyName("1apiKey12");		
		apiKeysPage.clickButtonGenerate();
		
		//String apiKey = apiKeysPage.getApiKey("apiKey4"); //WAIT!!
		assertFalse(apiKeysPage.getApiKey("1apiKey12").isEmpty(), "API key wasn't created");	
		
		apiKeysPage.clickButtonRenameApiKey("1apiKey12");
		apiKeysPage.clearInputApiKeyInitial();
		apiKeysPage.enterInputApiKeyNameNew("1apiKey13");
		apiKeysPage.clickButtonSaveEditedKeyName();
		//?????
		String apiKey = apiKeysPage.getApiKey("1apiKey13");
		
		f = new File(filePath);
		if(!f.exists()) {
			f.createNewFile(); 
		}
		
		fileWriter = new FileWriter(f);
		fileWriter.write(apiKey);
		fileWriter.close();
		
		//<parameter name="filePath" value="src/test/java/utilities/apiKey.txt"/>
		
		//2efbdf2787060ed9253fe4589bc56816 API key
				
		

	}

}
