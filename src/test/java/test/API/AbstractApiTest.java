package test.API;

import static io.restassured.RestAssured.given;
import static org.awaitility.Awaitility.await;

import java.util.concurrent.TimeUnit;

import utilities.Constants;

public class AbstractApiTest {

	// leave there or create utility class?
	protected static void waitForApiKeyActivation(String apiKey) {
		await().atMost(12, TimeUnit.MINUTES).with().pollInterval(1, TimeUnit.MINUTES)
				.until(() -> given().queryParam("q", "Vilnius").queryParam("appid", apiKey).when()
						.get(Constants.BASE_URL).getStatusCode() == 200);
	}

}
