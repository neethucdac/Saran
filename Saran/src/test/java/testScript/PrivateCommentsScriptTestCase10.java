package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.PrivateCommentsTestCase10;
import utilities.ExcelUtility;

public class PrivateCommentsScriptTestCase10 extends Base{
	@Test
	public void verifyPrivateCommentIsSeen() throws IOException, InterruptedException
	{
		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		PrivateCommentsTestCase10 pct=new PrivateCommentsTestCase10(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "privatecommenttestcase10");
		String privatecomment=ExcelUtility.readStringData(1, 1, "privatecommenttestcase10");
		pct.verifyComplaintList(complaintid,privatecomment);
	}

}
