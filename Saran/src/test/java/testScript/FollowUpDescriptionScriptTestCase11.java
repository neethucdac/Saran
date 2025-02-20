package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintViewingTestCase5;
import pages.FollowupCommentsTestCase11;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class FollowUpDescriptionScriptTestCase11 extends Base{
	@Test
	public void verifyFollowUpCommentexist() throws IOException, InterruptedException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		FollowupCommentsTestCase11 clt=new FollowupCommentsTestCase11(driver);
		String id=ExcelUtility.readStringData(1, 0, "viewingcomplaint");
		clt.verifyComplaintList(id);
		
	}

}
