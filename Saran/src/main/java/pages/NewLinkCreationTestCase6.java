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

public class NewLinkCreationTestCase6 {
	WebDriver driver;

	public NewLinkCreationTestCase6(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[@class=\"fa fa-file-text-o\"])[2]")
	WebElement link;
	@FindBy(xpath = "//input[@name=\"title\"]")
	WebElement title;
	@FindBy(xpath = "//select[@id=\"ticket_type_select_comp\"]")
	WebElement servicetype;
	// @FindBy(xpath="//input[@name=\"34_cusID\"]")WebElement cktid;
	@FindBy(xpath = "//input[@name=\"35_cusID\"]")
	WebElement cpno;
	@FindBy(xpath = "//input[@name='24_cusID']")
	WebElement customername;
//	@FindBy(xpath = "//input[@name=\"10_cusID\"]")
//	WebElement wanip;

	//@FindBy(xpath = "//input[@name=\"49_cusID\"]")
	//WebElement sla;

	@FindBy(xpath = "//input[@name=\"19_cusID\"]")
	WebElement portdetails_a;
	@FindBy(xpath = "//input[@name=\"20_cusID\"]")
	WebElement portdetails_b;
	@FindBy(xpath = "//select[@id=\"27_cusID\"]")
	WebElement region_fromdropdown;
	@FindBy(xpath = "//select[@id=\"28_cusID\"]")
	WebElement region_todropdown;
	@FindBy(xpath = "//input[@name=\"1_cusID\"]")
	WebElement link_from;
	@FindBy(xpath = "//input[@name=\"2_cusID\"]")
	WebElement link_to;
	@FindBy(xpath = "//select[@id=\"5_cusID\"]")
	WebElement handover_connectivitydropdown;
	@FindBy(xpath = "//select[@id=\"8_cusID\"]")
	WebElement ckt_mediatypedropdown;
	@FindBy(xpath = "//input[@id=\"4_cusID\"]")
	WebElement capacity;
	@FindBy(xpath = "//select[@id=\"6_cusID\"]")
	WebElement uom_capacity;
	@FindBy(xpath = "//input[@name=\"55_cusID\"]")
	WebElement remarks;

	public void newLink() throws InterruptedException {
		link.click();

		// Wait for the page to fully load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

		// Wait for the table to load
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ticketsTable")));

		JavascriptExecutor jsscrolldown = (JavascriptExecutor) driver;
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
		JavascriptExecutor jsfind = (JavascriptExecutor) driver;
		WebElement newlink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"fa fa-ticket-add\"])[3]")));

		jsfind.executeScript("arguments[0].scrollIntoView(true)", newlink);
		newlink.click();

	}

	public void newLink(String titlefield, String servicetypefield, String circuitid, String custid, String cpnumber,
			String customrgvalue, String custname, String wanipfield, String slafield, String portdetail_a,
			String portdetail_b, String region_from, String region_to, String linkfrom, String linkto,
			String handoverconnectivity, String cktmediatype, String capacityfield, String uomcapacity, String remark,
			String time, String linkcommisiongdate) throws InterruptedException {
		// newlink.click();
		// Thread.sleep(2000); // TEMP: Give time for unexpected navigation

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for an element specific to the New Link page
		WebElement newLinkHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(" (//span[normalize-space(text())='Create Link'])[2]")));

		AssertJUnit.assertTrue(newLinkHeader.isDisplayed());
		title.click();
		title.sendKeys(titlefield);

		// servicetype
		servicetype.click();
		Select select = new Select(servicetype);
		select.selectByVisibleText(servicetypefield);

		// circuitid
		WebElement cktid = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("34_cusID")));

		Actions actions = new Actions(driver);
		actions.click(cktid).pause(500).sendKeys(circuitid).build().perform();

		// customerid

		WebElement freshCustomerId = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='25_cusID']")));
		Actions actions1 = new Actions(driver);
		actions1.click(freshCustomerId).pause(500).sendKeys(custid).build().perform();

		// cp no
		WebElement cpno = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='35_cusID']")));
		cpno.click();
		cpno.sendKeys(cpnumber);
		
		
		//customer organisation
		 WebElement customerorganisation = new WebDriverWait(driver, Duration.ofSeconds(10))
                   .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id=\"tree_menu_sel_but_1\"]")));
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
	    

//	 // 
//		 
		 
		// Wait for the terminationcalendar icon and click it
		    WebDriverWait waitc=new WebDriverWait(driver, Duration.ofSeconds(30));
			 WebElement calendarIcon1 = waitc.until(ExpectedConditions.presenceOfElementLocated(
			     By.xpath("//input[@name=\"42_cusID\"]")
			 ));
			 calendarIcon1.click();
			 calendarIcon1.sendKeys(linkcommisiongdate);
			 
			//clockpicker  for terminationcalender
			 WebElement clockpicker2=waitc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='42_cusIDT']")));
			 clockpicker2.clear();
			 clockpicker2.click();
			 clockpicker2.sendKeys(time);
			 
			 
			// Wait for the terminationcalendar icon and click it
			    //WebDriverWait waitc=new WebDriverWait(driver, Duration.ofSeconds(30));
				 WebElement calendartermntn = waitc.until(ExpectedConditions.presenceOfElementLocated(
				     By.xpath("//input[@name='18_cusID']")
				 ));
				 calendartermntn.click();
				 calendartermntn.sendKeys(linkcommisiongdate);
				 
			 
			//clockpicker for link commission
			 WebElement clcklinkcommission=waitc.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='18_cusIDT']")));
			 clcklinkcommission.clear();
			 clcklinkcommission.sendKeys(time);
			 WebElement outsideElement = driver.findElement(By.xpath("//div[@class='page-container']")); // Update XPath
			 outsideElement.click();
//			 WebElement wanip = waitc.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='10_cusID']")));
//
//			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wanip);
//			 Thread.sleep(500); // Allow time for scrolling
//
//			 wanip.click();
//			 wanip.sendKeys(wanipfield);
			 
			 
			 Actions actionss = new Actions(driver);
			 WebElement wanip = waitc.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='10_cusID']")));
			 System.out.printf("wanipfield",wanipfield);
			 actionss.moveToElement(wanip).click().sendKeys(wanipfield).build().perform();



//			 		 WebElement wanip = waitc.until(ExpectedConditions.presenceOfElementLocated(
//			 		     By.xpath("//input[@name='10_cusID']")));		    
//			 		     
//			wanip.click();
//		    wanip.sendKeys(wanipfield);
//		    
//		    //SLA
		    
		    WebElement sla = waitc.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='49_cusID']")));
			actionss.moveToElement(sla).click().sendKeys(slafield).build().perform();

//			 //portdetailsA
		
			 JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", portdetails_a);
				portdetails_a.clear();
				portdetails_a.sendKeys(portdetail_a);
				
//	 //portdetailsB
				
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
				
	//handover_connectivity dropdown
				js.executeScript("arguments[0].scrollIntoView(true)", handover_connectivitydropdown);
				handover_connectivitydropdown.click();
				Select select_connectivitydropdown=new Select(handover_connectivitydropdown);
				select_connectivitydropdown.selectByVisibleText(handoverconnectivity);
				
	//link_from
				
				js.executeScript("arguments[0].scrollIntoView(true)", link_from);
				link_from.clear();
				link_from.sendKeys(linkfrom);	
				
	//link_to
				
				js.executeScript("arguments[0].scrollIntoView(true)", link_to);
				link_to.clear();
				link_to.sendKeys(linkto);	
				
				
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
	
	// class for uploading file
		public void robotclass(String descriptionforupdate) throws AWTException {

			String currenturl = driver.getCurrentUrl();
			System.out.println(currenturl);
			for (int i = 0; i < 3; i++) { // Try up to 3 times
				try {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					WebElement addfile = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));
					// addfile.click();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", addfile);
					WebElement choosefile = wait.until(
							ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_1\"]")));
					choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\test.txt");
					WebElement description = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control input-sm\"]")));
					description.sendKeys(descriptionforupdate);
					return; // Exit loop if successful
				} catch (StaleElementReferenceException e) {
					System.out.println("Retrying due to stale element... Attempt " + (i + 1));
				}
			}

		}

		// class for observertagupdate buttons
		public void observerTagUpdate() {

			// tag button
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement tags = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Tag']")));
			JavascriptExecutor jtag = (JavascriptExecutor) driver;
			jtag.executeScript("arguments[0].scrollIntoView(true);", tags);
			tags.click();

			// checkbox for tag
			WebElement checkbox = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"my_multi_selectTag\"]")));
			checkbox.click();

			// save the tag
			WebElement savechanges = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"loadTags()\"]")));
			savechanges.click();

			// update button for complaint
			WebElement save = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnSave']")));
//			        Actions action=new Actions(driver);
//			        action.moveToElement(update).click().perform();
//			        //update.click();
			save.click();

		}

	}

