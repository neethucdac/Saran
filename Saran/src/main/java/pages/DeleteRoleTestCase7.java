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
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteRoleTestCase7 {
	WebDriver driver;
	public DeleteRoleTestCase7(WebDriver driver)
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

	public void deleteRole(String roleName) {
	    List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id,'rolesTable')]/tbody/tr"));
	    
	    boolean found = false;

	    for (WebElement row : rows) {
	        // Locate the second column (role name)
	        WebElement roleElement = row.findElement(By.xpath("./td[2]")); // Use './' to indicate relative search inside row
	        String roleText = roleElement.getText().trim();
	        System.out.println("Role Found: " + roleText);

	        if (roleText.equalsIgnoreCase(roleName)) {
	            found = true;
	            // Locate the delete button within the same row
	            WebElement deleteButton = row.findElement(By.xpath("./td[last()]/a[contains(@onclick,'deleteSelectedRole')]"));
	            deleteButton.click();
	            System.out.println("Deleted role: " + roleName);
	            // Handle confirmation popup (if exists)
            try {

            	Alert alert = driver.switchTo().alert();
            	alert.accept();
            } catch (Exception e) {
                System.out.println("No confirmation popup found.");
            }

            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Role not found: " + roleName);
	    }
	}
	

}


