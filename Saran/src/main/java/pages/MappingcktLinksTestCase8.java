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

public class MappingcktLinksTestCase8 {
	WebDriver driver;
	public MappingcktLinksTestCase8(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	@FindBy(xpath="//body[@id='tinymce']")WebElement comment;
	//@FindBy(xpath = "//select[@id='assignee']")WebElement assignee;
	public void verifyComplaintList(String complaintid) throws InterruptedException
	{
		complaint.click();
		
	
		
		
		
		// Wait for the table to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		
		//CHECKS WHETHETHER LINK IS THERE FOR COMPLAINT
		WebElement assurelink=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"col-sm-12\"])[3]")));
		if(assurelink.isDisplayed())
		{
			System.out.println("Link is mapped for corresponding complaint id");
		}
		else
		{
			System.out.println("Link is NOT mapped for corresponding complaint id");
		}
		
		//CHECK ASSIGNEE IS THERE FOR THAT LINK
		
		
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inbox-sidebar")));

        // Get the text inside ASSIGNEE
        String sidebarText = sidebar.getText().trim();

        // Check if the content is present
        if (!sidebarText.isEmpty()) {
            System.out.println("Dynamic content is present: " + sidebarText);
        } else {
            System.out.println("No content found inside 'inbox-sidebar'.");
        }
        
        //CLICK LINKNAME
        WebElement linkname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mt-comment-text")));
        linkname.click();
		
        //CHECKS WHETEHER CUSTOMER NAME IS PRESENT
        WebElement customername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='help-block'])[8]")));
        
        String custname=customername.getText().trim();
        
        if(!custname.isEmpty())
        {
        	System.out.println("Not assosicated with corresponding consumers");
        }
        



}
}
