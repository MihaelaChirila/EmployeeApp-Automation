package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeesPage {
	public WebDriver driver;

	public EmployeesPage(WebDriver driver) {
		this.driver = driver;
		this.users = driver.findElements(usersRows);
	}
	

	
	
	private By usersRows = By.xpath("//tbody/tr");
	private By emailsRow = By.xpath("//tr/td[3]");
	private By deleteButton = By.xpath("//span[text()=\" del\"]"); 
	private By aproveDeleteButton = By.xpath("//span[contains(text(),\"Yes\")]");
	
	List<WebElement> users = new ArrayList<>();
	
	//returneaza toate emailurile din lista
		List<WebElement> getEmails(){
			return driver.findElements(emailsRow);
		}
		
    //returneaza row-ul pentru userul cu numele specificat
	//daca sunt mai multe returneaza primul
	public WebElement getEmployeeLine(String email) {
		List<WebElement> emails = getEmails();
			for(WebElement emailRow : emails) {
//				System.out.println("+++++++++++"+emailRow.findElement(emailsRow).getAttribute("innerText"));
//				System.out.println("+++++++++++"+emailRow.getText());
				if(emailRow.getText().equals(email)) {
					return emailRow;
				}
			}
			return null;
		}		
		
	
	public void deleteEmployee(String email) throws InterruptedException {
		getEmployeeLine(email).findElement(deleteButton).click();
		driver.findElement(aproveDeleteButton).click();	
	}
	
	
	
}
