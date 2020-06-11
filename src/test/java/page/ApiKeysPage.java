package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApiKeysPage extends AbstractPage {

	public ApiKeysPage(WebDriver driver) {
		super(driver);
	}

	/* BUTTONS */

	@FindBy(xpath = "//input[@value = 'Generate']")
	private WebElement buttonGenerate;

	/* INPUTS */

	@FindBy(id = "api_key_form_name")
	private WebElement inputApiKeyName;

	/* CLICK BUTTONS */

	public void clickButtonGenerate() {
		buttonGenerate.click();
	}

	/* ENTER INPUTS */

	public void enterInputApiKeyName(String apiKeyName) {
		inputApiKeyName.sendKeys(apiKeyName);
	}
	
	/* GET TEXT*/
	
	public String getApiKey(String apiKeyName) {
		return driver.findElement(By.xpath("//td[contains(text(),'" + apiKeyName + "')]/../td[1]/pre")).getText();
	}		
}
