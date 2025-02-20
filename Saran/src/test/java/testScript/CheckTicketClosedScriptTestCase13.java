package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AutoClosureOfTicketTestCase13;
import pages.CheckTicketClosedTestCase13;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class CheckTicketClosedScriptTestCase13 extends Base{
	@Test
public void verifyTicketIsClosed() throws IOException, InterruptedException
{
	String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 System.out.println("username...."+usernamefield);
	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	System.out.println("password"+passwordfield);
	LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
	loginpage.enterUsername(usernamefield);
	loginpage.enterPassword(passwordfield);
	loginpage.clickLogin();
	CheckTicketClosedTestCase13 act=new CheckTicketClosedTestCase13(driver);
	String complaintid=ExcelUtility.readStringData(1, 0, "autoclosureticket");
	act.updateComplaint(complaintid);
}
}
