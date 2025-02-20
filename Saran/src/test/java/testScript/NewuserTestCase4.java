package testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.NewUserTestCase4;
import utilities.ExcelUtility;

public class NewuserTestCase4 extends Base{
	@Test
	public void verifyNewUserCreate() throws IOException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		NewUserTestCase4 newuser=new NewUserTestCase4(driver);
		newuser.clickAdmin();
		newuser.clickUser();
		newuser.createUser();
		String name=ExcelUtility.readStringData(1, 0, "createuser");//sheetname-createuser
		
		String prefereduser=ExcelUtility.readStringData(1, 1, "createuser");
		
		String email=ExcelUtility.readStringData(1, 2, "createuser");
		String phno=ExcelUtility.readIntegerData(1, 3, "createuser");
		System.out.println("phno"+ phno);
		
		String desc=ExcelUtility.readStringData(1,4, "createuser");
		String userpassword=ExcelUtility.readStringData(1, 5, "createuser");
		String retypepassword=ExcelUtility.readStringData(1, 5, "createuser");
		String mobile=ExcelUtility.readIntegerData(1, 6, "createuser");
		String uaddress=ExcelUtility.readStringData(1, 7, "createuser");
		newuser.enterDetailsForCreatingUser(name,prefereduser,email,phno,desc,userpassword,retypepassword,mobile,uaddress);
		newuser.robotclass();
		newuser.verifyUserIsAbleToSave();
	}


}
