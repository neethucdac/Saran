package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteUserTestCase7 {
	WebDriver driver;
	public DeleteUserTestCase7(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class=\"fa fa-institution\"])[1]")WebElement admin;
	@FindBy(xpath = "(//span[@class=\"fa fa-user\"])[2]")WebElement usermenu;
	public void clickAdmin()
	{
		admin.click();
		usermenu.click();
		//role.click();
	}

	
	
	public void enterUserName(String username) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // Locate and enter the username in the search box
	    WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//input[@placeholder='UserName/UserDescription/Email']")));
	    usernameField.sendKeys(username);

	    // Click the search button
	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//button[text()='Search']")));
	    searchButton.click();

	    // Wait for table to refresh
	    //Thread.sleep(2000);  // Alternative: Use explicit wait for table update

	    // Identify the row containing the correct username
	    WebElement userRow = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//table[contains(@id,'usersTable')]/tbody/tr[td/a[contains(text(),'" + username + "')]]")));
	    
	 

	    // Get the checkbox within that row
	    WebElement checkbox = userRow.findElement(By.xpath("./td[1]/input[@type='checkbox']"));

	    // Click checkbox using JavaScript to ensure selection
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", checkbox);
	    System.out.println("Checkbox selected for user: " + username);

	    // Locate and click the delete button using JavaScript
	    WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//i[@class='icon-trash']")));
	    js.executeScript("arguments[0].click();", deleteButton);
	    System.out.println("Delete button clicked for user: " + username);

	    // Wait for the confirmation alert and accept it
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    alert.accept();
	    System.out.println("Alert accepted.");

	    // Wait until the user row disappears to confirm deletion
	    boolean isDeleted = wait.until(ExpectedConditions.invisibilityOf(userRow));

	    if (isDeleted) {
	        System.out.println("User deleted successfully.");
	    } else {
	        System.out.println("User deletion failed.");
	    }
	}


}
