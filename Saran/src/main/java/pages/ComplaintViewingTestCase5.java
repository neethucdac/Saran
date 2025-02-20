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

public class ComplaintViewingTestCase5 {
	WebDriver driver;
	public ComplaintViewingTestCase5(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
public void clickComplaint(String complaintid)
{
	complaint.click();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement complaintListLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//a[contains(text(),'Complaint List')]")
	    ));

	    Assert.assertTrue(complaintListLink.isDisplayed(), "Complaint List link is not displayed!");
	    // Wait for the page to fully load
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    waits.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	    
	    
//	    String input=complaintid;
//	    List<WebElement> table=driver.findElements(By.xpath("//table[@id='ticketsTable']/tbody/tr/td[3]")); 
//
//		  // Iterate through rows and find the matching text
//	    for (WebElement element : table) {
////	    	System.out.println("Row text: '" + element.getText() + "'");
////	        if (element.getText().equals(input)) {
////	            System.out.println("Found input: " + element.getText());
//	    	
//	    	String rowText = element.getText().trim();  // Get the row text
//
//	        // If the row text matches the input, print and click the element
//	        if (rowText.equals(input)) {
//	            System.out.println("Found matching input: " + rowText);  // Output only when a match is found
//
//	            
//	            // Click the matching element
//	            JavascriptExecutor jsselement=(JavascriptExecutor) driver;
//	            jsselement.executeScript("arguments[0].scrollIntoView(true);", element);
//	            element.click();
//	            System.out.println("element is clicked.... " );
//	         // Wait for the page to fully load
//	    	    WebDriverWait waitss = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    	    JavascriptExecutor jss = (JavascriptExecutor) driver;
//	    	    waitss.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
//	    	    System.out.println("element is clicked1.... " );
//	            break; // Exit loop after finding and clicking the element
//	        }
//	}
	    
	    
	    
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
 		
    
}
public void verifyLink()
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-12' and normalize-space()='Link']")));
	Assert.assertTrue(link.isDisplayed(), " link is not displayed!");
	WebDriverWait waits=new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement linkname=waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"mt-comment-text\"]")));
	linkname.click();
	WebElement linkid=waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"caption-subject font-green-steel bold\"]")));
	Assert.assertTrue(linkid.isDisplayed(), "Linkid is displayed");
	
}
}
