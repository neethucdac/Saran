package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginpageTestCase1;
import pages.Testcase2PasswordChange;
import utilities.ExcelUtility;

public class PasswordChangeTestcase2 extends Base {
	Homepage homepage;
	
	@Test
	public void verifyUserAbleToChangePassword() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(2, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(2, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		Testcase2PasswordChange newpasword=new Testcase2PasswordChange(driver);
		newpasword.clickAdminheading();
		newpasword.clickPreference();
		newpasword.oldPassword(passwordfield);
		String newpasswordfield=ExcelUtility.readStringData(2, 2, "loginpage");
		System.out.println("newpassword"+newpasswordfield);
		newpasword.newPassword(newpasswordfield);
		newpasword.reenterNewPassword(newpasswordfield);
		newpasword.clickSubmit();
		newpasword.ispasswordsuccessdisplayed();

	}

}
