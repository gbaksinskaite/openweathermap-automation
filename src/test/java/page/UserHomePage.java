package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHomePage extends AbstractPage {

	public UserHomePage(WebDriver driver) {
		super(driver);
	}

	/* LINKS */

	@FindBy(xpath = "//a[text()='Get Started']")
	private WebElement linkNewProducts;

	@FindBy(xpath = "//a[text()='Services']")
	private WebElement linkServices;

	@FindBy(xpath = "//a[text()='API keys']")
	private WebElement linkApiKeys;

	@FindBy(xpath = "//a[text()='Billing plans']")
	private WebElement linkBillingPlans;

	@FindBy(xpath = "//a[text()='Payments']")
	private WebElement linkPayments;

	@FindBy(xpath = "//a[text()='Block logs']")
	private WebElement linkBlockLogs;

	@FindBy(xpath = "//a[text()='My profile']")
	private WebElement linkMyOrders;

	@FindBy(xpath = "//a[text()='My profile']")
	private WebElement linkMyProfile;
	
	
	/* LABELS */ 

	/* CLICK LINKS */

	public void clickLinkNewProducts() {
		linkNewProducts.click();
	}

	public void clickLinkServices() {
		linkServices.click();
	}

	public void clickLinkApiKeys() {
		linkApiKeys.click();
	}

	public void clickLinkBillingPlans() {
		linkBillingPlans.click();
	}

	public void clickLinkPayments() {
		linkPayments.click();
	}

	public void clickLinkBlockLogs() {
		linkBlockLogs.click();
	}

	public void clickLinkMyOrders() {
		linkMyOrders.click();
	}

	public void clickLinkSignIn() {
		linkMyProfile.click();
	}

}
