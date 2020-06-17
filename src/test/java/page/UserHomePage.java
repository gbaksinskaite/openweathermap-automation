package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePage extends AbstractPage {

	public UserHomePage(WebDriver driver) {
		super(driver);
	}

	/* LINKS */

	@FindBy(xpath = "//a[text()='API keys']")
	private WebElement linkApiKeys;

	/* CLICK LINKS */

	public void clickLinkApiKeys() {
		linkApiKeys.click();		
	}

}
