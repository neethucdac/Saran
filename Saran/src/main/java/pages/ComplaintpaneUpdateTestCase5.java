package pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.sdk.common.Clock;
import io.reactivex.rxjava3.functions.Action;

public class ComplaintpaneUpdateTestCase5 {
	WebDriver driver;
	public ComplaintpaneUpdateTestCase5 (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")WebElement complaint;
	@FindBy(xpath="//body[@id='tinymce']")WebElement comment;
	//@FindBy(xpath = "//select[@id='assignee']")WebElement assignee;
	public void updateComplaint(String complaintid,String updatecomment,String updateassignee,String compcategory,String cmplpriority,String complaintstatus,String srcetype,String id,String teamdropdown,String time,String reasonforoccurrence,String caller_name,String caller_email,String caller_mobile,String caller_landline,String escalatedtime) throws InterruptedException
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
//	    	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
//	    	    JavascriptExecutor jss = (JavascriptExecutor) driver;
//	    	    waits.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
//	    	    System.out.println("element is clicked1.... " );
//	            break; // Exit loop after finding and clicking the element
//	        }
//	}
	    //to scrolldown for that particular element update
	    
//	    JavascriptExecutor jsscrolldown=(JavascriptExecutor) driver;
//
//	    
//	   
//
//	    WebElement elementToScroll = driver.findElement(By.xpath("//button[@onclick='editTicket(32216)']"));
//	    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
//	    
//	    Actions actions = new Actions(driver);
//	    actions.moveToElement(elementToScroll).click().perform();

//	    elementToScroll.click();
//	    
//	 // Wait for element to be clickable
//	    wait.until(ExpectedConditions.elementToBeClickable(elementToScroll));
//
//	    // Click using JavaScript to handle interception
//	    JavascriptExecutor executor = (JavascriptExecutor) driver;
//	    executor.executeScript("arguments[0].click();", elementToScroll);
	    
//	    //updating complaint..
//	    driver.switchTo().frame("descriptionTextArea_ifr");
//	    //WebElement comment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='tinymce']")));
//	    comment.sendKeys("adsadf");
//	    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
//	    Select select=new Select(assignee);
//	    select.selectByValue("Abhishek");

	    // Switch to the iframe and update the comment
//	    driver.switchTo().frame("descriptionTextArea_ifr");
//	    WebElement commentElement = wait.until(ExpectedConditions.visibilityOf(comment));
//	    commentElement.sendKeys("adsadf");
//	    // Scroll back to the assignee dropdown
//	    driver.switchTo().defaultContent();
//	    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", assignee);
//
//	    // Select the assignee
//	    Select select = new Select(assignee);
//	    select.selectByValue("Abhishek");
	    
	    
	    
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

	    // Locate and interact with the button
	    WebElement elementToScroll = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
	    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);
	    elementToScroll.click();
	    
	  //Switch to the iframe and update the comment
	    driver.switchTo().frame("descriptionTextArea_ifr");
	    WebDriverWait waitforcomment=new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement commentElement = waitforcomment.until(ExpectedConditions.visibilityOf(comment));
	    commentElement.sendKeys(updatecomment);
	    
	 // Select the assignee
	    driver.switchTo().defaultContent();

	    WebDriverWait waitassignee = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement assignee = waitassignee.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='assignee']")));
	    Select select = new Select(assignee);
	    select.selectByVisibleText(updateassignee);

	    //select complaintcategory
	    WebDriverWait waitcomplaintcategory = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement complaintcategory = waitcomplaintcategory.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='cat']")));
	    Select selectcomplaintcategory = new Select(complaintcategory);
	    selectcomplaintcategory.selectByVisibleText(compcategory);
	    
	    //select priority
	    WebDriverWait waitpriority = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement priority = waitpriority.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='priority']")));
	    Select selectpriority = new Select(priority);
	    selectpriority.selectByVisibleText(cmplpriority);

	    //select complaintstatus
	    WebDriverWait waitcomplaintstatus = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement complainttstatus = waitcomplaintstatus.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='status']")));
	    Select selectcomplaintstatus = new Select(complainttstatus);
	    selectcomplaintstatus.selectByVisibleText(complaintstatus);
	    
	  //select sourcetype
	    WebDriverWait waitsourcetype = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement sourcetype = waitcomplaintstatus.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='source']")));
	    Select selectsourcetype = new Select(sourcetype);
	    selectsourcetype.selectByVisibleText(srcetype);
	    
	    //click select link
	    WebDriverWait waitselectlink = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement selectlink = waitselectlink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Select Link']")));
	    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", selectlink);
	    selectlink.click();
	    
	 // Wait for the page to fully load
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor jss = (JavascriptExecutor) driver;
	    waits.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
	    
	    // Wait for titleid
	    WebDriverWait waittitleid = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement titleId=waittitleid.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ticketGenericSearchInput']")));
	    titleId.click();
	    titleId.sendKeys(id);
	    
	    //wait for search
	    WebDriverWait waitsearch = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement search=waitsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Search']")));
	    search.click();
	    
	    //wait for radiobutton
	    WebDriverWait waitsino = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement serialno=waitsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='ticketRadio']")));
	    serialno.click();
	    
	    //wait for add button
	    WebDriverWait waitadd = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement add=waitadd.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[normalize-space(text())='Add'])[1]")));
	    add.click();
	    
	    driver.switchTo().alert().accept();//to click OK
	    
	    //wait for technicalteam
	    WebDriverWait waittechteam = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement techteam=waittechteam.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class=\"selected tree_select_area\"])[1]")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", techteam);//scrolldown till the element is visible
	    techteam.click();
	    
	    //to select technicalteam from dropdown (dropdown doesnot contain select so using list elements are listed and using for loop checked the value from excelsheet with the dropdown)
	    String teamdropdownvalue=teamdropdown;
	    List <WebElement> teamdropdownoptions=driver.findElements(By.xpath("//ul[@class='jstree-children']//a"));
	    for(WebElement element:teamdropdownoptions) 
		{ 
		if(element.getText().equals(teamdropdownvalue)) 
		{ 
			System.out.println(element.getText());
			element.click();
			 
		} 
		} 
	    
	    String escalatedtovalue="ERTCC";
	    WebDriverWait waitescalatedto = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement escalatedto=waitescalatedto.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class=\"selected tree_select_area\"])[2]")));
	    escalatedto.click();
	    JavascriptExecutor jst = (JavascriptExecutor) driver;
	    List<WebElement> esclatedtooptions = driver.findElements(By.xpath("//ul[@class='jstree-container-ul jstree-children jstree-striped jstree-contextmenu']//a"));
	    System.out.println("Number of options found: " + esclatedtooptions.size());

	    // Iterate through options
	    for (WebElement elements : esclatedtooptions) {
	        // Use JavaScript to extract inner text
	        String visibleText = (String) jst.executeScript("return arguments[0].innerText;", elements);
	        System.out.println("Row text: " + visibleText.trim());

	        // Check if this is the desired element
	        if (visibleText.trim().equals(escalatedtovalue)) {
	            System.out.println("Clicking: " + visibleText.trim());

	            WebDriverWait waitForClick = new WebDriverWait(driver, Duration.ofSeconds(10));
	            waitForClick.until(ExpectedConditions.elementToBeClickable(elements));
	            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	            //elements.click();
//	            WebDriverWait waitarrow = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    	    WebElement arrow=waitescalatedto.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='jstree-icon jstree-ocl'])[1]")));
//	    	   // arrow.click();
//	    	    Actions actions = new Actions(driver);
//	    	    actions.moveToElement(arrow).click().perform();
	            WebDriverWait waitee = new WebDriverWait(driver, Duration.ofSeconds(30));
	            //WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='jstree-icon jstree-ocl'])[1]")));
	            WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@role='presentation'])[9]")));

	            if (arrow.isDisplayed() && arrow.isEnabled()) {
	                arrow.click();
	                WebDriverWait waiteee = new WebDriverWait(driver, Duration.ofSeconds(30));
		            //WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='jstree-icon jstree-ocl'])[1]")));
		            WebElement opt = waiteee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='AKUSINGH'])[1]")));
		            opt.click();
	            } else {
	                System.out.println("Arrow is not visible or interactable.");
	            }


	            break;
	        }
	    }
	    
	    
	    //wait for calender
	    	    
	    
	    WebDriverWait waitc = new WebDriverWait(driver, Duration.ofSeconds(30));

//	 // Wait for the calendar icon and click it
//	 WebElement calendarIcon = waitc.until(ExpectedConditions.presenceOfElementLocated(
//	     By.xpath("(//span[@class='fa fa-calendar icon-green'])[3]")
//	 ));
//	 calendarIcon.click();
//
//	 // Wait for the calendar table to load
//	 WebElement calendarTable = waitc.until(ExpectedConditions.visibilityOfElementLocated(
//	     By.xpath("//table[contains(@class, 'table-condensed')]")
//	 ));
//
//	 // Debug: Print all dates
//	 List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td"));
//	 for (WebElement date : dates) {
//	     System.out.println("Date: " + date.getText() + ", Classes: " + date.getAttribute("class"));
//	 }
//
//	 // Wait for today's date and interact with it
//	 WebElement todayDate = waitc.until(ExpectedConditions.elementToBeClickable(
//	     By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td[contains(@class, 'today') and contains(@class, 'day')]")
//	 ));
//	 JavascriptExecutor jds = (JavascriptExecutor) driver;
//	 jds.executeScript("arguments[0].scrollIntoView(true);", todayDate);
//	 jds.executeScript("arguments[0].click();", todayDate);

   WebElement etrcalender=waitc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"51_cusID\"]")));
   etrcalender.clear();
   etrcalender.sendKeys("14/02/2025");

	 //clockpicker for ETR
	 
	 WebDriverWait waitcl = new WebDriverWait(driver, Duration.ofSeconds(30));
	 WebElement clockpicker=waitcl.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='51_cusIDT']")));
	 clockpicker.clear();
	 clockpicker.sendKeys(time);

	 
	 //wait for ETR extendedcalender
	    
	    
	    WebDriverWait waitcexc = new WebDriverWait(driver, Duration.ofSeconds(30));

	 // Wait for the calendar icon and click it
//	 WebElement calendarextIcon = waitcexc.until(ExpectedConditions.presenceOfElementLocated(
//	     By.xpath("//input[@name='52_cusID']")
//	 ));
//	 calendarextIcon.click();
//
//	 // Wait for the calendar table to load
//	 WebElement calendarextTable = waitc.until(ExpectedConditions.visibilityOfElementLocated(
//	     By.xpath("//table[@class=' table-condensed']")
//	 ));
//
//	 // Debug: Print all dates
//	 List<WebElement> extcaldates = driver.findElements(By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td"));
//	 for (WebElement date : extcaldates) {
//	     System.out.println("Date: " + date.getText() + ", Classes: " + date.getAttribute("class"));
//	 }
//
//	 // Wait for today's date and interact with it
//	 WebElement todayDatofexcalender = waitc.until(ExpectedConditions.elementToBeClickable(
//	     By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td[contains(@class, 'today') and contains(@class, 'day')]")
//	 ));
//	 JavascriptExecutor jdsext = (JavascriptExecutor) driver;
//	 jdsext.executeScript("arguments[0].scrollIntoView(true);", todayDatofexcalender);
//	 jdsext.executeScript("arguments[0].click();", todayDatofexcalender);

	    
	    
//	    WebElement etr_extcalender=waitcexc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"52_cusID\"]")));
//	    etr_extcalender.clear();
//	    etr_extcalender.sendKeys("16/02/2025");
//	    
	    
	    
	    for (int i = 0; i < 3; i++) { // Retry up to 3 times
	        try {
	            WebElement element = driver.findElement(By.xpath("//input[@id=\"52_cusID\"]"));
	            element.clear();
	            element.sendKeys("16/02/2025");
	            return;
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Element became stale. Retrying... " + (i + 1));
	        }
	    }
	   // throw new RuntimeException("Failed after 3 retries");
	
	    
	 // Click outside to close the calendar
	    driver.findElement(By.xpath("//body")).click();
	 //clockpicker for extended ETR
//	 WebElement clockpicker1=waitcexc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='52_cusIDT']")));
//	 clockpicker1.clear();
//	 clockpicker1.sendKeys(time);

	    for (int i = 0; i < 3; i++) { // Retry up to 3 times
	        
	            WebElement clockpicker1 = driver.findElement(By.xpath("//input[@name='52_cusIDT']"));
	            System.out.println();
	            System.out.println("clock for extended etr...........");
	            clockpicker1.clear();
	       	 clockpicker1.sendKeys(time);
	            return;
	        
	            
	    }
	    
	//wait for Actual Resolution time calender
	    
	    
	    WebDriverWait waitartc = new WebDriverWait(driver, Duration.ofSeconds(30));

	 // Wait for the calendar icon and click it
//	 WebElement calendarartc = waitartc.until(ExpectedConditions.presenceOfElementLocated(
//	     By.xpath("//input[@name='43_cusID']")
//	 ));
//	 calendarartc.click();
//
//	 // Wait for the calendar table to load
//	 WebElement calendarartctable = waitartc.until(ExpectedConditions.visibilityOfElementLocated(
//	     By.xpath("//table[@class=' table-condensed']")
//	 ));

	 // Debug: Print all dates
//	 List<WebElement> calartcdates = driver.findElements(By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td"));
//	 for (WebElement date : calartcdates) {
//	     System.out.println("Date: " + date.getText() + ", Classes: " + date.getAttribute("class"));
//	 }
//
//	 // Wait for today's date and interact with it
//	 WebElement todayDatofcalenderartc = waitartc.until(ExpectedConditions.elementToBeClickable(
//	     By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td[contains(@class, 'today') and contains(@class, 'day')]")
//	 ));
//	 JavascriptExecutor jdartc = (JavascriptExecutor) driver;
//	 jdartc.executeScript("arguments[0].scrollIntoView(true);", todayDatofcalenderartc);
//	 jdartc.executeScript("arguments[0].click();", todayDatofcalenderartc);
//	  
	
	   // WebElement calenderartc=waitcexc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"43_cusID\"]")));
//	    calenderartc.clear();
//	    calenderartc.sendKeys("10/02/2025");
	    for (int i = 0; i < 3; i++) { // Retry up to 3 times
	        try {
	            WebElement element = driver.findElement(By.xpath("//input[@id='43_cusID']"));
	            element.clear();
	            element.sendKeys("12/02/2025");
	            System.out.println("clock for extended ACTUAL RESOLUTION TIME...........");
	            return;
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Element became stale. Retrying... " + (i + 1));
	        }
	    }
	 // Click outside to close the calendar
	    driver.findElement(By.xpath("//body")).click();
	
	//clockpicker for arm
	 
		WebElement clock=driver.findElement(By.xpath("//input[@name='43_cusIDT']"));
		clock.clear();
		clock.sendKeys(escalatedtime);
		
		
		//clicking reason for occurrence
		WebDriverWait waitreasonoccu=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement dropdown=waitreasonoccu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='38_cusID']")));
		dropdown.click();
		Select selectdropdown=new Select(dropdown);
		selectdropdown.selectByVisibleText(reasonforoccurrence);
		
		
		WebElement subreasonoccurrence1=driver.findElement(By.xpath("//input[@id='54_cusID']"));
		subreasonoccurrence1.clear();
		subreasonoccurrence1.sendKeys("test1");
		
		
//callers personal info
		WebDriverWait waitpesonalinfo=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement name=waitpesonalinfo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"12_cusID_16\"]")));
		name.clear();
		name.sendKeys(caller_name);
		WebElement email=waitpesonalinfo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='13_cusID_16']")));
		email.clear();
		email.sendKeys(caller_email);
		WebElement mobile=waitpesonalinfo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='14_cusID_16']")));
		mobile.clear();
		mobile.sendKeys(caller_mobile);
		WebElement landline=waitpesonalinfo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='15_cusID_16']")));
		landline.clear();
		landline.sendKeys(caller_landline);
		
//

}
	//class for uploading file
	public void robotclass(String descriptionforupdate) throws AWTException
	{

	    String currenturl=driver.getCurrentUrl();
	    System.out.println(currenturl);

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addfile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));
		addfile.click();
		WebElement choosefile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_1\"]")));
		choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\test.txt");
		WebElement description=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control input-sm\"]")));
		description.sendKeys(descriptionforupdate);

		
	}
	//class for observertagupdate buttons
	public void observerTagUpdate(String observername)
	{
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement observer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Observer']")));
		
		JavascriptExecutor jsscrolldown=(JavascriptExecutor) driver;
		 WebElement observer = driver.findElement(By.xpath("//a[normalize-space(text())='Observer']"));
		    jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", observer);
		Actions action=new Actions(driver);
		action.click(observer).perform();
		//select from the observers
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Find the scrollable container
		WebElement scrollableContainer = driver.findElement(By.xpath("//ul[@class='ms-list']"));

		
		List<WebElement> observerlist = driver.findElements(By.xpath("//ul[@class='ms-list']//li"));
	    System.out.println("Number of options found: " + observerlist.size());
	    JavascriptExecutor jst = (JavascriptExecutor) driver;

	    // Iterate through options
	    for (WebElement elements : observerlist) {
	        // Use JavaScript to extract inner text
	        String visibleText = (String) jst.executeScript("return arguments[0].innerText;", elements);
	        //System.out.println("Row text: " + visibleText.trim());

	        // Check if this is the desired element
	        if (visibleText.trim().equals(observername)) {
	            System.out.println("Clicking: " + visibleText.trim());

	            WebDriverWait waitForClick = new WebDriverWait(driver, Duration.ofSeconds(10));
	            waitForClick.until(ExpectedConditions.elementToBeClickable(elements));
	            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements);
	            elements.click();
		//WebDriverWait waitForClick = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement savechanges=waitForClick.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space(text())='Save changes'])[1]")));

	            savechanges.click();
	           
	            break;
	        }

	}
	    //tag button
	    WebElement tags=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space(text())='Tags'])[1]")));
	    JavascriptExecutor jtag = (JavascriptExecutor) driver;
	    jtag.executeScript("arguments[0].scrollIntoView(true);", tags);
        tags.click();
        
        //checkbox for tag
        WebElement checkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"my_multi_selectTag\"]")));
        checkbox.click();
        
        //save the tag
        WebElement savechanges1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"loadTags()\"]")));
        savechanges1.click();
        
        //update button for complaint
        WebElement update=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"btnUpdateClickSave\"]")));
        update.click();
        
//        //to assure updated or not
//        WebElement assureupdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(), \"Updated by \")]")));
//     // Check if the element is displayed and contains the desired text
//        if (assureupdate.isDisplayed() && assureupdate.getText().contains("Updated by")) {
//            System.out.println("Update message is displayed: " + assureupdate.getText());
//        } else {
//            System.out.println("Update message is not displayed or does not match.");
//        }
        
	}
}
