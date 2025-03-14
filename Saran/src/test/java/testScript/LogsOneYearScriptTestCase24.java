package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AuditLogTicketDeleteTestCase23;
import pages.LoginpageTestCase1;
import pages.LogsOneYeatTestCase24;
import utilities.ExcelUtility;

public class LogsOneYearScriptTestCase24 extends Base{
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
		LogsOneYeatTestCase24 lgs=new LogsOneYeatTestCase24(driver);
		lgs.clickAuditLog();
		String currentmonth=ExcelUtility.readIntegerData(1, 0, "auditlogoneyear");
		String year=ExcelUtility.readIntegerData(1, 1, "auditlogoneyear");
		String month=ExcelUtility.readStringData(1, 2, "auditlogoneyear");
		lgs.createLogForOneYear(currentmonth,year,month);
		
}

}
