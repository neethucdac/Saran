package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LiveUserTestCase16;
import pages.LoginpageTestCase1;
import pages.RemainingSLATestCase19;
import utilities.ExcelUtility;

public class RemainingSLAScriptTestCase19 extends Base {
	@Test
	public void verifySLAisAvailable() throws IOException, InterruptedException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		RemainingSLATestCase19 rst=new RemainingSLATestCase19(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "liveusercomplaintupdate");
		rst.updateComplaint(complaintid);
		rst.verifyRemainingSLAinLinkDownOccurrence();
	}

}
