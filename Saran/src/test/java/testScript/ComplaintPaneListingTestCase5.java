package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneListingTestCase5;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class ComplaintPaneListingTestCase5 extends Base {
@Test
public void verifyUserAbleToViewingComplaints() throws IOException
{
	String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 System.out.println("username...."+usernamefield);
	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	System.out.println("password"+passwordfield);
	LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
	loginpage.enterUsername(usernamefield);
	loginpage.enterPassword(passwordfield);
	loginpage.clickLogin();
	ComplaintpaneListingTestCase5 cmpv=new ComplaintpaneListingTestCase5(driver);
	cmpv.viewingComplaints();
	
}
}
