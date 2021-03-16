package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By usernameInput = By.id("mat-input-0");
	private By passwordInput = By.id("mat-input-1");
	private By loginButton = By.xpath("//span[text()=\"Login\"]");
	private By errorField = By.xpath("//span[contains(text(), \" Problem signing in \")]");

	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public String getErrorField() {
		return driver.findElement(errorField).getText();
	}

	public By getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(By passwordInput) {
		this.passwordInput = passwordInput;
	}

}
