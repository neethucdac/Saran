package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckTicketClosedTestCase13 {
	WebDriver driver;
	public CheckTicketClosedTestCase13(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	@FindBy(xpath="//body[@id='tinymce']")WebElement comment;
	public void updateComplaint(String complaintid) throws InterruptedException
	{
		complaint.click();
		
		// Wait for the page to fully load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

		// Wait for the table to be present
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ticketsTable")));

		// Find all rows in the 3rd column
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='ticketsTable']/tbody/tr/td[3]/a"));

		boolean complaintFound = false;

		for (WebElement row : tableRows) {
		    String rowText = row.getText().trim();

		    if (rowText.equals(complaintid)) {
		        System.out.println("Found matching complaint ID: " + rowText);
		        complaintFound = true;

		        // Scroll into view
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", row);

		        // Wait for the <a> element to be clickable
		        wait.until(ExpectedConditions.elementToBeClickable(row));

		        // Click the <a> tag (not <td>)
		        try {
		            row.click();
		            System.out.println("Element clicked using Selenium.");
		        } catch (Exception e) {
		            jsExecutor.executeScript("arguments[0].click();", row);
		            System.out.println("Element clicked using JavaScript.");
		        }

		        break; // Stop after finding and clicking the complaint ID
		    }
		}
		// After checking if the complaint is found
		if (!complaintFound) {
		    System.out.println("✅ Success: Complaint ID '" + complaintid + "' is NOT present in the table.");
		    Assert.assertTrue(true, "Complaint ID is not present, as expected.");
		} else {
		    System.out.println("❌ Failure: Complaint ID '" + complaintid + "' was found.");
		    Assert.fail("Complaint ID should not be present, but it was found.");
		}


}
}
