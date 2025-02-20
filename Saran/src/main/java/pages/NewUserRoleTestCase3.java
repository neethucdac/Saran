package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	user.click();
}
public void clickRole()
{
	role.click();
}
}
