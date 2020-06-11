package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	/* LINKS */

	@FindBy(xpath = "//a[contains(text(),'Create an Account.')]")
	private WebElement linkCreateAnAccount;

	@FindBy(xpath = "//a[contains(text(),'Click here to recover.')]")
	private WebElement linkRecoverPassword;

	/* CHECKBOXES */

	@FindBy(id = "user_remember_me")
	private WebElement checkBoxRememberMe;

	/* CLICK LINKS/BUTTONS */

	public void clickLinkCreateAnAccount() {
		linkCreateAnAccount.click();
	}

	public void clickLinkRecoverPassword() {
		linkRecoverPassword.click();
	}

	public void clickButtonSubmit() {
		buttonSubmit.click();
	}

	/* ENTER INPUTS */

	public void enterInputEmail(String email) {
		waitForElementVisibility(inputEmail);
		inputEmail.sendKeys(email);
	}

	public void enterInputPassword(String password) {
		inputPassword.sendKeys(password);
	}

	/* SELECT CHECKBOXES */

	public void selectCheckBoxRememberMe() {
		checkBoxRememberMe.click();
	}

	/* WAITS */

	public void waitForElementVisibility(WebElement element) {
		new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(element));
	}

}
