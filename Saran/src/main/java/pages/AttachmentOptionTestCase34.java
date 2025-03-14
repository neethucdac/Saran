package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AttachmentOptionTestCase34 {
	WebDriver driver;

	public AttachmentOptionTestCase34(WebDriver driver) {
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
	
	//class for uploading file
			public void robotclassforWord() throws AWTException
			{

			    String currenturl=driver.getCurrentUrl();
			    System.out.println(currenturl);

				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement addfile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));
				addfile.click();
				WebElement choosefile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_1\"]")));
				choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\test.txt");
//				WebElement description=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control input-sm\"]")));
//				description.sendKeys(descriptionforupdate);

				
			}
			
			public void robotclassforPDF() throws AWTException
			{

			    String currenturl=driver.getCurrentUrl();
			    System.out.println(currenturl);

				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement addfile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));
				 // Scroll into view
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addfile);

			    // Click using JavaScript
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addfile);
				//addfile.click();
				WebElement choosefile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_2\"]")));
				choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\Analysis.pdf");
				
				//WebElement uploadedFileText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFileName"))); // Replace with actual ID
				String fileName = choosefile.getText();
				System.out.print("fileName");
//				Assert.assertTrue(fileName.contains("Analysis.pdf"), "❌ File upload failed!");
//				System.out.println("✅ File uploaded successfully: " + fileName);

//				WebElement description=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"form-control input-sm\"]")));
//				description.sendKeys(descriptionforupdate);

				
			}
			public void robotclassforPaint() throws AWTException
			{

			    String currenturl=driver.getCurrentUrl();
			    System.out.println(currenturl);

				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement addfile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));

			    // Scroll into view
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addfile);

			    // Click using JavaScript
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addfile);
				//addfile.click();
				WebElement choosefile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_3\"]")));
				choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\image003.jpg");
				
				//WebElement uploadedFileText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFileName"))); // Replace with actual ID
				String fileName = choosefile.getText();
				System.out.print("fileName");
			}

			public void robotclassforExcel() throws AWTException
			{

			    String currenturl=driver.getCurrentUrl();
			    System.out.println(currenturl);

				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement addfile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"addFile\"]")));

			    // Scroll into view
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addfile);

			    // Click using JavaScript
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addfile);
				//addfile.click();
				WebElement choosefile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fileUpload_4\"]")));
				choosefile.sendKeys("C:\\Users\\Neethu\\Downloads\\integration.xlsx");
				
				//WebElement uploadedFileText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFileName"))); // Replace with actual ID
				String fileName = choosefile.getText();
				System.out.print("fileName");
			}



}
