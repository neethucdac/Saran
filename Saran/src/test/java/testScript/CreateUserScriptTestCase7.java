package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.CreateUserTestCase7;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class CreateUserScriptTestCase7 extends Base {
	@Test
	public void verifyAbleToCreateUser() throws IOException, AWTException {
		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		CreateUserTestCase7 cut=new CreateUserTestCase7(driver);
		cut.clickAdmin();
		cut.createUser();
		
		String name = ExcelUtility.readStringData(1, 0, "createuser");// sheetname-createuser
		
		String prefereduser=ExcelUtility.readStringData(1, 1, "createuser");
		
		String email=ExcelUtility.readStringData(1, 2, "createuser");
		String phno=ExcelUtility.readIntegerData(1, 3, "createuser");
		System.out.println("phno"+ phno);
		
		String desc=ExcelUtility.readStringData(1,4, "createuser");
		String userpassword=ExcelUtility.readStringData(1, 5, "createuser");
		String retypepassword=ExcelUtility.readStringData(1, 5, "createuser");
		String mobile=ExcelUtility.readIntegerData(1, 6, "createuser");
		String uaddress=ExcelUtility.readStringData(1, 7, "createuser");
		cut.enterDetailsForCreatingUser(name,prefereduser,email,phno,desc,userpassword,retypepassword,mobile,uaddress);
		cut.robotclass();
		cut.verifyUserIsAbleToSave();
	}
}
