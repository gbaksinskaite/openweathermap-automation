package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* WAIT */

	public void waitForElement(WebElement element) {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(element));
		new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
	}
	
}