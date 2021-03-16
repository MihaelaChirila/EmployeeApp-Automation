package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import messages.Errors;
import messages.RegexValidatorPatterns;
import tstdata.User;
import utils.Logger;
import utils.RegexValidator;
import utils.Verify;

public class LoginTests extends BaseTests {

	// verify elements on page
	@Test
	public void verifyElemetsOnPage() throws InterruptedException {
		Logger.steps.add("Verify Page Header");
		Verify.equals("Employee app", page.home.getPageHeader());
		assertEquals("Employee app", page.home.getPageHeader());

		Logger.steps.add("Verify Login Header");
		Verify.equals("Login", page.home.getLoginFormHeader());

		Logger.steps.add("Verify Register Button");
		Verify.equals("Sign up", page.home.getRegisterButton());
	}

	// login with all valid data
	@Test
	public void validLogin() throws InterruptedException {

		Logger.steps.add("Login");

		action.login.login(userData);
		Logger.steps.add("Verify logged in user");
		assertEquals("Welcome: " + userData.username, page.home.getLoggedUsername());
	}

	// login without providing email field
	@Test
	public void invalidLoginWithoutEmail() throws InterruptedException {

		Logger.steps.add("Login without email");

		action.login.loginWithoutEmail(userData);
		Logger.steps.add("Verify error message");

		Thread.sleep(1000);

		assertEquals(Errors.LOGIN_EMPTY_FIELD_ERROR, page.login.getErrorField());
	}

	// login without providing password field
	@Test
	public void invalidLoginWithoutPassword() throws InterruptedException {

		Logger.steps.add("Login without email");

		action.login.loginWithoutPassword(userData);
		Logger.steps.add("Verify error message");


		assertEquals(Errors.LOGIN_EMPTY_FIELD_ERROR, page.login.getErrorField());
	}

	// login without providing email and password field
	@Test
	public void invalidLoginWithoutEmailAndPassword() {

		Logger.steps.add("Login without email and password");

		action.login.loginWithoutEmailAndPassword();
		Logger.steps.add("Verify error message");

		assertEquals(Errors.LOGIN_EMPTY_FIELD_ERROR, page.login.getErrorField());
	}

	// login with invalid email
	@Test
	public void invalidEmailLogin() throws InterruptedException {

		Logger.steps.add("Login with invalid email");
		User invalidEmailUserData = new User("invalidemailuser");
		action.login.login(invalidEmailUserData);

		Logger.steps.add("Verify error message");
		Thread.sleep(4000);
		if (!RegexValidator.isValid(RegexValidatorPatterns.emailValidator, invalidEmailUserData.getUsername())) {
			throw new Error("Test Email Data Corupted");
		}
		assertEquals(Errors.LOGIN_INVALID_EMAIL_ERROR,
				RegexValidator.isValid(RegexValidatorPatterns.emailValidator, page.login.getErrorField()));
	}

	// login with invalid password
	@Test
	public void invalidPasswordLogin() throws InterruptedException {
		Logger.steps.add("Login with invalid password");
		User invalidPasswordUserData = new User("invalidpassworduser");
		action.login.login(invalidPasswordUserData);

		Logger.steps.add("Verify error message");

		//Thread.sleep(4000);
		if (!RegexValidator.isValid(RegexValidatorPatterns.passwordValidator, invalidPasswordUserData.getUsername())) {
			throw new Error("Test Password Data Corupted");
		}
		assertEquals(Errors.LOGIN_INVALID_PASSWORD_ERROR,
				RegexValidator.isValid(RegexValidatorPatterns.passwordValidator, page.login.getErrorField()));
	}

	// verify if password field is encrypted
	@Test
	public void loginEncryptedPasswordField() {
		Logger.steps.add("Fill Credentials");

		action.login.enterCredentials(userData);
		Logger.steps.add("Verify if password is encripted");

		WebElement passInput = driver.findElement(By.id("mat-input-1"));
		boolean isEncrypted = passInput.getAttribute("type").equals("password");

		if (!isEncrypted) {
			throw new Error("Password Field is not Encrypted");
		}
	}
}
