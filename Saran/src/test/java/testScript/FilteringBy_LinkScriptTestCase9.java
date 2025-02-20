package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.FilteringBy_ComplaintTestCase9;
import pages.FilteringBy_LinkTestCase9;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class FilteringBy_LinkScriptTestCase9 extends Base {
	@Test
	public void verifyFilterinLink() throws IOException, InterruptedException
	{
		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		FilteringBy_LinkTestCase9 fgc=new FilteringBy_LinkTestCase9(driver);
		fgc.cilickComplaint();
		String group = ExcelUtility.readStringData(1, 0, "filtercomplaint");
		fgc.clickFilterByGroup(group);
		String linktitle=ExcelUtility.readStringData(1, 3, "filtercomplaint");
		fgc.clickFilterByLinkTitle(linktitle);
		String linkid=ExcelUtility.readIntegerData(1, 4, "filtercomplaint");
		fgc.clickFilterByLinkID(linkid);
		
	}


}
