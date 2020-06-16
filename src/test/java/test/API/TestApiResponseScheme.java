package test.API;

import static org.testng.Assert.assertFalse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.ApiKeysPage;
import page.LoginPage;
import page.MainPage;
import page.UserHomePage;
import utilities.Constants;
import utilities.FileUtils;

public class TestApiResponseScheme extends AbstractApiTest {
	
	private String apiKey;

	@Parameters({ "filePath" })
	@BeforeClass
	public void preconditions(String filePath) {
		
		apiKey = FileUtils.readApiKeyFromFile(filePath);	   
		
	}

	@Parameters({ "cityId", "JSONschemePath" })
	@Test(groups = { "API" }, priority = 0, enabled = true)
	public void testApiResponseScheme(String cityId, String JSONschemePath) {

//		
//		given().queryParam("zip", "14039").queryParam("appid", "60e77d77c29dd544157bf6e179245649").when()
//				.get("http://api.openweathermap.org/data/2.5/weather")
//				.then().body(matchesJsonSchemaInClasspath("./utilities/ApiResponseScheme.json"));  
		
//		apiGetRequest("id", cityId, apiKey).then().statusCode(200)
//		.body(matchesJsonSchemaInClasspath("./utilities/ApiResponseScheme.json"));
		
		
		given().queryParam("id", cityId).queryParam("appid", apiKey).when()
		.get(Constants.BASE_URL)
		.then().statusCode(200).body(matchesJsonSchemaInClasspath(JSONschemePath));  

		
//		given().queryParam("id", cityId).queryParam("appid", apiKey).when()
//		.get(Constants.BASE_URL)
//		.then().statusCode(200).body(matchesJsonSchemaInClasspath("./utilities/ApiResponseScheme.json"));  
	
		
 

}
}