package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LinkListingTestCase6;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class LinkListingscriptTestCase6 extends Base {
	@Test
	public void verifyListingAllLinks() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		LinkListingTestCase6 llt=new LinkListingTestCase6(driver);
		llt.clickLink();
	}

}
