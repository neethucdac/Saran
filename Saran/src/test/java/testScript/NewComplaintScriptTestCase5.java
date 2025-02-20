package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.NewComplaintTestcase5;
import utilities.ExcelUtility;

public class NewComplaintScriptTestCase5 extends Base{
	@Test
	public void verifyUserAbleToCreateNewComplaint() throws IOException, InterruptedException
	{
		{
			String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
			 System.out.println("username...."+usernamefield);
			 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
			System.out.println("password"+passwordfield);
			LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
			loginpage.enterUsername(usernamefield);
			loginpage.enterPassword(passwordfield);
			loginpage.clickLogin();
			NewComplaintTestcase5 nw=new NewComplaintTestcase5(driver);
			nw.clickComplaint();
			nw.newComplaint();
	}
	}

}
