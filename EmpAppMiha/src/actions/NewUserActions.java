package actions;

import org.openqa.selenium.WebDriver;

import pages.Page;
import tstdata.NewUser;

public class NewUserActions extends Page {
	public WebDriver driver;

	public NewUserActions(WebDriver driver) {
		super(driver);
	}

	public void createNewUser(NewUser newUserData) {
		newUser.enterFirstName(newUserData.firstName);
		newUser.enterLastName(newUserData.lastName);
		newUser.enterEmail(newUserData.email);
		newUser.enterCompany(newUserData.company);
		newUser.enterPhoneNumber(newUserData.phoneNumber);
		newUser.selectDob();
		newUser.clickTermsCheckbox();
		newUser.clickSubmitButton();
	}

	public void createNewUserWithoutFirstName(NewUser newUserData) {
		newUser.enterFirstName("");
		newUser.enterLastName(newUserData.lastName);
		newUser.enterEmail(newUserData.email);
		newUser.enterCompany(newUserData.company);
		newUser.enterPhoneNumber(newUserData.phoneNumber);
		newUser.selectDob();
		newUser.clickTermsCheckbox();
		newUser.clickSubmitButton();
	}

	public boolean verifySubmitButtonIsEnabled() {
		return newUser.isSubmitButtonEnabled();
	}

	public boolean verifyDeletedAlertIsDisplayed() {
		return newUser.isDeletedUserAlertPresent();
	}

	public void clickOnBackButton() {
		newUser.clickOnBackButton();
	}

	public String getBackButton() {
		return newUser.getBackButton();
	}

	public boolean isFirstNameErrorPresent() {
		return newUser.isFirstNameErrorDisplayed();
	}

	public boolean isLastNameErrorPresent() {
		return newUser.isLastNameErrorDisplayed();
	}

	public void createNewUserWithoutLastName(NewUser newUserData) {
		newUser.enterFirstName(newUserData.firstName);
		newUser.enterLastName("");
		newUser.enterEmail(newUserData.email);
		newUser.enterCompany(newUserData.company);
		newUser.enterPhoneNumber(newUserData.phoneNumber);
		newUser.selectDob();
		newUser.clickTermsCheckbox();
		newUser.clickSubmitButton();
	}

	public void createNewUserWithoutFirstNameAndLastName(NewUser newUserData) {
		newUser.enterFirstName("");
		newUser.enterLastName("");
		newUser.enterEmail(newUserData.email);
		newUser.enterCompany(newUserData.company);
		newUser.enterPhoneNumber(newUserData.phoneNumber);
		newUser.selectDob();
		newUser.clickTermsCheckbox();
		newUser.clickSubmitButton();
	}

//	public void createNewUserWithoutEmail(NewUser newUserData) {
//		newUser.enterFirstName(newUserData.firstName);
//		newUser.enterLastName(newUserData.lastName);
//		newUser.enterCompany(newUserData.company);
//		newUser.enterPhoneNumber(newUserData.phoneNumber);
//		newUser.selectDob();
//		newUser.clickTermsCheckbox();
//		newUser.clickSubmitButton();
//	}
//	
//	public void createNewUserWithoutCompany(NewUser newUserData) {
//		newUser.enterFirstName(newUserData.firstName);
//		newUser.enterLastName(newUserData.lastName);
//		newUser.enterEmail(newUserData.email);
//		newUser.enterPhoneNumber(newUserData.phoneNumber);
//		newUser.selectDob();
//		newUser.clickTermsCheckbox();
//		newUser.clickSubmitButton();
//	}
//	
//	public void createNewUserWithoutPhoneNumber(NewUser newUserData) {
//		newUser.enterFirstName(newUserData.firstName);
//		newUser.enterLastName(newUserData.lastName);
//		newUser.enterEmail(newUserData.email);
//		newUser.enterCompany(newUserData.company);
//		newUser.selectDob();
//		newUser.clickTermsCheckbox();
//		newUser.clickSubmitButton();
//	}
//	
//	public void createNewUserWithoutDob(NewUser newUserData) {
//		newUser.enterFirstName(newUserData.firstName);
//		newUser.enterLastName(newUserData.lastName);
//		newUser.enterEmail(newUserData.email);
//		newUser.enterCompany(newUserData.company);
//		newUser.enterPhoneNumber(newUserData.phoneNumber);
//		newUser.clickTermsCheckbox();
//		newUser.clickSubmitButton();
//	}

	public void createNewUserWithoutCheckinTerms(NewUser newUserData) {
		newUser.enterFirstName(newUserData.firstName);
		newUser.enterLastName(newUserData.lastName);
		newUser.enterEmail(newUserData.email);
		newUser.enterCompany(newUserData.company);
		newUser.enterPhoneNumber(newUserData.phoneNumber);
		newUser.selectDob();
		newUser.clickSubmitButton();
	}

}
