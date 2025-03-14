package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AuditLogTicketCreateTestCase23;
import pages.AuditLogTicketUpdateTestCase23;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class AuditLogTicketUpdateScriptTestCase23 extends Base{
	@Test
	public void AuditLogTicketUpdateScriptTestCase23() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		AuditLogTicketUpdateTestCase23 aut=new AuditLogTicketUpdateTestCase23(driver);
		aut.clickAuditLog();
		aut.verifyUpdateTicket();
}


}
