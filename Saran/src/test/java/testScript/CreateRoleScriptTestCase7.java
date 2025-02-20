package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.CreateRoleTestCase7;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class CreateRoleScriptTestCase7 extends Base{
	@Test
	public void verifyUserAbleToCreateRole() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		CreateRoleTestCase7 crt=new CreateRoleTestCase7(driver);
		crt.clickAdmin();
		crt.clickRole();
		String rolename= ExcelUtility.readStringData(1, 0, "createrole"); 
		String description= ExcelUtility.readStringData(1, 1, "createrole");
		String roleparent= ExcelUtility.readStringData(1, 2, "createrole");
		crt.createRole(rolename,description,roleparent);
	}

}
