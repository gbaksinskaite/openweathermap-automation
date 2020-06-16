package test.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.FileUtils;

public class TestApiResponses extends AbstractApiTest {

	private String apiKey;

	@Parameters({ "filePath" })
	@BeforeClass
	public void preconditions(String filePath) {

		apiKey = FileUtils.readApiKeyFromFile(filePath);
		waitForApiKeyActivation(apiKey);

	}

	@Parameters({ "cityNameInvalid" })
	@Test(groups = { "API" }, priority = 0, enabled = true)
	public void testApiResponseInvalidCityName(String cityName) {

		given().queryParam("q", cityName).queryParam("appid", apiKey).when().get(Constants.BASE_URL).then()
				.statusCode(404).body("message", equalTo("city not found"));

	}

	@Parameters({ "cityName", "apiKey" })
	@Test(groups = { "API" }, priority = 1, enabled = true)
	public void testApiResponseInvalidKey(String cityName, String apiKey) {

		given().queryParam("q", cityName).queryParam("appid", apiKey).when().get(Constants.BASE_URL).then()
				.statusCode(401).body("message", equalTo(Constants.Errors.INVALID_API_KEY));

	}

	@Parameters({ "cityIdInvalid" })
	@Test(groups = { "API" }, priority = 2, enabled = true)
	public void testApiResponseInvalidCityID(String cityIdInvalid) {

		given().queryParam("id", cityIdInvalid).queryParam("appid", apiKey).when().get(Constants.BASE_URL).then()
				.statusCode(404).body("message", equalTo(Constants.Errors.CITY_NOT_FOUND));

	}

	
	@Parameters({ "cityId", "cityName" })
	@Test(groups = { "API" }, priority = 3, enabled = true)
	public void testApiResponseVerifyCityID(String cityId, String cityName) {

		given().queryParam("id", cityId).queryParam("appid", apiKey).when().get(Constants.BASE_URL).then()
				.statusCode(200).body("name", equalTo(cityName));

	}

	@Parameters({ "zipCode", "cityName2", "longitude1", "latitude1" })
	@Test(groups = { "API" }, priority = 4, enabled = true)
	public void testApiResponseZipCode(String zipCode, String cityName1, String longitude, String latitude) {

		given().queryParam("zip", zipCode).queryParam("appid", apiKey).when().get(Constants.BASE_URL).then()
				.statusCode(200).body("name", equalTo(cityName1))
				.body("coord.lat", equalTo(Float.parseFloat(longitude)))
				.body("coord.lon", equalTo(Float.parseFloat(latitude)));

	}

	@Parameters({ "longitude2", "latitude2", "cityName3" })
	@Test(groups = { "API" }, priority = 5, enabled = true)
	public void testApiCallByCoordinates(String longitude, String latitude, String cityName) {

		given().queryParam("lon", longitude).queryParam("lat", latitude).queryParam("appid", apiKey).when()
				.get(Constants.BASE_URL).then().statusCode(200).body("name", equalTo(cityName));

	}

	@Parameters({ "languageCode", "cityId", "cityNameTranslated" })
	@Test(groups = { "API" }, priority = 6, enabled = true)
	public void testApiResponseVerifyMultilingualSupport(String languageCode, String cityId,
			String cityNameTranslated) {

		given().queryParam("lang", languageCode).queryParam("id", cityId).queryParam("appid", apiKey).when()
				.get(Constants.BASE_URL).then().statusCode(200).body("name", equalTo(cityNameTranslated));

	}

}
