package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewComplaintTestcase5 {
	WebDriver driver;
	public NewComplaintTestcase5(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	public void clickComplaint()
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
		    
		    


	}
	public void newComplaint() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
	    WebElement newcomplaint = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//i[@class='glyphicon glyphicon-plus-sign']")
	    ));

	    // Open "New Complaint" in a new tab
	    Actions action = new Actions(driver);
	    action.keyDown(Keys.CONTROL).click(newcomplaint).keyUp(Keys.CONTROL).perform();

	    // Wait for new tab to load
	    Thread.sleep(2000);

	    // Switch to the new tab
	    for (String handle : driver.getWindowHandles()) {
	        driver.switchTo().window(handle);
	    }

	    // Verify navigation is correct
	    System.out.println("After Click - URL: " + driver.getCurrentUrl());
	}

	
//	public void newComplaint() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//	    WebElement newcomplaint = wait.until(ExpectedConditions.elementToBeClickable(
//	        By.xpath("//i[@class='glyphicon glyphicon-plus-sign']")
//	    ));
//
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("window.onbeforeunload = function() {};"); // Prevent auto-navigation
//	    newcomplaint.click();
//
//	    //JavascriptExecutor js = (JavascriptExecutor) driver;
//	    String jsCode = "return window.performance.getEntriesByType('navigation').map(n => n.type).join(', ');";
//	    String navType = (String) js.executeScript(jsCode);
//
//	    System.out.println("Navigation Type: " + navType);
//
//
//	    wait.until(ExpectedConditions.presenceOfElementLocated(
//	        By.xpath("//button[@id=\"btnSave\"]")
//	    ));
//
//	    System.out.println("After Click - URL: " + driver.getCurrentUrl());
//	}
}



