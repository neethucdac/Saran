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

public class LinkListingTestCase6 {
	WebDriver driver;
	public LinkListingTestCase6(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[normalize-space()='Link'])[1]")WebElement link;
	public void clickLink()
	{
		link.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement linklist=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Link List'])[1]")));
		Assert.assertTrue(linklist.isDisplayed(), "LinkLiST NOT DISPLAYED");
	}

}
