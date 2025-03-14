package pages;

import java.awt.AWTException;
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

public class NewTicketTestCase5 {
	WebDriver driver;

	public NewTicketTestCase5(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='fa fa-file-text-o'])[1]")
	WebElement complaint;
	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement comment;
	@FindBy(xpath = "//select[@name=\"assignee\"]")
	WebElement assigneedropdown;
	@FindBy(xpath = "//select[@name='cat']")
	WebElement complaintcategory;
	@FindBy(xpath = "//select[@name=\"priority\"]")
	WebElement priority;
	@FindBy(xpath = "//select[@name=\"source\"]")
	WebElement sourcetype;

	// @FindBy(xpath = "//select[@id='assignee']")WebElement assignee;
	public void newTicket() throws InterruptedException {
		complaint.click();

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
		WebElement newcomplnt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"fa fa-ticket-add\"])[3]")));

		jsfind.executeScript("arguments[0].scrollIntoView(true)", newcomplnt);
		newcomplnt.click();

	}

	public void editnewTIcketform(String title, String complaintdescription, String assignee, String category,
			String complaintpriority, String source, String id, String teamdropdown,String esclregion,String escllocation,String reasonforoccurrence,String subreasonforoccurrence,String caller_name,String caller_email,String caller_mobile,String caller_landline) throws InterruptedException {
		// wait for complaint title
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement complainttiltle = driver.findElement(By.xpath("//input[@name=\"title\"]"));
		complainttiltle.sendKeys(title);

		// Wait for the iframe to be present
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("descriptionTextArea_ifr")));

		// Switch to the iframe
		driver.switchTo().frame(iframe);

		// Locate the body inside the iframe
		WebElement editorBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

		// Perform actions on the body (e.g., entering text)
		editorBody.clear(); // Optional: clear any existing text
		editorBody.sendKeys(complaintdescription);

		// Switch back to the main content
		driver.switchTo().defaultContent();

		// Wait for the dropdown to be visible before selecting the assignee
		WebElement assigneeDropdown = wait.until(ExpectedConditions.visibilityOf(assigneedropdown));
		Select select = new Select(assigneeDropdown);
		select.selectByVisibleText(assignee);

		Select comp_categorydropdown = new Select(complaintcategory);
		comp_categorydropdown.selectByVisibleText(category);

		Select priority_dropdown = new Select(priority);
		priority_dropdown.selectByVisibleText(complaintpriority);

		Select sourcetype_dropdown = new Select(sourcetype);
		sourcetype_dropdown.selectByVisibleText(source);

		// click select link
		WebDriverWait waitselectlink = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor jsscrolldown = (JavascriptExecutor) driver;
		WebElement selectlink = waitselectlink
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Select Link']")));
		jsscrolldown.executeScript("arguments[0].scrollIntoView(true);", selectlink);
		selectlink.click();

		// Wait for the page to fully load
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		waits.until(webDriver -> jss.executeScript("return document.readyState").equals("complete"));
		WebDriverWait waitForDynamicElement = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitForDynamicElement
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(text(),'Add')])[1]")));

		// Wait for titleid
		WebDriverWait waittitleid = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement titleId = waittitleid.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ticketGenericSearchInput']")));
		titleId.click();
		titleId.sendKeys(id);

////			    //wait for search
		WebDriverWait waitsearch = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement search = waitsearch.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Search']")));
		search.click();
		
	    //wait for radiobutton
	    WebDriverWait waitsino = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement serialno=waitsearch.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='ticketRadio']")));
	    serialno.click();
	    
	    //wait for add button
	    WebDriverWait waitadd = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement add=waitadd.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[normalize-space(text())='Add'])[1]")));
	    add.click();
	    
	    //driver.switchTo().alert().accept();//to click OK
	    
	    
	    //wait for technicalteam
//	    WebDriverWait waittechteam = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    WebElement techteam=waittechteam.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='selected tree_select_area'])[1]")));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", techteam);//scrolldown till the element is visible
//	    techteam.click();
	    
	    
	    WebDriverWait waittechteam = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	    WebElement techteam = waittechteam.until(
	        ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='selected tree_select_area'])[1]"))
	    );

	    // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", techteam);

	    // Click using JavaScript
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", techteam);

	    
	    //to select technicalteam from dropdown (dropdown doesnot contain select so using list elements are listed and using for loop checked the value from excelsheet with the dropdown)
	    String teamdropdownvalue=teamdropdown;
	    List <WebElement> teamdropdownoptions=driver.findElements(By.xpath("//ul[@class='jstree-children']//a"));
	    for(WebElement element:teamdropdownoptions) 
		{ 
		if(element.getText().equals(teamdropdownvalue)) 
		{ 
			System.out.println(element.getText());
			Thread.sleep(500);
			element.click();
			 
		} 
		}
	    
//	    String escalatedtovalue="ERTCC";
//	    WebDriverWait waitescalatedto = new WebDriverWait(driver, Duration.ofSeconds(30)); 
//	    WebElement escalatedto=waitescalatedto.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class=\"selected tree_select_area\"])[2]")));
//	    //escalatedto.click();
//	    // Scroll into view
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", escalatedto);
//
//	    // Click using JavaScript
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", escalatedto);
//	    JavascriptExecutor jst = (JavascriptExecutor) driver;
//	    List<WebElement> esclatedtooptions = driver.findElements(By.xpath("//ul[@class='jstree-container-ul jstree-children jstree-striped jstree-contextmenu']//a"));
//	    System.out.println("Number of options found: " + esclatedtooptions.size());
//
//	    // Iterate through options
//	    for (WebElement elements : esclatedtooptions) {
//	        // Use JavaScript to extract inner text
//	        String visibleText = (String) jst.executeScript("return arguments[0].innerText;", elements);
//	        System.out.println("Row text: " + visibleText.trim());
//
//	        // Check if this is the desired element
//	        if (visibleText.trim().equals(escalatedtovalue)) {
//	            System.out.println("Clicking: " + visibleText.trim());
//
////	            WebDriverWait waitForClick = new WebDriverWait(driver, Duration.ofSeconds(10));
////	            waitForClick.until(ExpectedConditions.elementToBeClickable(elements));
//	            
//	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", elements);
//	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elements);
//
////	            WebDriverWait waitee = new WebDriverWait(driver, Duration.ofSeconds(30));
////	            //WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='jstree-icon jstree-ocl'])[1]")));
////	            WebElement arrow = waitee.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@role='presentation'])[9]")));
////	         // Scroll into view
////	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrow);
////
////	            // Ensure it's visible and clickable
////	            wait.until(ExpectedConditions.elementToBeClickable(arrow));
////	            if (arrow.isDisplayed() && arrow.isEnabled()) {
////	                //arrow.click();
////	            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrow);
////
////	                WebDriverWait waiteee = new WebDriverWait(driver, Duration.ofSeconds(30));
////		            //WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='jstree-icon jstree-ocl'])[1]")));
////		            WebElement opt = waiteee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='AKUSINGH'])[1]")));
////		            opt.click();
////	            } else {
////	                System.out.println("Arrow is not visible or interactable.");
////	            }
////
////
////	            break;
//	            
//	            
//	            
//	            List<WebElement> elementss = driver.findElements(By.xpath("(//i[@role='presentation'])[9]"));
//	            if (!elementss.isEmpty()) {  // Check if the element is found
//	                WebElement arrow = elementss.get(0);
//	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrow);
//	                arrow.click();
//	            } else {
//	                System.out.println("Element not found, but continuing execution.");
//	            }
//
//
//	        }
//	    }
	    

	    
	    String escalatedtovalue=esclregion;
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
	            //WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@role='presentation'])[9]")));
	            WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '"+escalatedtovalue+"')]/preceding-sibling::i")));
	          
	            if (arrow.isDisplayed() && arrow.isEnabled()) {
	                arrow.click();
	                WebDriverWait waiteee = new WebDriverWait(driver, Duration.ofSeconds(30));
		            //WebElement arrow = waitee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='jstree-icon jstree-ocl'])[1]")));
		            WebElement opt = waiteee.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='"+escllocation+"'])[1]")));
		            opt.click();
	            } else {
	                System.out.println("Arrow is not visible or interactable.");
	            }


	            break;
	        }
	    }
	    
	  //clicking reason for occurrence
	  		WebDriverWait waitreasonoccu=new WebDriverWait(driver, Duration.ofSeconds(30));
	  		WebElement dropdown=waitreasonoccu.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='38_cusID']")));
	  		dropdown.click();
	  		Select selectdropdown=new Select(dropdown);
	  		selectdropdown.selectByVisibleText(reasonforoccurrence);
	  		
	  		
	  		WebElement subreasonoccurrence1=driver.findElement(By.xpath("//input[@id='54_cusID']"));
	  		subreasonoccurrence1.clear();
	  		subreasonoccurrence1.sendKeys(subreasonforoccurrence);
	  
	  		
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
//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//			WebElement observer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Observer']")));
			
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
		    WebElement tags=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space(text())='Tag'])[1]")));
		    JavascriptExecutor jtag = (JavascriptExecutor) driver;
		    jtag.executeScript("arguments[0].scrollIntoView(true);", tags);
	        tags.click();
	        
	        //checkbox for tag
	        WebElement checkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"my_multi_selectTag\"]")));
	        checkbox.click();
	        
	        //save the tag
	        WebElement savechanges1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"loadTags()\"]")));
	        savechanges1.click();
	        
	        //save button for complaint
	        WebElement save=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnSave']")));
	        save.click();
	        
//	        //to assure saved or not
//	        WebElement assureupdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(), \"Saved by \")]")));
//	     // Check if the element is displayed and contains the desired text
//	        if (assureupdate.isDisplayed() && assureupdate.getText().contains("Saved by")) {
//	            System.out.println("Save message is displayed: " + assureupdate.getText());
//	        } else {
//	            System.out.println("Save message is not displayed or does not match.");
//	        }
	        
		}

	}

