package testScript;

import java.io.IOException;

import pages.AlternateEmailFeatureTestCase18;
import pages.EmailIntegrationTestCase17;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class AlternateEmailFeatureScriptTestCase18 extends Base{
	public void verifySysSupportAlternateEmailIntegration() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		AlternateEmailFeatureTestCase18 eit=new AlternateEmailFeatureTestCase18(driver);
		eit.clickAdmin();
		eit.clickSystem();
		eit.ensureAlternateEmailfeature();
	}

}
