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
import org.testng.AssertJUnit;

public class TimeDurationTestCase20 {
	WebDriver driver;
	public TimeDurationTestCase20(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	@FindBy(xpath="//body[@id='tinymce']")WebElement comment;
	//@FindBy(xpath = "//select[@id='assignee']")WebElement assignee;
	public void updateComplaint(String complaintid) throws InterruptedException
	{
		complaint.click();
		
		 // Wait for the page to fully load
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	    
	    
	 // Wait for the table to load
	 		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ticketsTable")));

	 		// Find all rows in the 3rd column
	 		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='ticketsTable']/tbody/tr/td[3]/a"));

	 		for (WebElement row : tableRows) {
	 		    String rowText = row.getText().trim();

	 		    if (rowText.equals(complaintid)) {
	 		        System.out.println("Found matching complaint ID: " + rowText);

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
	 		
	    

	    
	    
	    JavascriptExecutor jsscrolldown=(JavascriptExecutor) driver;
	    long lastHeight = (long) jsscrolldown.executeScript("return document.body.scrollHeight");
	    while (true) {
	        jsscrolldown.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(2000); // Allow time for content to load
	        long newHeight = (long) jsscrolldown.executeScript("return document.body.scrollHeight");
	        if (newHeight == lastHeight) {
	            break; // Exit the loop if no new content is loaded
	        }
	        lastHeight = newHeight;
	    }

	  
}
	public void verifyTimeSpentinAssignee()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;

	    // Find the "Time Spent:" label
	    WebElement timeSpentLabel = driver.findElement(By.xpath("//label[contains(text(), 'Time Spent:')]"));
	    js.executeScript("arguments[0].scrollIntoView(true);", timeSpentLabel);

	    // Get the text node following the label using JavaScript
	    String timeSpentText = (String) js.executeScript(
	        "var label = arguments[0]; " +
	        "var nextSibling = label.nextSibling; " +
	        "return nextSibling ? nextSibling.textContent.trim() : '';",
	        timeSpentLabel
	    );

	    // Debugging Output
	    System.out.println("Extracted Time Spent Value: '" + timeSpentText + "'");
	    System.out.println("Extracted Time Spent Length: " + timeSpentText.length());

	    // Check if extracted text is empty or contains only whitespace
	    if (timeSpentText.isBlank()) {  // `.isBlank()` checks for empty or all whitespace
	        throw new AssertionError("Test Failed: 'Time Spent' value is missing!");
	    } else {
	        System.out.println("Extracted Time Spent: " + timeSpentText);
	    }
}
}
