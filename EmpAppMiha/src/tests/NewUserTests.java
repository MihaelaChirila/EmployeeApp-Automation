package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import messages.Settings;
import messages.Titles;
import utils.Logger;
import utils.Verify;

public class NewUserTests extends BaseTests {
	@Before
	@Override
	public void before() {
		super.before();
		Logger.steps.add("Login");
		action.login.login(userData);
		Logger.steps.add("Verify logged in user");
		assertEquals("Welcome: " + userData.username, page.home.getLoggedUsername());

		Logger.steps.add("Click 'New User' button");
		page.home.openNewUserButton();

	}

	// verify elements on page
	@Test
	public void verifyElemetsOnPage() throws InterruptedException {
		Logger.steps.add("Verify Page Header");
		assertEquals("Employee app", page.home.getPageHeader());

		Logger.steps.add("Verify 'back' Button");
		Verify.equals("< back", action.newUser.getBackButton());
		assertEquals("< back", action.newUser.getBackButton());
	}

	// create and delete new employee
	@Test
	public void createValidNewUserAndDelete() throws InterruptedException {
		String emailAdressNewEmployee = "popescuion@gmail.com";
		Logger.steps.add("Get number of users with email " + emailAdressNewEmployee);

		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + emailAdressNewEmployee + "')]"));
		int userWithSameEmail = list.size();

		Logger.steps.add("Add new employee");
		action.newUser.createNewUser(newUserData);

		int count = 10;
		int actualNrOfElements = list.size();
		while (actualNrOfElements != userWithSameEmail - 1 && count > 0) {
			Thread.sleep(500);
			list = driver.findElements(By.xpath("//*[contains(text(),'" + emailAdressNewEmployee + "')]"));
			actualNrOfElements = list.size();
			count--;
		}

		assertEquals("User not added", userWithSameEmail + 1, list.size());

		Logger.steps.add("Get number of users with email " + emailAdressNewEmployee + " after adding another one");
		list = driver.findElements(By.xpath("//*[contains(text(),'" + emailAdressNewEmployee + "')]"));
		userWithSameEmail = list.size();

		Logger.steps.add("Delete newly created user");
		action.employees.deleteEmployeeWithEmail(emailAdressNewEmployee);

		
		Logger.steps.add("Verify if confirmation message for deleted employee appears");
		assertTrue("Deleted user alert not displayed", action.newUser.verifyDeletedAlertIsDisplayed());

		List<WebElement> list2 = driver.findElements(By.xpath("//*[contains(text(),'" + emailAdressNewEmployee + "')]"));
		count = 10;
		actualNrOfElements = list2.size();
		while (actualNrOfElements != userWithSameEmail - 1 && count > 0) {
			Thread.sleep(500);
			list2 = driver.findElements(By.xpath("//*[contains(text(),'" + emailAdressNewEmployee + "')]"));
			actualNrOfElements = list2.size();
			count--;
		}

		Logger.steps.add("Verify if email adress still appears");
		assertEquals("User not deleted", userWithSameEmail == 0 ? 0 : userWithSameEmail - 1, list2.size());
	}

	// invalid new employee without first name
	@Test
	public void invalidNewUserWithoutFirstName() {

		Logger.steps.add("Add new employee without first name");
		action.newUser.createNewUserWithoutFirstName(newUserData);

		Logger.steps.add("Verify if Submit Button is Unabled");
		assertFalse("Submit button is enabled", action.newUser.verifySubmitButtonIsEnabled());

		Logger.steps.add("Verify if first name field error is present");
		assertTrue("First name error not displayed", action.newUser.isFirstNameErrorPresent());
	}

	// invalid new employee without last name
	@Test
	public void invalidNewUserWithoutLastName() {

		Logger.steps.add("Add new employee without last name");
		action.newUser.createNewUserWithoutLastName(newUserData);

		Logger.steps.add("Verify if Submit Button is Unabled");
		assertFalse("Submit button is enabled", action.newUser.verifySubmitButtonIsEnabled());

		Logger.steps.add("Verify if last name field error is present");
		assertTrue("Last name error not displayed", action.newUser.isLastNameErrorPresent());
	}

	// invalid new employee without first name and last name
	@Test
	public void invalidNewUserWithoutFirstNameAndLastName() {

		Logger.steps.add("Add new employee without first name");
		action.newUser.createNewUserWithoutFirstNameAndLastName(newUserData);

		Logger.steps.add("Verify if Submit Button is Unabled");
		assertFalse("Submit button is enabled", action.newUser.verifySubmitButtonIsEnabled());

		Logger.steps.add("Verify if first name field error is present");
		assertTrue("First name error not displayed", action.newUser.isFirstNameErrorPresent());

		Logger.steps.add("Verify if last name field error is present");
		assertTrue("Last name error not displayed", action.newUser.isLastNameErrorPresent());
	}

	// invalid new employee without accepting terms tickbox
	@Test
	public void invalidNewUserEmptyTermCheckbox() {

		Logger.steps.add("Add new employee without clicking terms checkbox");
		action.newUser.createNewUserWithoutCheckinTerms(newUserData);

		Logger.steps.add("Verify if Submit Button is Unabled");
		assertFalse("Submit button is enabled", action.newUser.verifySubmitButtonIsEnabled());
	}

}
