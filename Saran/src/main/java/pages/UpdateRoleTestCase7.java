package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateRoleTestCase7 {
	WebDriver driver;
	public UpdateRoleTestCase7(WebDriver driver)
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
	}
//	public void updateRole(String roleName) {
//	    List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'rolesTable')]/tbody/tr"));
//	    
//	    boolean found = false;
//
//	    for (WebElement row : rows) {
//	        // Locate the second column (role name)
//	        WebElement roleElement = row.findElement(By.xpath("./td[2]")); // Use './' to indicate relative search inside row
//	        String roleText = roleElement.getText().trim();
//	        System.out.println("Role Found: " + roleText);
//
//	        if (roleText.equalsIgnoreCase(roleName)) {
//	            found = true;
//	            // Locate the delete button within the same row
//	           roleElement.click();
//	            // Handle confirmation popup (if exists)
//	        }
//	    }
//	}
	
	public void updateRole(String roleName) {
	    List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'rolesTable')]/tbody/tr"));

	    boolean found = false;

	    for (WebElement row : rows) {
	        // Locate the role name link inside the second column
	        WebElement roleElement = row.findElement(By.xpath("./td[2]/a")); // Find the <a> inside <td[2]>
	        String roleText = roleElement.getText().trim();
	        System.out.println("Role Found: " + roleText);

	        if (roleText.equalsIgnoreCase(roleName)) {
	            found = true;
	            roleElement.click(); // Click the role name link
	            System.out.println("Clicked on role: " + roleName);
	            break; // Exit loop after clicking
	        }
	    }

	    if (!found) {
	        System.out.println("Role not found: " + roleName);
	    }
	}
public void editRole(String rolenamefield,String descrptn,String paret_role)
	
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement rolename=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"roleName\"]")));
		WebElement description=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"description\"]")));
		WebElement roleparent=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"roleParent\"]")));
		WebElement update=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Update']")));
		rolename.clear();
		rolename.sendKeys(rolenamefield);
		description.clear();
		description.sendKeys(descrptn);
		//roleparent.clear();
		roleparent.click();
		Select select=new Select(roleparent);
		select.selectByVisibleText(paret_role);
		update.click();
		WebElement assureupdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //span[normalize-space(text())='Role Updated Successfully']")));
		if(assureupdate.isDisplayed() && assureupdate.getText().contains("Role Updated Successfully"))
		{
			System.out.println("updated message is displayed: " + assureupdate.getText());
        } else {
            System.out.println("updated message is not displayed or does not match.");
        }
	}
	
}
