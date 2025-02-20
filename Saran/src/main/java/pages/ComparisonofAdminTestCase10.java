package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparisonofAdminTestCase10 {
	WebDriver driver;
	public ComparisonofAdminTestCase10(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void adminMenuExist()
	{
		WebElement adminassure=driver.findElement(By.xpath("(//span[@class='fa fa-institution'])[1]"));
//		String admin=adminassure.getText().trim();
//		System.out.println("STRING VALUE.."+admin);
		if(adminassure.isDisplayed())
		{
			System.out.println("Success");
		}
	}
}
