package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComparisonofAdminTestCase10;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class ComparisonofAdminScriptTestCase10 extends Base {
	@Test
	public void verifyAllFieldsAreDisplayed() throws IOException

	{
		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		loginpage.isdashboarddisplayed();
		ComparisonofAdminTestCase10 cat=new ComparisonofAdminTestCase10(driver);
		cat.adminMenuExist();
	}

}
