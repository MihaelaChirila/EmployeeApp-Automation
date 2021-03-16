package actions;

import org.openqa.selenium.WebDriver;

public class Actions {
	public WebDriver driver;
	public LoginActions login;
	public NewUserActions newUser;
	public EmployeesActions employees;

	public Actions(WebDriver driver) {
		this.driver = driver;
		login = new LoginActions(driver);
		newUser = new NewUserActions(driver);
		employees = new EmployeesActions(driver);
	}

}
