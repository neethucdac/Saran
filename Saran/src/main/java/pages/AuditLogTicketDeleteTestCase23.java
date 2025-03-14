package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuditLogTicketDeleteTestCase23 {
	WebDriver driver;

	public AuditLogTicketDeleteTestCase23(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void clickAuditLog()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement admin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"fa fa-institution\"]")));
		admin.click();
		WebElement system = wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("(//span[@class=\"fa fa-cogs\"])[2]")));
//		Actions action=new Actions(driver);
//		action.click(system).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", system);

		//system.click();
		WebElement auditlogs=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Audit Log')]")));
		auditlogs.click();
	}
	public void verifyDeleteTicket()
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement auditlogsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"auditlogSearchInput\"]")));
		auditlogsearch.click();
		auditlogsearch.sendKeys("delete");
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Search')])[1]")));
		search.click();
		
		 
	    WebElement auditLogTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auditlogTable")));

	 // Find the first row that contains "Logged"
	    WebElement firstLoggedCell = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("//tr[1]/td[contains(text(),'deleted')]")
	    ));
	    // Check if any cell contains "Logged"

	 // Check if the element is found and visible
	 boolean isLoggedPresent = firstLoggedCell.isDisplayed();

	 // Assertion: Test will pass if "Logged" is found, otherwise fail
	 Assert.assertTrue(isLoggedPresent, "❌ 'tag created' not found in the first row of the Audit Log table!");

	 // If test passes
	 System.out.println("✅ Test Passed: 'tag created' found in the first row of the Audit Log table.");
		
	}

}
