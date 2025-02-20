package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageTestCase1 {
	WebDriver driver;
	public LoginpageTestCase1 (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	@FindBy(xpath="//input[@name='userName']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[normalize-space(text())='Login']")WebElement login;
	@FindBy(xpath = "//img[@class=\"logo-default\"]")WebElement dashboard;
	public LoginpageTestCase1 enterUsername(String usernamefield)
	{
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("(usernamefield"+usernamefield);
		username.sendKeys(usernamefield);
		return this;
	}
	public LoginpageTestCase1 enterPassword(String passwordfield)
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
 	 
// 	public boolean getInvalidConfirmation() { 
// 		 
// 		return errormessagedisplayed.isDisplayed(); 
// 	}

//	public  HomeChart clickCredentials()
//	{
//		submit.click();
//		return new HomeChart(driver);
//	}
	}

