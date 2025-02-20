package pages;

import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UpdateLinkTestCase6 {
	WebDriver driver;
	public UpdateLinkTestCase6(WebDriver driver)
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
  
  @FindBy(xpath="//button[normalize-space()='Update']")WebElement update;
  //elements of link update form
  @FindBy(xpath="//input[@placeholder='Enter Link Link']")WebElement linkname;
  @FindBy(xpath="//select[@id='ticket_type_select_comp']")WebElement servicetype;
  @FindBy(xpath="//select[@id='status']")WebElement status;
  @FindBy(xpath="//input[@id='34_cusID']")WebElement circuitID;
  @FindBy(xpath="//input[@id='25_cusID']")WebElement custID;
  @FindBy(xpath="//input[@id='35_cusID']")WebElement cpno;
  @FindBy(xpath="//button[@id='tree_menu_sel_but_1']")WebElement customerorganisation;
  @FindBy(xpath="//input[@name='24_cusID']")WebElement customername;
  @FindBy(xpath="//input[@name='49_cusID']")WebElement sla;
  @FindBy(xpath="//input[@name=\"10_cusID\"]")WebElement wanip;
  @FindBy(xpath="//input[@name='48_cusID']")WebElement terminationnumber;
  @FindBy(xpath="//input[@name=\"19_cusID\"]")WebElement portdetails_a;
  @FindBy(xpath="//input[@name=\"20_cusID\"]")WebElement portdetails_b;
  @FindBy(xpath="//select[@id=\"27_cusID\"]")WebElement region_fromdropdown;
  @FindBy(xpath="//select[@id=\"28_cusID\"]")WebElement region_todropdown;
  @FindBy(xpath="//input[@name=\"1_cusID\"]")WebElement link_from;
  @FindBy(xpath="//input[@name=\"2_cusID\"]")WebElement link_to;
  @FindBy(xpath="//select[@id=\"5_cusID\"]")WebElement handover_connectivitydropdown;
  @FindBy(xpath="//select[@id=\"8_cusID\"]")WebElement ckt_mediatypedropdown;
  @FindBy(xpath="//input[@id=\"4_cusID\"]")WebElement capacity;
  @FindBy(xpath="//select[@id=\"6_cusID\"]")WebElement uom_capacity;
  @FindBy(xpath="//input[@name=\"55_cusID\"]")WebElement remarks;



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
	public void clickUpdate(String updatelinkname,String srvcetype,String statusoflink,String cktID,String customerId,String cpnumber,String customerorganisationoption,String custname,String slafield,String wanipfield,String termntnnumber,String portdetail_a,String portdetail_b,String region_from,String region_to,String linkfrom,String linkto,String handoverconnectivity,String cktmediatype,String capacityfield,String uomcapacity,String remark,String time) throws InterruptedException
	{
		
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
		    
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", update);
//		update.click();
		
		    JavascriptExecutor js=(JavascriptExecutor) driver;
		//Editing Update form
		js.executeScript("arguments[0].scrollIntoView(true)", linkname);
		linkname.clear();
		linkname.sendKeys(updatelinkname);
		js.executeScript("arguments[0].scrollIntoView(true)", servicetype);
		Select select=new Select(servicetype);
		select.selectByVisibleText(srvcetype);
		js.executeScript("arguments[0].scrollIntoView(true)", status);
		Select selectstatus=new Select(status);
		selectstatus.selectByVisibleText(statusoflink);
//		js.executeScript("arguments[0].scrollIntoView(true)", circuitID);
//		System.out.println("cktid"+cktID);
//		//circuitID.sendKeys(cktID);
//		Actions actions = new Actions(driver);
//		// **1️⃣ Clear the field using JavaScript**
//		js.executeScript("arguments[0].value='';", circuitID);
//		System.out.println("Cleared circuitID field");
//		actions.moveToElement(circuitID).click().sendKeys(Keys.chord(Keys.CONTROL, "a"), cktID).build().perform();
		int retries = 6;
		while (retries > 0) {
		    try {
		WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		WebElement circuitID = waitt.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='34_cusID']")));

		// ✅ Click the field to focus
		circuitID.click();
		System.out.println("clicked cktid");

		// ✅ Clear using JavaScript
		jss.executeScript("arguments[0].value = '';", circuitID);
		System.out.println("cleared cktid");
		// ✅ Clear using sendKeys
		circuitID.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		System.out.println("cleared cktid");


		// ✅ Re-enter new value
		String newCircuitID = "H1234XYZ789";
		circuitID.sendKeys(newCircuitID);
		System.out.println("reenterd new cktid");

		// ✅ Trigger change event
		jss.executeScript("arguments[0].dispatchEvent(new Event('change'));", circuitID);

		// ✅ Click outside to confirm value change
		WebElement anotherElement = driver.findElement(By.xpath("//label[contains(text(),'Circuit ID')]"));
		anotherElement.click();
		System.out.println("confirmed new cktid");

		// ✅ Verify new value
		String updatedValue = circuitID.getAttribute("value");
		System.out.println("✅ Final Circuit ID: " + updatedValue);
		break;  // Exit the loop if successful
		    } catch (StaleElementReferenceException e) {
		        retries--;
		        if (retries == 0) {
		            throw e;  // If retries are exhausted, rethrow the exception
		        }
		        WebDriverWait waite = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement circuitID = waite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='34_cusID']")));
		    }
		}
		js.executeScript("arguments[0].scrollIntoView(true)", custID);
		custID.clear();
		custID.sendKeys(customerId);
		
		//CP NO
		js.executeScript("arguments[0].scrollIntoView(true)", cpno);
		cpno.clear();
		cpno.sendKeys(cpnumber);
		
		//customer organiztion
		js.executeScript("arguments[0].scrollIntoView(true)", customerorganisation);
		customerorganisation.click();
		


		String targetItem = customerorganisationoption; // Change this based on your need

		// Find all elements
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='jstree-children']//a[@class='jstree-anchor']"));

		System.out.println("Total options found: " + options.size());

		// Loop through the list
		for (WebElement option : options) {
		    if (option.getText().trim().equals(targetItem)) {
		        System.out.println("Found: " + option.getText());
		        option.click(); // Click on the matching item
		        break; // Stop once found
		    }
		}
		
		//customername 
		js.executeScript("arguments[0].scrollIntoView(true)", customername);
		customername.clear();
		customername.sendKeys(custname);
		
//wait for calender
	    	    
	    
	    WebDriverWait waitc = new WebDriverWait(driver, Duration.ofSeconds(30));

	 // Wait for the calendar icon and click it
	 WebElement calendarIcon = waitc.until(ExpectedConditions.presenceOfElementLocated(
	     By.xpath("(//span[@class='fa fa-calendar icon-green'])[2]")
	 ));
	 calendarIcon.click();

	 // Wait for the calendar table to load
	 WebElement calendarTable = waitc.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("//table[contains(@class, 'table-condensed')]")
	 ));

	 // Debug: Print all dates
	 List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td"));
	 for (WebElement date : dates) {
	     System.out.println("Date: " + date.getText() + ", Classes: " + date.getAttribute("class"));
	 }

	 // Wait for today's date and interact with it
	 WebElement todayDate = waitc.until(ExpectedConditions.elementToBeClickable(
	     By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td[contains(@class, 'today') and contains(@class, 'day')]")
	 ));
	 JavascriptExecutor jds = (JavascriptExecutor) driver;
	 jds.executeScript("arguments[0].scrollIntoView(true);", todayDate);
	 jds.executeScript("arguments[0].click();", todayDate);

	//clockpicker 
		 WebElement clockpicker1=waitc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='42_cusIDT']")));
		 clockpicker1.clear();
		 clockpicker1.sendKeys(time);

		
		//sla
				js.executeScript("arguments[0].scrollIntoView(true)", sla);
				sla.clear();
				sla.sendKeys(slafield);
				
		//wanip
				
				js.executeScript("arguments[0].scrollIntoView(true)", wanip);
				wanip.clear();
				wanip.sendKeys(wanipfield);
				
		//terminationnumber
				WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
				JavascriptExecutor jss = (JavascriptExecutor) driver;
				WebElement terminationnumber = waitt.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='48_cusID']")));
				jss.executeScript("arguments[0].scrollIntoView(true)", terminationnumber);
				terminationnumber.clear();
				terminationnumber.sendKeys(termntnnumber);
		//portdetailsA
				
				js.executeScript("arguments[0].scrollIntoView(true)", portdetails_a);
				portdetails_a.clear();
				portdetails_a.sendKeys(portdetail_a);
				
	 //portdetailsB
				
				js.executeScript("arguments[0].scrollIntoView(true)", portdetails_b);
				portdetails_b.clear();
				portdetails_b.sendKeys(portdetail_b);
				
				
	//regionfrom dropdown
				js.executeScript("arguments[0].scrollIntoView(true)", region_fromdropdown);
				region_fromdropdown.click();
				Select select_regiondropdown=new Select(region_fromdropdown);
			
				select_regiondropdown.selectByVisibleText(region_from);
				
	//regionto dropdown
				js.executeScript("arguments[0].scrollIntoView(true)", region_todropdown);
				region_todropdown.click();
				Select select_todropdown=new Select(region_todropdown);
			
				select_todropdown.selectByVisibleText(region_to);
   //link_from
				
				js.executeScript("arguments[0].scrollIntoView(true)", link_from);
				link_from.clear();
				link_from.sendKeys(linkfrom);	
				
	//link_to
				
				js.executeScript("arguments[0].scrollIntoView(true)", link_to);
				link_to.clear();
				link_to.sendKeys(linkto);	
				
	//handover_connectivity dropdown
				js.executeScript("arguments[0].scrollIntoView(true)", handover_connectivitydropdown);
				handover_connectivitydropdown.click();
				Select select_connectivitydropdown=new Select(handover_connectivitydropdown);
				select_connectivitydropdown.selectByVisibleText(handoverconnectivity);
				
	//cktmediatype dropdown
				js.executeScript("arguments[0].scrollIntoView(true)", ckt_mediatypedropdown);
				ckt_mediatypedropdown.click();
				Select select_cktmediatypedropdown=new Select(ckt_mediatypedropdown);
				select_cktmediatypedropdown.selectByVisibleText(cktmediatype);
				
   //capacity
				
				js.executeScript("arguments[0].scrollIntoView(true)", capacity);
				capacity.clear();
				capacity.sendKeys(capacityfield);	
				
 //uom_capacity dropdown
				js.executeScript("arguments[0].scrollIntoView(true)", uom_capacity);
				uom_capacity.click();
				Select select_uom_capacity=new Select(uom_capacity);
				select_uom_capacity.selectByVisibleText(uomcapacity);
				
//remarks
				
				js.executeScript("arguments[0].scrollIntoView(true)", remarks);
				remarks.clear();
				remarks.sendKeys(remark);	
 
				
 
				
				
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
		public void observerTagUpdate()
		{
			
		    //tag button
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement tags=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space(text())='Tags'])[1]")));
		    JavascriptExecutor jtag = (JavascriptExecutor) driver;
		    jtag.executeScript("arguments[0].scrollIntoView(true);", tags);
	        tags.click();
	        
	        //checkbox for tag
	        WebElement checkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"my_multi_selectTag\"]")));
	        checkbox.click();
	        
	        //save the tag
	        WebElement savechanges=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"loadTags()\"]")));
	        savechanges.click();
	        
	        //update button for complaint
	        WebElement update=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"btnUpdateClickSave\"]")));
//	        Actions action=new Actions(driver);
//	        action.moveToElement(update).click().perform();
//	        //update.click();
	        
	        
	     // Use JavaScript to force the click if normal click fails
	        try {
	            Actions action = new Actions(driver);
	            action.moveToElement(update).click().perform();
	            System.out.println("Clicked using Actions class");
	        } catch (Exception e) {
	            System.out.println("Actions click failed, trying JavaScript click");
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", update);
	        }
	        
	        //to assure updated or not
	        WebElement assureupdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(), 'Updated by')]")));
	     // Check if the element is displayed and contains the desired text
	        if (assureupdate.isDisplayed() && assureupdate.getText().contains("Updated by")) {
	            System.out.println("Update message is displayed: " + assureupdate.getText());
	        } else {
	            System.out.println("Update message is not displayed or does not match.");
	        }
	        
		}
}
