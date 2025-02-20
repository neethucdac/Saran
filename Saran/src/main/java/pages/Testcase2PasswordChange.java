package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase2PasswordChange {
	WebDriver driver;
	public Testcase2PasswordChange(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='username username-hide-mobile']") WebElement adminheading;
	@FindBy(xpath = "//i[@class='icon-tag']")WebElement preference;
	@FindBy(xpath = "//input[@name='oldPassword']")WebElement currentPassword;
	@FindBy(xpath = "//input[@name='newPassword']")WebElement newPassword;
	@FindBy(xpath = "//input[@name='retypePassword']")WebElement renewpassword;
	@FindBy(xpath = "//button[@class='btn blue']")WebElement submit;
	@FindBy(xpath = "//span[normalize-space(text())='Password Changed Successfully']")WebElement passwordsuccess;
	public void clickAdminheading()
	{
		adminheading.click();
		
	}
	public void clickPreference()
	{
		preference.click();
	}
	
	public void oldPassword(String passwordfield)
	{
		currentPassword.click();
		currentPassword.sendKeys(passwordfield);
	}
	public void newPassword(String newpassword)
	{
		newPassword.click();
		newPassword.sendKeys(newpassword);
	}
	public void reenterNewPassword(String newpassword)
	{
		renewpassword.click();
		renewpassword.sendKeys(newpassword);
	}
	public void clickSubmit()
	{
		submit.click();
	}
	public boolean ispasswordsuccessdisplayed() { 
		driver.switchTo().frame("fileUploadTarget");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Password Changed Successfully']")));

 		return passwordsuccess.isDisplayed(); 
 	} 

}
