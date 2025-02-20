package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.DeleteRoleTestCase7;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class DeleteRoleScriptTestCase7 extends Base{
	@Test
	public void verifyUserIsAbleToDeleteRole() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		DeleteRoleTestCase7 drt=new DeleteRoleTestCase7(driver);
		drt.clickAdmin();
		drt.clickRole();
		String rolename= ExcelUtility.readStringData(1, 0, "deleterole");
		drt.deleteRole(rolename);
	}

}
