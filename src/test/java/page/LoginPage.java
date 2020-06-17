package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/* BUTTONS */

	@FindBy(xpath = "//input[@value = 'Submit']")
	private WebElement buttonSubmit;

	/* INPUTS */

	@FindBy(id = "user_email")
	private WebElement inputEmail;

	@FindBy(id = "user_password")
	private WebElement inputPassword;

	/* CLICK BUTTONS */

	public void clickButtonSubmit() {
		buttonSubmit.click();
	}

	/* ENTER INPUTS */

	public void enterInputEmail(String email) {
		waitForElement(inputEmail);
		inputEmail.sendKeys(email);
	}

	public void enterInputPassword(String password) {
		inputPassword.sendKeys(password);
	}

	/* ENTER INPUTS */

	public void login(String email, String password) {
		enterInputEmail(email);
		enterInputPassword(password);
		clickButtonSubmit();
	}
}
