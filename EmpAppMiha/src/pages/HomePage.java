package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By pageHeader = By.xpath("//div[@class=\"header__logo-name noSelect\"]/h1");
	private By loginFormTitle = By.xpath("//*[@class=\"mat-card-title\"]");
	private By registerButton = By.xpath("//span[contains(text(),\"Sign up\")]");
	private By loggedUserNameLabel = By.xpath("//*[@class=\"welcome\"]");
	private By newUserButton = By.xpath("//span[contains(text(),\"New user\")]");

	public String getLoginFormHeader() {
		return driver.findElement(loginFormTitle).getText();
	}

	public String getLoggedUsername() {
		return driver.findElement(loggedUserNameLabel).getText();
	}

	public String getPageHeader() {
		return driver.findElement(pageHeader).getText();
	}

	public String getRegisterButton() {
		return driver.findElement(registerButton).getText();
	}

	public WebElement getRegisterButtonElem() {
		return driver.findElement(registerButton);
	}

	public void openNewUserButton() {
		driver.findElement(newUserButton).click();
	}

}
