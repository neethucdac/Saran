package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.CreateRoleTestCase7;
import pages.LoginpageTestCase1;
import pages.UpdateRoleTestCase7;
import utilities.ExcelUtility;

public class UpdateRoleScriptTestCase7 extends Base {
	
@Test
	public void verifyUserAbleToUpdateRole() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		UpdateRoleTestCase7 crt=new UpdateRoleTestCase7(driver);
		crt.clickAdmin();
		crt.clickRole();
		String crolename= ExcelUtility.readStringData(1, 0, "createrole");
		crt.updateRole(crolename);
		String  rolename=ExcelUtility.readStringData(1, 0, "updaterole");
		String  description=ExcelUtility.readStringData(1, 1, "updaterole");
		String  parent_role=ExcelUtility.readStringData(1, 2, "updaterole");
		crt.editRole(rolename, description, parent_role);
}
}
