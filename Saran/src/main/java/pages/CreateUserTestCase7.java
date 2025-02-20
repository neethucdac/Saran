package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserTestCase7 {
	WebDriver driver;
	public CreateUserTestCase7(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class=\"fa fa-institution\"])[1]")WebElement admin;
	@FindBy(xpath = "(//span[@class=\"fa fa-user\"])[2]")WebElement usermenu;
	
	
	@FindBy(xpath = "//input[@name=\"userName\"]")WebElement name;
	@FindBy(xpath = "//input[@name=\"userUserName\"]")WebElement prefusername;
	@FindBy(xpath  ="//input[@name=\"email\"]")WebElement email;
	@FindBy(xpath = "//input[@name=\"userPhone\"]")WebElement phno;
	@FindBy(xpath = "//input[@name=\"description\"]")WebElement desc;
	@FindBy(xpath = "(//select[@name='role'])")WebElement role;
	@FindBy(xpath = "//button[@id=\"tree_menu_sel_but_2\"]")WebElement technicalteam;
	@FindBy(xpath = "//button[@id=\"tree_menu_sel_but_4\"]")WebElement sitepersonsgroup;
	//@FindBy(xpath = "//a[@class=\"jstree-anchor jstree-clicked\"]")WebElement mplsnoc;
	@FindBy(xpath = "(//img[@src=\"../assets/sd/image/delete.svg\"])[1]")WebElement closeimg;
	@FindBy(xpath = "(//input[@id='token'])[1]")WebElement tokencreation;
	@FindBy(xpath = "//input[@name='userPassword']")WebElement userpassword;
	@FindBy(xpath = "//input[@name='cPassword']")WebElement repassword;
	@FindBy(xpath = "//input[@name='userMobile']")WebElement mobileno;
	@FindBy(xpath = "//input[@name='userAddress']")WebElement useraddress;
	@FindBy(xpath = "(//span[@class='selected tree_select_area'])[2]")WebElement depthierarchy;
	@FindBy(xpath = "//a[@id='15_anchor']")WebElement manager;
	@FindBy(xpath = "(//span[@class='selected tree_select_area'])[4]")WebElement customrorganisation;
	@FindBy(xpath = "//input[@type='Submit']")WebElement save;
	
	public void clickAdmin()
	{
		admin.click();
		usermenu.click();
		//role.click();
	}
	public void createUser()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement createuser= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"glyphicon glyphicon-plus-sign\"]")));
		createuser.click();
		
	}
	public void enterDetailsForCreatingUser(String newname,String preferduser,String nemail,String phoneno,String descr,String userPassword,String retypepassword,String mobile,String uaddress)
	{
		name.sendKeys(newname);
		prefusername.sendKeys(preferduser);
		email.sendKeys(nemail);
		phno.sendKeys(phoneno);
		desc.sendKeys(descr);
		Select select=new Select(role);
		select.selectByIndex(5);
		WebElement dropdown = driver.findElement(By.id("tree_selected_val_cmp_2"));
		dropdown.click();
		// Wait until the options are visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement firstelement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='tree_menu_sel_but_2']")));
		firstelement.click();
		
		WebElement mpsoc=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='jstree-anchor'])[1]")));
        Actions actions = new Actions(driver);
        actions.doubleClick(mpsoc).perform();
       
        sitepersonsgroup.click();
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement sitepersondropdown=waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Blore']")));
        actions.doubleClick(sitepersondropdown).perform();
      
        WebDriverWait waitrdiobutton=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement yesRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='token'])[1]")));
        yesRadioButton.click();
        System.out.println("Displayed: " + yesRadioButton.isDisplayed());
        System.out.println("Enabled: " + yesRadioButton.isEnabled());
        userpassword.clear();
        userpassword.sendKeys(userPassword);
        repassword.clear();
        repassword.sendKeys(retypepassword);
        mobileno.sendKeys(mobile);
        useraddress.sendKeys(uaddress);
        depthierarchy.click();
        manager.click();
        customrorganisation.click();
        WebDriverWait waitcustorg=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement waitcustorgoption=waitcustorg.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='ABB (IP BW)']")));
        waitcustorgoption.click();
        
       
		


	}
	public void robotclass() throws AWTException
	{

	    String currenturl=driver.getCurrentUrl();
	    System.out.println(currenturl);

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement upload=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uploadImage']")));
		
		 upload.sendKeys("C:\\Users\\Neethu\\Downloads\\young-man-with-glasses-illustration\\sample.jpg");
		
	}
	public void verifyUserIsAbleToSave()
	{
		 // Wait until the element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='Submit']")));

        // Scroll into view using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
        saveButton.click();
        driver.switchTo().frame("fileUploadTarget"); 
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
       
            WebElement successMessage = waits.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[normalize-space(text())='User Saved Successfully']")));

            // Verify the success message
            if (successMessage.isDisplayed()) {
                System.out.println("Success message displayed: " + successMessage.getText());
            } else {
                System.out.println("Success message not displayed.");
            }
       
            
        
	}

}
