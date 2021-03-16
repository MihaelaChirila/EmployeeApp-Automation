package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Actions;
import drivermanager.Driver;
import drivermanager.DriverType;
import messages.Settings;
import messages.Titles;
import pages.Page;
import tstdata.NewUser;
import tstdata.User;
import utils.Logger;
import utils.Reports;

public class BaseTests extends Reports {
	protected WebDriver driver = Driver.get(DriverType.CHROME);
	protected User userData = new User("mainuser");
	protected NewUser newUserData = new NewUser("newuserdata");
	protected Page page = new Page(driver);
	protected Actions action = new Actions(driver);

	@Rule
	public Reports testreport = new Reports();

	@BeforeClass
	public static void setUp() {
		createReport(); // create report from Reports
	}

	@AfterClass
	public static void tearDown() {
		flushReports(); // from Reports class
	}

	@Before
	public void before() {
		Logger.steps = new ArrayList<String>();
		Logger.verification = new ArrayList<String>();

		page.action.navigate(Settings.URL);

		WebDriverWait wait = new WebDriverWait(driver, Settings.WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOf(page.home.getRegisterButtonElem()));

		assertEquals(Titles.HOMEPAGE, page.action.getTitle());
	}

	@After
	public void after() {
		page.action.close();
	}
}
