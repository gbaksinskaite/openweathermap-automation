## openweathermap-automation:

framework that executes UI and API tests and provides reporting after the test run.

### Tests

**UI test testApiResponseScheme**:

Opens https://home.openweathermap.org/, logs in the system, generates API key, renames it and saves in framework repository.

**API tests** uses previously generated API key for GET API calls, validates status code, message, response body values or response scheme. 

Negative flow API call tests that enters invalid parameters and validates status code and error messages:

* **testApiCallByCityNameInvalid**
* **testApiCallByKeyInvalid**
* **testApiCallByCityIdInvalid**

Positive flow API call tests that enters valid parameters, validates response status code and values of body fields:

* **testApiCallByCityID**
* **testApiCallByZipCode**
* **testApiCallByCoordinates**
* **testApiCallVerifyMultilingualSupport**

**testApiResponseScheme** validates if GET Api call response matches JSON scheme, which defines expected JSON response parameters, statuses (required or optional by default), value types, gives parameters description and value examples.

### Main tools

Framework is implemented using JAVA. Additional tools/libraries/plugins:

    • Maven
    • Selenium
    • TestNG
    • RestAssured
    • Awaitility
    • Hamcrest
    • Maven Surefire
   
### Test run setup

Tools required for test run:

    • Maven 3.6.x 
    • Google Chrome 83.x
    • Java 8
    
Clone git repository, use command:

```sh
git clone https://github.com/gbaksinskaite/openweathermap-automation.git
```

Run test suite by typing following command into command line from root project folder:

```sh
mvn test -DsuiteXmlFile=TestNGsuite.xml
```

Total test run can take up to 10 min, due to API key activation.
