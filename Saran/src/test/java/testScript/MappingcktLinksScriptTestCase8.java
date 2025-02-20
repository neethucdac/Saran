package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.MappingcktLinksTestCase8;
import utilities.ExcelUtility;

public class MappingcktLinksScriptTestCase8 extends Base{
	@Test
	public void verifyisAbleToMappingLinks() throws IOException, InterruptedException
	{
		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		MappingcktLinksTestCase8 mclk=new MappingcktLinksTestCase8(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "mappinglinktestcase8");
		mclk.verifyComplaintList(complaintid);
	}

}
