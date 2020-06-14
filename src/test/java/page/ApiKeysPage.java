package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiKeysPage extends AbstractPage {

	public ApiKeysPage(WebDriver driver) {
		super(driver); 
	}

	/* BUTTONS */

	@FindBy(xpath = "//input[@value = 'Generate']")
	private WebElement buttonGenerate;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement buttonSaveEditedKeyName;

	/* INPUTS */

	@FindBy(id = "api_key_form_name")
	private WebElement inputApiKeyName;
	
	@FindBy(id = "edit_key_form_name")
	private WebElement inputApiKeyNameNew;

	/* CLICK BUTTONS */

	public void clickButtonGenerate() {
		buttonGenerate.click();
	}
	
	public void clickButtonSaveEditedKeyName() {
		buttonSaveEditedKeyName.click();
	}
	
	public void clickButtonRenameApiKey(String apiKeyName) {
		new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'" + apiKeyName + "')]/../td[3]/a[1]/i[1]")));
		driver.findElement(By.xpath("//td[contains(text(),'" + apiKeyName + "')]/../td[3]/a[1]/i[1]")).click();
	}

	/* ENTER INPUTS */

	public void enterInputApiKeyName(String apiKeyName) {
		new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(inputApiKeyName));
		inputApiKeyName.sendKeys(apiKeyName);
	}
	
	public void enterInputApiKeyNameNew(String apiKeyNameNew) {
		//new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(inputApiKeyNameNew));
		inputApiKeyNameNew.sendKeys(apiKeyNameNew);
	}
	
	/* ENTER INPUTS */

	public void clearInputApiKeyInitial() {
		new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(inputApiKeyNameNew));
		inputApiKeyNameNew.clear();
	}
	
	
	/* GET TEXT*/
	
	public String getApiKey(String apiKeyName) {
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + apiKeyName + "')]")));
		return driver.findElement(By.xpath("//td[contains(text(),'" + apiKeyName + "')]/../td[1]/pre")).getText();
	}		
}
