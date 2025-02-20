package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlternateEmailFeatureTestCase18 {
	WebDriver driver;
	public AlternateEmailFeatureTestCase18(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class=\"fa fa-institution\"]")WebElement admin;
	@FindBy(xpath = "(//span[@class=\"fa fa-cogs\"])[2]")WebElement system;
	
	public void clickAdmin()
	{
		admin.click();
	}
	public void clickSystem()
	{
		system.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Email/SMS Settings']")));
		email.click();
	}
	public void verifyEmailSettings()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement assureemailheading=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"caption-subject font-green-steel bold\"]")));
		Assert.assertTrue(assureemailheading.isDisplayed());
		WebElement assureemailform=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class=\"form-horizontal\"]")));
		Assert.assertTrue(assureemailform.isDisplayed());
	}
	public void ensureAlternateEmailfeature()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement assurealternateemail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"alternateCCEmails\"]")));
		Assert.assertTrue(assurealternateemail.isDisplayed());
		
	}

}
