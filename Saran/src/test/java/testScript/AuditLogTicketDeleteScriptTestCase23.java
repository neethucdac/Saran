package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AuditLogTicketDeleteTestCase23;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class AuditLogTicketDeleteScriptTestCase23 extends Base{
	@Test
	public void verifyAbleToDelete() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		AuditLogTicketDeleteTestCase23 aut=new AuditLogTicketDeleteTestCase23(driver);
		aut.clickAuditLog();
		aut.verifyDeleteTicket();
}


}
