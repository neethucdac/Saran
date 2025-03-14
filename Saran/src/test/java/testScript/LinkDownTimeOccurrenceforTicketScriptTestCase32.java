package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneUpdateTestCase5;
import pages.LinkDownTimeOccurrenceforTicketTestCase32;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class LinkDownTimeOccurrenceforTicketScriptTestCase32 extends Base {
	@Test
	public void verifyAbleToFindDownTimeOccurrence() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		LinkDownTimeOccurrenceforTicketTestCase32 ldt=new LinkDownTimeOccurrenceforTicketTestCase32(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "updatecomplaint");
		ldt.clickComplaint(complaintid);
		ldt.verifyLinkDowndetails();

}
}
