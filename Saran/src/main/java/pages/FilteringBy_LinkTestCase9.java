package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilteringBy_LinkTestCase9 {
	WebDriver driver;
	public FilteringBy_LinkTestCase9(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	@FindBy(xpath="//body[@id='tinymce']")WebElement comment;
	//@FindBy(xpath = "//select[@id='assignee']")WebElement assignee;
	public void cilickComplaint()
	{
		complaint.click();

		
		 // Wait for the page to fully load
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	}
	public void clickFilterByGroup(String group) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	    WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"ticketGenericSearchInput\"]")));
	    search.clear();
	    search.sendKeys(group);
	    WebElement searchbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Search\"]")));
	    searchbutton.click();
	  
	  }
	
	public void clickFilterByLinkTitle(String title) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	    WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"ticketGenericSearchInput\"]")));
	    search.clear();
	    search.sendKeys(title);
	    WebElement searchbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Search\"]")));
	    searchbutton.click();
	  
	  }
	public void clickFilterByLinkID(String id) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	    WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"ticketGenericSearchInput\"]")));
	    search.clear();
	    search.sendKeys(id);
	    WebElement searchbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Search\"]")));
	    searchbutton.click();
	  
	  }
	
}
