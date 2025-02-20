package pages;

import org.testng.Assert;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import dev.failsafe.internal.util.Assert;

public class ComplaintpaneListingTestCase5 {
	WebDriver driver;
	
		public ComplaintpaneListingTestCase5(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
		public void viewingComplaints()
		
		{
			complaint.click();
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    WebElement complaintListLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//a[contains(text(),'Complaint List')]")
			    ));

			    Assert.assertTrue(complaintListLink.isDisplayed(), "Complaint List link is not displayed!");
			
		}

}
