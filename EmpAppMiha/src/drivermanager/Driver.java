package drivermanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static WebDriver driver;

	// create a new driver instance based on the provider broswer type
	public static WebDriver get(DriverType browser) {
		switch (browser) {
		// create a new chrome instance with specific settings
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		// create a new firefox instance with specific settings
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unknown broswer:" + browser.toString());
		}
		// generic driver serrings that will be applied on any of the above browsers
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// return the browser instance to be used in the test
		return driver;
	}
}
