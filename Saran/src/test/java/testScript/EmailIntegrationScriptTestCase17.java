package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.EmailIntegrationTestCase17;
import pages.LoginpageTestCase1;
import pages.RemainingSLATestCase19;
import utilities.ExcelUtility;

public class EmailIntegrationScriptTestCase17 extends Base{
	@Test
	public void verifySysSupportEmailIntegration() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		EmailIntegrationTestCase17 eit=new EmailIntegrationTestCase17(driver);
		eit.clickAdmin();
		eit.clickSystem();
	}

}
