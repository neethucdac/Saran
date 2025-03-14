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
import org.testng.AssertJUnit;

public class NewLinkTestCase6 {
	WebDriver driver;
	public NewLinkTestCase6(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[normalize-space()='Link'])[1]")WebElement link;
	@FindBy(xpath="//i[@class=\"glyphicon glyphicon-plus-sign\"]")WebElement newlink;
	@FindBy(xpath="//input[@name=\"title\"]")WebElement title;
	@FindBy(xpath="//select[@id=\"ticket_type_select_comp\"]")WebElement servicetype;
	//@FindBy(xpath="//input[@name=\"34_cusID\"]")WebElement cktid;
	@FindBy(xpath="//input[@name=\"35_cusID\"]")WebElement cpno;
	@FindBy(xpath="//input[@name='24_cusID']")WebElement customername;
	@FindBy(xpath="//input[@name=\"10_cusID\"]")WebElement wanip;
	
	@FindBy(xpath="//input[@name=\"49_cusID\"]")WebElement sla;
	
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
		// Wait for the page to fully load
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    waits.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	    
	}
	public void newLink(String titlefield,String servicetypefield,String circuitid,String custid,String cpnumber,String customrgvalue,String custname,String wanipfield,String slafield,String portdetail_a,String portdetail_b,String region_from,String region_to,String linkfrom,String linkto,String handoverconnectivity,String cktmediatype,String capacityfield,String uomcapacity,String remark,String time) throws InterruptedException
	{
		newlink.click();
		//Thread.sleep(2000); // TEMP: Give time for unexpected navigation

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		    // Wait for an element specific to the New Link page
		    WebElement newLinkHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//span[normalize-space(text())='Create Link'])[2]")));

		    AssertJUnit.assertTrue(newLinkHeader.isDisplayed());
		    title.click();
		    title.sendKeys(titlefield);
		    
		    //servicetype
		    servicetype.click();
		    Select select=new Select(servicetype);
		    select.selectByVisibleText(servicetypefield);
		    
		    //ckt id

		    
		    for (int i = 0; i < 3; i++) { // Try up to 3 times
		        try {
		            WebElement cktid = new WebDriverWait(driver, Duration.ofSeconds(10))
		                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='34_cusID']")));
		            
		            cktid.click();
		            cktid.sendKeys(custid);
		            return; // Exit loop if successful
		        } catch (StaleElementReferenceException e) {
		            System.out.println("Retrying due to stale element... Attempt " + (i + 1));
		        }
		    }
		  
		    
		    //customerid
		 // Wait for the customerid field before interacting

		    
		    
		    for (int i = 0; i < 3; i++) { // Try up to 3 times
		        try {
		            WebElement freshCustomerId = new WebDriverWait(driver, Duration.ofSeconds(10))
		                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='25_cusID']")));
		            
		            freshCustomerId.click();
		            freshCustomerId.sendKeys(custid);
		            return; // Exit loop if successful
		        } catch (StaleElementReferenceException e) {
		            System.out.println("Retrying due to stale element... Attempt " + (i + 1));
		        }
		    }
		    
		    //cp no
		    cpno.click();
			cpno.sendKeys(cpnumber);
			
			//customer organisation
			 WebElement customerorganisation = new WebDriverWait(driver, Duration.ofSeconds(10))
	                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tree_search_input_1']")));
			 customerorganisation.click();
			 String custorgvalue=customrgvalue;
			    List <WebElement> custorganisationoptions=driver.findElements(By.xpath("//ul[@class='jstree-children']//a"));
			    for(WebElement element:custorganisationoptions) 
				{ 
				if(element.getText().equals(custorgvalue)) 
				{ 
					System.out.println(element.getText());
					element.click();
					 
				} 
				} 
		    customername.click();
		    customername.sendKeys(custname);
		    //throw new RuntimeException("Failed to enter Customer ID after retries.");
		    
		    //WAN IP
		    wanip.click();
		    wanip.sendKeys(wanipfield);
		    
		    //SLA
		    sla.click();
		    sla.sendKeys(slafield);
		    
		    
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
			
			 
			 
			 
			 // Wait for the link commissioningcalendar icon and click it
			 WebElement calendarIcon1 = waitc.until(ExpectedConditions.presenceOfElementLocated(
			     By.xpath("(//span[@class='fa fa-calendar icon-green'])[1]")
			 ));
			 calendarIcon1.click();

			 // Wait for the calendar table to load
			 WebElement calendarTable1 = waitc.until(ExpectedConditions.visibilityOfElementLocated(
			     By.xpath("//table[contains(@class, 'table-condensed')]")
			 ));

			 // Debug: Print all dates
			 List<WebElement> dates1 = driver.findElements(By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td"));
			 for (WebElement date : dates1) {
			     System.out.println("Date: " + date.getText() + ", Classes: " + date.getAttribute("class"));
			 }

			 // Wait for today's date and interact with it
			 WebElement todayDate1 = waitc.until(ExpectedConditions.elementToBeClickable(
			     By.xpath("//table[contains(@class, 'table-condensed')]/tbody/tr/td[contains(@class, 'today') and contains(@class, 'day')]")
			 ));
			 JavascriptExecutor jdss = (JavascriptExecutor) driver;
			 jdss.executeScript("arguments[0].scrollIntoView(true);", todayDate1);
			 jdss.executeScript("arguments[0].click();", todayDate1);

			//clockpicker 
				 WebElement clockpicker2=waitc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='18_cusIDT']")));
				 clockpicker2.clear();
				 clockpicker2.sendKeys(time);
				//portdetailsA
			 
			 
			 
			 
			 
			 //portdetailsA
		
			 JavascriptExecutor js = (JavascriptExecutor) driver;
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
		    for (int i = 0; i < 3; i++) { // Try up to 3 times
		        try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement addfile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));
			//addfile.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", addfile);
			WebElement choosefile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_1\"]")));
			choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\test.txt");
			WebElement description=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control input-sm\"]")));
			description.sendKeys(descriptionforupdate);
			  return; // Exit loop if successful
		        } catch (StaleElementReferenceException e) {
		            System.out.println("Retrying due to stale element... Attempt " + (i + 1));
		        }
		    }
		  
			
		}	
		//class for observertagupdate buttons
			public void observerTagUpdate()
			{
				
			    //tag button
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			    WebElement tags=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Tag']")));
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
		        WebElement save=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnSave']")));
//		        Actions action=new Actions(driver);
//		        action.moveToElement(update).click().perform();
//		        //update.click();
		        save.click();
		        
		        
		     // Use JavaScript to force the click if normal click fails
//		        try {
//		            Actions action = new Actions(driver);
//		            action.moveToElement(save).click().perform();
//		            System.out.println("Clicked using Actions class");
//		        } catch (Exception e) {
//		            System.out.println("Actions click failed, trying JavaScript click");
//		            JavascriptExecutor js = (JavascriptExecutor) driver;
//		            js.executeScript("arguments[0].click();", save);
//		        }
		        
//		        //to assure updated or not
		        WebElement assuresave=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(.), 'Saved Successfully')]")));
		     // Check if the element is displayed and contains the desired text
		        if (assuresave.isDisplayed() && assuresave.getText().contains("Saved Successfully")) {
		            System.out.println("save message is displayed: " + assuresave.getText());
		        } else {
		            System.out.println("saved message is not displayed or does not match.");
		        }
		        
			}	   
	
		

}
