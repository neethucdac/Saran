package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.FilteringBy_ComplaintTestCase9;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class FilteringByScript_ComplaintTestCase9 extends Base{
	@Test
	public void verifyFilterinComplaint() throws IOException, InterruptedException
	{
		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		FilteringBy_ComplaintTestCase9 fgc=new FilteringBy_ComplaintTestCase9(driver);
		fgc.cilickComplaint();
		String group = ExcelUtility.readStringData(1, 0, "filtercomplaint");
		fgc.clickFilterByGroup(group);
		String complainttitle=ExcelUtility.readStringData(1, 1, "filtercomplaint");
		fgc.clickFilterByComplaintTitle(complainttitle);
		String complaintid=ExcelUtility.readStringData(1, 2, "filtercomplaint");
		fgc.clickFilterByComplaintID(complaintid);
		
	}

}
