package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewUserRoleTestCase3 {
	WebDriver driver;
	public NewUserRoleTestCase3 (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
//@FindBy(xpath = "(//span[contains(@class, 'fa fa-institution')])[2]")WebElement admin;
@FindBy(xpath = "(//span[@class='fa fa-institution'])[1]")WebElement admin;
	
@FindBy(xpath="(//span[@class='fa fa-user'])[2]")WebElement user;
@FindBy(xpath = "//a[@onclick='listRoles()']")WebElement role;


public void clickAdmin()
{
	admin.click();
	
}
public void clickUser()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	WebElement user=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='fa fa-user'])[2]")));
	Actions action=new Actions(driver);
	action.click(user).perform();
	
}
public void clickRole()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	WebElement user=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@onclick='listRoles()']")));
	Actions action=new Actions(driver);
	action.click(role).perform();
}
}
