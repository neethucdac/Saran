package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ComparisonofUserTestCase10 {
	WebDriver driver;
	public ComparisonofUserTestCase10(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='userName']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[normalize-space(text())='Login']")WebElement login;
	@FindBy(xpath = "//img[@class=\"logo-default\"]")WebElement dashboard;
	public ComparisonofUserTestCase10 enterUsername(String usernamefield)
	{
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("(usernamefield"+usernamefield);
		username.sendKeys(usernamefield);
		return this;
	}
	public ComparisonofUserTestCase10 enterPassword(String passwordfield)
	{
		password.sendKeys(passwordfield);
		return this;
	}
	public Homepage clickLogin()
	{
		
		login.click();
		return new Homepage(driver);
	}
	public boolean isdashboarddisplayed() { 
		 
 		return dashboard.isDisplayed(); 
 	} 
	public void ensureAdminisAbsent()
	{
		List<WebElement> elements = driver.findElements(By.xpath("(//span[@class='fa fa-institution'])[1]"));

		if (elements.isEmpty()) {
		    System.out.println("Element is NOT present. Test Passed.");
		} else {
		    System.out.println("Element is present. Test Failed.");
		    Assert.fail("Admin menu should NOT be present, but it is.");
		}

	}

}
