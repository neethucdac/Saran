package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AlternateEmailFeatureTestCase18;
import pages.LoginpageTestCase1;
import pages.TimeDurationTestCase20;
import utilities.ExcelUtility;

public class TimeDurationScriptTestCase20 extends Base {
	@Test
	public void verifyTimeSpentUnderAssignee() throws IOException, InterruptedException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		TimeDurationTestCase20 tdt=new TimeDurationTestCase20(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "liveusercomplaintupdate");
		tdt.updateComplaint(complaintid);
		tdt.verifyTimeSpentinAssignee();
	}

}
