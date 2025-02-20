package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class HomePageTestCase1 extends Base {
	Homepage homepage;
@Test
	public void verifyUserAbleToLogin() throws IOException
	{
	String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 System.out.println("username...."+usernamefield);
	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	System.out.println("password"+passwordfield);
	LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
	loginpage.enterUsername(usernamefield);
	loginpage.enterPassword(passwordfield);
	loginpage.clickLogin();
}
}
