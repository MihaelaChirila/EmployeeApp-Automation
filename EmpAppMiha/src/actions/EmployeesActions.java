package actions;

import org.openqa.selenium.WebDriver;

import pages.Page;

public class EmployeesActions extends Page {
public WebDriver driver;
	
	public EmployeesActions(WebDriver driver) {
		super(driver);
	}
	
	public void deleteEmployeeWithEmail(String email) throws InterruptedException {
		employees.deleteEmployee(email);
	}
}
