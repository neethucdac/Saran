package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.DeleteUserTestCase7;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class DeleteUserScriptTestCase7 extends Base {
	@Test
	public void verifyUserisDeletable() throws IOException, InterruptedException
	{
		
			String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
			System.out.println("username...." + usernamefield);
			String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
			System.out.println("password" + passwordfield);
			LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
			loginpage.enterUsername(usernamefield);
			loginpage.enterPassword(passwordfield);
			loginpage.clickLogin();
			DeleteUserTestCase7 dut=new DeleteUserTestCase7(driver);
			dut.clickAdmin();
			String username=ExcelUtility.readStringData(1, 0, "deleteuser");
			dut.enterUserName(username);
	}

}
