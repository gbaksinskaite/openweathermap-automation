package test.API;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.FileUtils;

public class TestApiResponseScheme extends AbstractApiTest {

	private String apiKey;

	@Parameters({ "filePath" })
	@BeforeClass
	public void preconditions(String filePath) {

		apiKey = FileUtils.readApiKeyFromFile(filePath);

	}

	@Parameters({ "cityId" })
	@Test(groups = { "API" }, priority = 0, enabled = true)
	public void testApiResponseScheme(String cityId) {

		given().queryParam("id", cityId).queryParam("appid", apiKey).when().get(Constants.BASE_URL).then()
				.statusCode(HttpStatus.SC_OK).body(matchesJsonSchemaInClasspath("./utilities/ApiResponseScheme.json"));

	}
}