package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.NewUserRoleTestCase3;
import utilities.ExcelUtility;

public class NewRoleTestCase3 extends Base {
	@Test
	public void verifyUserAbleToAddNewUserRole() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		NewUserRoleTestCase3 userrole=new NewUserRoleTestCase3(driver);
		userrole.clickAdmin();
		userrole.clickUser();
		userrole.clickRole();
	}

}
