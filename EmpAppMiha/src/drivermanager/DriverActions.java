package drivermanager;

import org.openqa.selenium.WebDriver;

public class DriverActions {
	public WebDriver driver;

	public DriverActions(WebDriver driver) {
		this.driver = driver;
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public void close() {
		driver.close();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
