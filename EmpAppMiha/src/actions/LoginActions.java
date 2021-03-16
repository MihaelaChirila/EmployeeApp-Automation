package actions;

import org.openqa.selenium.WebDriver;

import pages.Page;
import tstdata.User;

public class LoginActions extends Page {
	public WebDriver driver;

	public LoginActions(WebDriver driver) {
		super(driver);
	}

	public void login(User userData) {
		login.enterUsername(userData.username);
		login.enterPassword(userData.password);
		login.clickLogin();
	}

	public void loginWithoutEmail(User userData) {
		login.enterPassword(userData.password);
		login.clickLogin();
	}

	public void loginWithoutPassword(User userData) {
		login.enterUsername(userData.username);
		login.clickLogin();
	}

	public void loginWithoutEmailAndPassword() {
		login.clickLogin();
	}

	public void enterCredentials(User userData) {
		login.enterUsername(userData.username);
		login.enterPassword(userData.password);
	}
}
