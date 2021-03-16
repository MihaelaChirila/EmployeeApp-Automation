package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import messages.Settings;

public class NewUserPage {
	public WebDriver driver;

	public NewUserPage(WebDriver driver) {
		this.driver = driver;
	}

	private By firstNameInput = By.xpath("//input[@name=\"firstName\"]");
	private By lastNameInput = By.xpath("//input[@name=\"lastName\"]");
	private By emailInput = By.xpath("//input[@name=\"email\"]");
	private By companyInput = By.xpath("//input[@name=\"company\"]");
	private By phoneInput = By.xpath("//input[@name=\"phone\"]");

	private By dobCalendar = By.xpath("//*[@class=\"mat-datepicker-toggle-default-icon ng-star-inserted\"]");
	private By dobSelection = By.xpath("//button[@class=\"mat-calendar-period-button mat-button\"]/span");
	private By dobPrevious20YearsButton = By.xpath("//button[@class=\"mat-calendar-previous-button mat-icon-button\"]");
	private By dobDay = By.xpath("//div[contains(text(),\"17\")]");
	private By dobMonth = By.xpath("//div[contains(text(),\"MAY\")]");
	private By dobYear = By.xpath("//div[contains(text(),\"1993\")]");

	private By temsCheckbox = By.xpath("//div[@class=\"mat-checkbox-inner-container\"]");
	private By submitButton = By.xpath("//span[contains(text(),\"Submit\")]");
	private By submitButtonObject = By.xpath("//span[text()=\"Submit\"]/..");
	private By firstNameError = By.xpath("//input[@name=\"firstName\" and @aria-invalid=\"true\"]");
	private By lastNameError = By.xpath("//input[@name=\"lastName\" and @aria-invalid=\"true\"]");

	private By alertUserDeteled = By.xpath("//span[contains(text(),\"Delete done:\")]");

	private By backButton = By.xpath("/html/body/app-root/div/app-employee-form/button/span");

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}

	public void enterEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
	}

	public void enterCompany(String company) {
		driver.findElement(companyInput).sendKeys(company);
	}

	public void enterPhoneNumber(String phoneNumber) {
		driver.findElement(phoneInput).sendKeys(phoneNumber);
	}

	public void selectDob() {
		driver.findElement(dobCalendar).click();
		driver.findElement(dobSelection).click();
		driver.findElement(dobPrevious20YearsButton).click();
		driver.findElement(dobYear).click();
		driver.findElement(dobMonth).click();
		driver.findElement(dobDay).click();
	}

	public void clickTermsCheckbox() {
		driver.findElement(temsCheckbox).click();
		;
	}

	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}

	public Boolean isSubmitButtonEnabled() {
		if (driver.findElement(submitButtonObject).isEnabled()) {
			return true;
		}
		return false;
	}

	public boolean isDeletedUserAlertPresent() {
		WebDriverWait wait = new WebDriverWait(driver, Settings.WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(alertUserDeteled)));

		if (driver.findElement(alertUserDeteled).isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getBackButton() {
		return driver.findElement(backButton).getText();
	}

	public void clickOnBackButton() {
		driver.findElement(backButton).click();
	}

	public boolean isElementDisplayed(By by) {
		if (driver.findElement(by).isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean isFirstNameErrorDisplayed() {
		return isElementDisplayed(firstNameError);
	}

	public boolean isLastNameErrorDisplayed() {
		return isElementDisplayed(lastNameError);
	}
}
