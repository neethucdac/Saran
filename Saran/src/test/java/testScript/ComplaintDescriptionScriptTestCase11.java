package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintDescriptionTestCase11;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class ComplaintDescriptionScriptTestCase11 extends Base{
	@Test
	public void verifyComplaintDescriptionpresent() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		ComplaintDescriptionTestCase11 cdt=new ComplaintDescriptionTestCase11(driver);
		String id=ExcelUtility.readStringData(1, 0, "viewingcomplaint");
		cdt.clickComplaint(id);
		cdt.ensureComplaintDescription();
	}
	

}
