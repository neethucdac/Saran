package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class LinkDownTimeOccurrenceforTicketTestCase32 {
	WebDriver driver;
	public  LinkDownTimeOccurrenceforTicketTestCase32(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")
	WebElement complaint;
	// Locate the table
    @FindBy(id = "ticketsTable")
    WebElement ticketsTable;

    // Locate all rows in the table
    @FindBy(xpath = "//table[@id='ticketsTable']//tr")
    List<WebElement> ticketRows;
    public void clickComplaint(String complaintid)
	{
    	complaint.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		 // Wait for the page to fully load
	   
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
	 		
	}


	public void verifyLinkDowndetails()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement assurecurentmonth=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'Current Month')])[1]")));
		AssertJUnit.assertTrue("Current Month section is displayed!", assurecurentmonth.isDisplayed());
		WebElement assurelast3month=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'Last 3 Months')])[1]")));
		AssertJUnit.assertTrue("Last3Months section is displayed", assurelast3month.isDisplayed());
	}
}
