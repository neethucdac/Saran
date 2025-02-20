package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComparisonofUserTestCase10;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class ComparisonofUserScriptTestCase10 extends Base{
	@Test
	public void verifyAdminisNotinMenu() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginlocalusertestcase10"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginlocalusertestcase10"); 
	 	System.out.println("password"+passwordfield);
	 	ComparisonofUserTestCase10 loginpage=new ComparisonofUserTestCase10(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		loginpage.isdashboarddisplayed();
		loginpage.ensureAdminisAbsent();
		
		
		
	}

}
