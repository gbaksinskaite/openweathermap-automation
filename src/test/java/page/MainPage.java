package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	/* LINKS */

	@FindBy(xpath = "//a[text()='Get Started']")
	private WebElement linkGetStarted;

	@FindBy(xpath = "//a[text()='API']")
	private WebElement linkAPI;

	@FindBy(xpath = "//a[text()='Pricing']")
	private WebElement linkPricing;

	@FindBy(xpath = "//a[text()='Maps']")
	private WebElement linkMaps;

	@FindBy(xpath = "//a[text()='Partners']")
	private WebElement linkPartners;

	@FindBy(xpath = "//a[text()='Blog']")
	private WebElement linkBlog;

	@FindBy(xpath = "//a[text()='Marketplace']")
	private WebElement linkMarketplace;

	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement linkSignIn;

	/* CLICK LINKS */

	public void clickLinkGetStarted() {
		linkGetStarted.click(); 
	}

	public void clickLinkAPI() {
		linkAPI.click();
	}

	public void clickLinkPricing() {
		linkPricing.click();
	}

	public void clickLinkMaps() {
		linkMaps.click();
	}

	public void clickLinkPartners() {
		linkPartners.click();
	}

	public void clickLinkBlog() {
		linkBlog.click();
	}

	public void clickLinkMarketplace() {
		linkMarketplace.click();
	}

	public void clickLinkSignIn() {
		linkSignIn.click();

	}

}
