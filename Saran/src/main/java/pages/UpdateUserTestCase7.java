package pages;

import java.awt.AWTException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateUserTestCase7 {
	WebDriver driver;

	public UpdateUserTestCase7(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class=\"fa fa-institution\"])[1]")
	WebElement admin;
	@FindBy(xpath = "(//span[@class=\"fa fa-user\"])[2]")
	WebElement usermenu;

	public void clickAdmin() {
		admin.click();
		usermenu.click();
		// role.click();
	}

	public void updateAdmin(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Locate and enter the username in the search box
		WebElement usernameField = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='UserName/UserDescription/Email']")));
		usernameField.sendKeys(username);

		// Click the search button
		WebElement searchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
		searchButton.click();
		WebElement userRow = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//table[contains(@id,\"usersTable\")]/tbody/tr[td/a[contains(text(),'" + username + "')]]")));
		userRow.click();

		// Get the username within that row
		WebElement usernamefiled = userRow.findElement(By.xpath("./td[2]/a[contains(text(),'" + username + "')]"));
		// Click checkbox using JavaScript to ensure selection
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usernamefiled);
		System.out.println("update selected for user: " + username);

		WebElement update = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Update']")));
		update.click();

	}

	public void enterAdminDetails(String descr, String usrphn, String mble, String selectrole, String addrs, String eml,
			String itemName, String sitegroup, String cusorganisation, List<String> accessgrouplist) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement description = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Description']")));
		description.clear();
		description.sendKeys(descr);
		WebElement userphone = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"userPhone\"]")));
		userphone.clear();
		userphone.sendKeys(usrphn);
		WebElement mobile = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"userMobile\"]")));
		mobile.clear();
		mobile.sendKeys(mble);
		WebElement role = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"role\"]")));
		Select select = new Select(role);
		select.selectByVisibleText(selectrole);
		WebElement address = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"userAddress\"]")));
		address.clear();
		address.sendKeys(addrs);
		WebElement email = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"userAddress\"]")));
		email.clear();
		email.sendKeys(eml);
		WebElement tokencreatn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value=\"true\"])[1]")));
		tokencreatn.click();
		WebElement ldapuser = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value=\"true\"])[2]")));
		ldapuser.click();
		WebElement technicalteam = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"tree_menu_sel_but_2\"]")));
		technicalteam.click();
		WebElement selecttechteam = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='8_anchor']")));
		selecttechteam.click();

		WebElement depthierarchy = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='tree_menu_sel_but_3']")));
		depthierarchy.click();

		WebElement arrow = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@role='presentation'])[9]")));
		arrow.click();
		WebElement arrowpath = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@role='presentation'])[13]")));
		arrowpath.click();

		// String itemName="NTCC NOC";//DEPARTMENT HIERARCHY
		WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Dynamically locate the element
		String dynamicXPath = "(//li[a[contains(text(),'" + itemName + "')]]/a)[2]";

		WebElement treeItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", treeItem);

		// Click using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", treeItem);

		System.out.println("Selected '" + itemName + "' from the list.");

		// SITE_PERSONS GROUP
		WebElement sitepersons_group = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"tree_menu_sel_but_4\"]")));
		sitepersons_group.click();

		String xpathExpression = String.format("//li[@role='treeitem']/a[contains(normalize-space(), '%s')]",
				sitegroup);
		By locator = By.xpath(xpathExpression);
		WebElement treeItem1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		treeItem1.click();

		// CUSTOMER ORGANISATION
		WebElement cust_organisatn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='tree_menu_sel_but_1']")));
		cust_organisatn.click();

		String cusorganztndropdown = String.format("//li[@role='treeitem']/a[contains(normalize-space(), '%s')]",
				cusorganisation);
		By locator1 = By.xpath(cusorganztndropdown);
		WebElement treeItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
		treeItem2.click();

		WebElement default_group = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='defaultGroupSelect']")));
		default_group.click();

		// PASS ACCESSGROUPLIST AS LIST ADDED ONE EXTRA FUNCTION IN EXCELUTILITY FOR
		// GETTING AS LIST(COULMNS)
		List<String> targetItems = accessgrouplist; // Add more items as needed
		List<WebElement> options = driver
				.findElements(By.xpath("//ul[@class='ms-list']//li[@class='ms-elem-selectable']"));

		System.out.println("Total options found: " + options.size());

		// Loop through the list
		int selectedCount = 0;
		for (WebElement option : options) {
			String optionText = option.getText().trim();

			if (targetItems.contains(optionText)) {
				System.out.println("Selecting: " + optionText);
				option.click(); // Click on the matching item
				selectedCount++;

				// Stop if all required items are selected
				if (selectedCount == targetItems.size()) {
					break;
				}
			}
		}

	}

	public void robotclass() throws AWTException {

		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement upload = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uploadImage']")));

		upload.sendKeys("C:\\Users\\Neethu\\Downloads\\young-man-with-glasses-illustration\\sample.jpg");

	}

	public void clickUpdate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement update = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Update\"]")));
		update.click();
		driver.switchTo().alert().accept();
		driver.switchTo().frame("userUpdateTarget");
		WebElement assureupdate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User updated Successfully. ')]")));
		if(assureupdate.isDisplayed() && assureupdate.getText().contains("User updated Successfully"))
		{
			 System.out.println("Update message is displayed: " + assureupdate.getText());
        } else {
            System.out.println("Update message is not displayed or does not match.");
        }
		}
		 

	}


