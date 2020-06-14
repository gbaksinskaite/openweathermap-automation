package test;

import static org.testng.Assert.assertFalse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ApiKeysPage;
import page.LoginPage;
import page.MainPage;
import page.UserHomePage;

public class TestApiResponseScheme extends AbstractApiTest {

	@BeforeClass
	public void preconditions() {

	}

	@Test(groups = { "API" }, priority = 0, enabled = true)
	public void testApiResponseScheme() {

//		
//		given().queryParam("zip", "14039").queryParam("appid", "60e77d77c29dd544157bf6e179245649").when()
//				.get("http://api.openweathermap.org/data/2.5/weather")
//				.then().body(matchesJsonSchemaInClasspath("./utilities/ApiResponseScheme.json"));  
		
		given().queryParam("id", "1851632").queryParam("appid", "6a58265243fc2231167d5e67e701f2e7").when()
		.get("http://api.openweathermap.org/data/2.5/weather")
		.then().body(matchesJsonSchemaInClasspath("./utilities/ApiResponseScheme.json"));  

	
		//missing -> visibility
 

}
}