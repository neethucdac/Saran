package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AuditLogsUserLoginTestCase23;
import pages.LoginpageTestCase1;
import pages.NewLinkTestCase6;
import utilities.ExcelUtility;

public class AuditLoginUserScriptTestCase23 extends Base{
	@Test
	public void verifyCreationOfLoginUserLogs() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		AuditLogsUserLoginTestCase23 aut=new AuditLogsUserLoginTestCase23(driver);
		aut.clickAuditLog();
		aut.verifyuserlogin();
}

}
