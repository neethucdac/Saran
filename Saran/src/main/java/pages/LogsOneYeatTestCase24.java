package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogsOneYeatTestCase24 {
	WebDriver driver;

	public LogsOneYeatTestCase24(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void clickAuditLog()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement admin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"fa fa-institution\"]")));
		admin.click();
		WebElement system = wait.until(ExpectedConditions.presenceOfElementLocated(
			    By.xpath("(//span[@class=\"fa fa-cogs\"])[2]")));
//		Actions action=new Actions(driver);
//		action.click(system).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", system);

		//system.click();
		WebElement auditlogs=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Audit Log')]")));
		auditlogs.click();
	}
	public void createLogForOneYear(String curmnth,String year,String month)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement custom =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='custom']")));
		custom.click();
		WebElement date=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='fromDate']")));
		date.click();
		WebElement currentmonth=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[normalize-space()='"+curmnth+"']")));
		currentmonth.click();
		WebElement clickArrow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//th[normalize-space()='2025'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickArrow);
		clickArrow.click();
		WebElement clickselectedYear=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='"+year+"'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickselectedYear);
		clickselectedYear.click();
		WebElement clickselectedmonth=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='"+month+"'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickselectedmonth);
		clickselectedmonth.click();
		
		
		
		
	}
	}


