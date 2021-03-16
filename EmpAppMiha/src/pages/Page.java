package pages;

import org.openqa.selenium.WebDriver;

import drivermanager.DriverActions;

public class Page {
	protected WebDriver driver;

	// pages
	public HomePage home;
	public LoginPage login;
	public NewUserPage newUser;
	public EmployeesPage employees;

	// current opened page
	public DriverActions action;

	public Page(WebDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
		login = new LoginPage(driver);
		newUser = new NewUserPage(driver);
		action = new DriverActions(driver);
		employees = new EmployeesPage(driver);
	}

}
