package pages;

import org.testng.AssertJUnit;
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

import com.aventstack.extentreports.util.Assert;

public class LinkDownTimeOccurrenceTestCase15 {
	WebDriver driver;
	public  LinkDownTimeOccurrenceTestCase15(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[normalize-space()='Link'])[1]")WebElement link;
	// Locate the table
    @FindBy(id = "ticketsTable")
    WebElement ticketsTable;

    // Locate all rows in the table
    @FindBy(xpath = "//table[@id='ticketsTable']//tr")
    List<WebElement> ticketRows;
    public void clickLink()
	{
		link.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement linklist=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Link List'])[1]")));
		AssertJUnit.assertTrue(linklist.isDisplayed());
	}


	public void clickLinkById(String id) {
	    JavascriptExecutor js = (JavascriptExecutor) driver; // Initialize JavaScript Executor

	    for (WebElement row : ticketRows) {
	        try {
	            // Find the third column relative to the current row
	            WebElement thirdColumn = row.findElement(By.xpath("./td[3]"));
	            String rowId = thirdColumn.getText().trim();
	            System.out.println("Row ID: " + rowId);

	            if (rowId.equals(id)) {
	                // Scroll into view before clicking
	                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", thirdColumn);

	                // Find and click the link inside the third column
	                WebElement link = thirdColumn.findElement(By.tagName("a"));

	                // Add a short wait to ensure visibility
	                Thread.sleep(500);

	                link.click();
	                System.out.println("Clicked on link with ID: " + id);
	                break;
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("No third column found in this row.");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
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
