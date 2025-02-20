package pages;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeeklyReportTestCase21 {
	WebDriver driver;
	public WeeklyReportTestCase21(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class=\"fa fa-file-pdf-o\"])[1]")WebElement report;
	public void clickrReport()
	{
		report.click();
	}
	public void generateWeeklyReport(String profilefield,String compltype,String categoryfield,String statusvalue,String assigneevalue,String selectcreateduserfield,String reportformatfield,String choosefilterfield,String title)
	{
		WebElement profile=driver.findElement(By.xpath("//select[@id=\"profileID\"]"));
		Select select=new Select(profile);
		select.selectByVisibleText(profilefield);
		WebElement complainttype=driver.findElement(By.xpath("//select[@id=\"type\"]"));
		complainttype.click();
		Select selectcomplainttype=new Select(complainttype);
		selectcomplainttype.selectByVisibleText(compltype);
		WebElement radiobutton=driver.findElement(By.xpath("//input[@id=\"last7Days\"]"));
		radiobutton.click();
		WebElement category=driver.findElement(By.xpath("//select[@id=\"category\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", category);
		//category.click();
		Select selectcategory=new Select(category);
		selectcategory.selectByVisibleText(categoryfield);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//input[@type='checkbox' and @value='"+statusvalue+"']")
		));
		js.executeScript("arguments[0].click();", checkbox);
		WebElement assignee=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"assignee\"]")));
		Select selectassignee=new Select(assignee);
		selectassignee.selectByVisibleText(assigneevalue);
		
		WebElement createduser=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"createdUser\"]")));
		Select selectcreateduser=new Select(createduser);
		selectcreateduser.selectByVisibleText(selectcreateduserfield);
		
		WebElement reportformat=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"reportFormat\"]")));
		Select selectreportformat=new Select(reportformat);
		selectreportformat.selectByVisibleText(reportformatfield);
		
		
		
		WebElement advancefilter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"chkboxAdncdFiltr\"]")));
		advancefilter.click();
		
		
		WebElement choosefilter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"dateFilterType\"]")));
		Select selectchoosefilter=new Select(choosefilter);
		selectchoosefilter.selectByVisibleText(choosefilterfield);
		
		//Title--filtered TITLE
		WebElement choosefiltertitle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"Title\"]")));
		choosefiltertitle.sendKeys(title);
		
		
		
		

		WebElement generatereport=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Generate Report\"]")));
		generatereport.click();
		
	}

}
