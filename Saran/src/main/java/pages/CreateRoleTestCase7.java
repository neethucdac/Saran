package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateRoleTestCase7 {
	WebDriver driver;
	public CreateRoleTestCase7(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class=\"fa fa-institution\"])[1]")WebElement admin;
	@FindBy(xpath = "(//span[@class=\"fa fa-user\"])[2]")WebElement usermenu;
	//@FindBy(xpath = "(//div[@class=\"note note-info\"])[1]")WebElement role;
	
	
	public void clickAdmin()
	{
		admin.click();
		usermenu.click();
		//role.click();
	}
	public void clickRole()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement role=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='note note-info']/a[contains(text(),'Role')]")));
		role.click();
		WebElement createrole=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add']/i[contains(@class, 'glyphicon-plus-sign')]")));
		createrole.click();

	}
	public void createRole(String rolenamefield,String descrptn,String paret_role)
	
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement rolename=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"roleName\"]")));
		WebElement description=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"description\"]")));
		WebElement roleparent=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"roleParent\"]")));
		WebElement save=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
		
		rolename.sendKeys(rolenamefield);
		description.sendKeys(descrptn);
		roleparent.click();
		Select select=new Select(roleparent);
		select.selectByVisibleText(paret_role);
		save.click();
		WebElement assuresave=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Role Saved Successfully']")));
		if(assuresave.isDisplayed() && assuresave.getText().contains("Role Saved Successfully"))
		{
			System.out.println("save message is displayed: " + assuresave.getText());
        } else {
            System.out.println("saved message is not displayed or does not match.");
        }
	}

}
