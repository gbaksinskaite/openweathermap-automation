package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public MainPage(WebDriver driver) {
		super(driver);
	}

	/* LINKS */

	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement linkSignIn;

	/* CLICK LINKS */

	public void clickLinkSignIn() {
		waitForElement(linkSignIn);
		linkSignIn.click();

	}

}
