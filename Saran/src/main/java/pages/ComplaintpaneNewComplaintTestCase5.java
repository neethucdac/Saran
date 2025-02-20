package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class ComplaintpaneNewComplaintTestCase5 {
	WebDriver driver;
	public ComplaintpaneNewComplaintTestCase5(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	@FindBy(xpath = "//select[@name=\"assignee\"]")WebElement assigneedropdown;
	@FindBy(xpath="//body[@id='tinymce']")WebElement comment;
	@FindBy(xpath = "//select[@name='cat']")WebElement complaintcategory;
	@FindBy(xpath = "//select[@id='subcat']")WebElement subcomplaint;
	@FindBy(xpath = "//select[@name='group']")WebElement accessgroup;
	@FindBy(xpath = "//select[@name=\"priority\"]")WebElement priority;
	@FindBy(xpath = "//select[@name=\"source\"]")WebElement sourcetype;
	@FindBy(xpath = "(//input[@class='btn btn-success btn-xs'])[1]")WebElement selectLink;
	@FindBy(xpath = "//table[@id='subticketsTable']")WebElement tablelink;
	@FindBy(xpath = "//input[@id='ticketGenericSearchInput']")WebElement titleId;
	
	
	public void newComplaint() throws InterruptedException
	{
//		complaint.click();
//		
//		 // Wait for the page to fully load
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
//	    //WebElement newcomplaint=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class=\"lihrz ms-hover active\"]")));
//	    WebElement newComplaint = driver.findElement(By.xpath("(//li[span[contains(@class, 'fa-ticket-add')]])[3]"));
//		Actions action=new Actions(driver);
//		action.moveToElement(newComplaint).click().perform();
//		 // Wait for the page to fully load
//	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    JavascriptExecutor jss = (JavascriptExecutor) driver;
//	    waits.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
//	    
		
		
		
		  // Click the main "Complaint" menu
	    complaint.click();

	    // Wait for the menu to fully load
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[span[contains(@class, 'fa-ticket-add')]]")));

	    // Locate "New Complaint"
	    WebElement newComplaint = driver.findElement(By.xpath("//li[span[contains(@class, 'fa-ticket-add')]]"));

	    // Use JavaScript to ensure it's properly clicked
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", newComplaint);
	    js.executeScript("arguments[0].click();", newComplaint);

	    // Wait for the page to fully load after clicking
	    wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	}
	public void editNewcomplaint(String title,String complaintdescription,String assignee,String category,String complaintpriority,String source,String id)
	{
		//wait for complaint title
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement complainttiltle = driver.findElement(By.xpath("//input[@name=\"title\"]"));
		complainttiltle.sendKeys(title);
		
		 //Wait for the iframe to be present
	    WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionTextArea_ifr")));

	    // Switch to the iframe
	    driver.switchTo().frame(iframe);

	    // Locate the body inside the iframe
	    WebElement editorBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

	    // Perform actions on the body (e.g., entering text)
	    editorBody.clear(); // Optional: clear any existing text
	    editorBody.sendKeys(complaintdescription);
	    
	  //Switch back to the main content
	    driver.switchTo().defaultContent();
	 // Wait for the dropdown to be visible before selecting the assignee
	    WebElement assigneeDropdown = wait.until(ExpectedConditions.visibilityOf(assigneedropdown));
	    Select select=new Select(assigneedropdown);
	    select.selectByVisibleText(assignee);
	    Select comp_categorydropdown=new Select(complaintcategory);
	    comp_categorydropdown.selectByVisibleText(category);
	    Select subcomp_dropdown=new Select(subcomplaint);
	    subcomp_dropdown.selectByIndex(0);
	    Select accessgroup_dropdown=new Select(accessgroup);
	    accessgroup_dropdown.selectByIndex(0);
	    Select priority_dropdown=new Select(priority);
	    priority_dropdown.selectByVisibleText(complaintpriority);
	    Select sourcetype_dropdown=new Select(sourcetype);
	    sourcetype_dropdown.selectByVisibleText(source);
//	    selectLink.click();
//	    WebDriverWait tablewait=new WebDriverWait(driver, Duration.ofSeconds(50));
	   // WebElement table=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='portlet light'])[2]")));
	    
//	    WebElement table = driver.findElement(By.cssSelector("div.portlet.light:nth-of-type(2)"));
//	    WebElement idsearch=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ticketGenericSearchInput']")));
//	    idsearch.click();
//	    idsearch.sendKeys("32210");
//	    WebElement serialno=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='subticketsTable']/tbody/tr/td[1]")));
//	    

	    
	    
	  //click select link
	    WebDriverWait waitselectlink = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor jsscrolldown=(JavascriptExecutor) driver;
	    WebElement selectlink = waitselectlink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Select Link']")));
	    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", selectlink);
	    selectlink.click();
	    
	 // Wait for the page to fully load
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor jss = (JavascriptExecutor) driver;
	    waits.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
	    WebDriverWait waitForDynamicElement = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waitForDynamicElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'Add')])[1]")));


	    
	    // Wait for titleid
//	    WebDriverWait waittitleid = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    WebElement titleId=waittitleid.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ticketGenericSearchInput']")));
//	    titleId.click();
//	    titleId.sendKeys(id);
	    
//	    //wait for search
//	    WebDriverWait waitsearch = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    WebElement search=waitsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Search']")));
//	    search.click();
//	    
//	    //wait for radiobutton
//	    WebDriverWait waitsino = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    WebElement serialno=waitsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='ticketRadio']")));
//	    serialno.click();
//	    
//	    //wait for add button
//	    WebDriverWait waitadd = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    WebElement add=waitadd.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[normalize-space(text())='Add'])[1]")));
//	    add.click();
//	    
//	    driver.switchTo().alert().accept();//to click OK
	    
		
		
	}
	    
//	    String input=complaintid;
//	    List<WebElement> table=driver.findElements(By.xpath("//table[@id='ticketsTable']/tbody/tr/td[3]")); 
//
//		  // Iterate through rows and find the matching text
//	    for (WebElement element : table) {
//	    	System.out.println("Row text: '" + element.getText() + "'");
//	        if (element.getText().equals(input)) {
//	            System.out.println("Found input: " + element.getText());
//	            
//	            // Click the matching element
//	            element.click();
//	         // Wait for the page to fully load
//	    	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    	    JavascriptExecutor jss = (JavascriptExecutor) driver;
//	    	    waits.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
//	    	   
//	            break; // Exit loop after finding and clicking the element
//	        }
	
	
	
	
//	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
//	@FindBy(xpath="(//span[@class=\"fa fa-ticket-add\"])[3]")WebElement newcomplaint;
//	@FindBy(xpath = "//select[@name=\"assignee\"]")WebElement assignee;
//	@FindBy(xpath = "//select[@id='subcat']")WebElement subcomplaint;
//	@FindBy(xpath = "//select[@name='group']")WebElement accessgroup;
//	@FindBy(xpath = "(//input[@class='btn btn-success btn-xs'])[1]")WebElement selectLink;
//	//@FindBy(xpath = "//table[@id='subticketsTable']")WebElement tablelink;
//	//@FindBy(xpath = "//body[@id='tinymce']")WebElement description;
//	//@FindBy(xpath = "(//span[@class='fa fa-dashboard'])[1]")WebElement complaintlist;
//	//@FindBy(xpath = "//i[@class='glyphicon glyphicon-plus-sign']")WebElement addcomplaint;
//	public void addComplaint(String complainttiltle,String complaintdescription)
//	{
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(complaint)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(newcomplaint)).click();
//		WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='title']")));
//		title.sendKeys(complainttiltle);
//		
//		
//		 // Wait for the iframe to be present
//	    WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionTextArea_ifr")));
//
//	    // Switch to the iframe
//	    driver.switchTo().frame(iframe);
//
//	    // Locate the body inside the iframe
//	    WebElement editorBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
//
//	    // Perform actions on the body (e.g., entering text)
//	    editorBody.clear(); // Optional: clear any existing text
//	    editorBody.sendKeys(complaintdescription);
//
//	    // Switch back to the main content
//	    driver.switchTo().defaultContent();
//	    Select select=new Select(assignee);
//	    select.selectByIndex(3);
//	    Select subcomp_dropdown=new Select(subcomplaint);
//	    subcomp_dropdown.selectByIndex(0);
//	    Select accessgroup_dropdown=new Select(accessgroup);
//	    accessgroup_dropdown.selectByIndex(0);
//	    selectLink.click();
//	    WebDriverWait tablewait=new WebDriverWait(driver, Duration.ofSeconds(50));
//	   // WebElement table=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='portlet light'])[2]")));
//	    
////	    WebElement table = driver.findElement(By.cssSelector("div.portlet.light:nth-of-type(2)"));
////	    WebElement idsearch=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ticketGenericSearchInput']")));
////	    idsearch.click();
////	    idsearch.sendKeys("32210");
////	    WebElement serialno=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='subticketsTable']/tbody/tr/td[1]")));
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    waits.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.portlet.light:nth-of-type(2)"))); // Wait for the parent container
//	    WebDriverWait waitss = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    //WebElement idsearch = waitss.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ticketGenericSearchInput']")));
//	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ticketGenericSearchInput']")));
//
//	    //idsearch.click();
////	    idsearch.sendKeys("32210");
//	    //WebElement searchtable=driver.findElement(By.xpath("//input[@id='ticketGenericSearchInput']"));
//
//	    //WebElement tablelink=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='subticketsTable']")));
////	    tablelink.click();
////	    WebElement tablerow=tablewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='subticketsTable']//tbody//tr[1]")));
////	    tablerow.click();
//	    		
//
//	}
////	public void clickAddcomplaint()
////	{
////		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
////		WebElement addcomplaint=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class=\"btn btn-outline btn-icon-only btn-default\"])[1]")));
////		Actions actin=new Actions(driver);
////		actin.moveToElement(addcomplaint).click().perform();
////		//addcomplaint.click();
////	}

}
