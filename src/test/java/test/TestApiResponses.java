package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestApiResponses extends AbstractApiTest {

	private String apiKey;
//private String apiKey = "60e77d77c29dd544157bf6e179245649";  //to abstract api test?

	@Parameters({ "filePath" })
	@BeforeClass
	public void preconditions(String filePath) {

		File file = new File(filePath);

		try (FileReader fileReader = new FileReader(file)) {
			char[] chars = new char[(int) file.length()];
			fileReader.read(chars);
			apiKey = new String(chars);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Parameters({ "cityNameInvalid" })
	@Test(groups = { "API" }, priority = 0, enabled = true)
	public void testApiResponseInvalidCityName(String cityName) {

		given().queryParam("q", cityName).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().statusCode(404)
				.body("message", equalTo("city not found"));

	}
	// TODO get apiKey from file!!!!
	@Parameters({ "cityName", "apiKey" })
	@Test(groups = { "API" }, priority = 1, enabled = true)
	public void testApiResponseInvalidKey(String cityName, String apiKey) {

		given().queryParam("q", cityName).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().statusCode(401).body("message",
						equalTo("Invalid API key. Please see http://openweathermap.org/faq#error401 for more info."));

	}

	@Parameters({ "cityIdInvalid" })
	@Test(groups = { "API" }, priority = 2, enabled = true)
	public void testApiResponseInvalidCityID(String cityIdInvalid) {

		given().queryParam("id", cityIdInvalid).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().statusCode(404)
				.body("message", equalTo("city not found"));

	}

	// TODO set parameters according to testName
	@Parameters({ "cityId", "cityName" })
	@Test(groups = { "API" }, priority = 3, enabled = true)
	public void testApiResponseVerifyCityID(String cityId, String cityName) {

		given().queryParam("id", cityId).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().statusCode(200)
				.body("name", equalTo(cityName));

	}

	@Parameters({ "zipCode", "cityName2", "longitude1", "latitude1" })
	@Test(groups = { "API" }, priority = 4, enabled = true)
	public void testApiResponseVerifyZipCode(String zipCode, String cityName1, String longitude, String latitude) {

		given().queryParam("zip", zipCode).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().statusCode(200)
				.body("name", equalTo(cityName1)).body("coord.lat", equalTo(Float.parseFloat(longitude)))
				.body("coord.lon", equalTo(Float.parseFloat(latitude)));

	}

	@Parameters({ "longitude2", "latitude2", "cityName3" })
	@Test(groups = { "API" }, priority = 5, enabled = true)
	public void testApiResponseVerifyCoordinates(String longitude, String latitude, String cityName) {

		given().queryParam("lon", longitude).queryParam("lat", latitude).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather").then().statusCode(200)
				.body("name", equalTo(cityName));

	}

	@Parameters({ "languageCode", "cityId", "cityNameTranslated" })
	@Test(groups = { "API" }, priority = 6, enabled = true)
	public void testApiResponseVerifyMultilingualSupport(String languageCode, String cityId,
			String cityNameTranslated) {

		given().queryParam("lang", languageCode).queryParam("id", cityId).queryParam("appid", apiKey).when()
				.get("http://api.openweathermap.org/data/2.5/weather?id=").then().statusCode(200)
				.body("name", equalTo(cityNameTranslated));

	}

}
