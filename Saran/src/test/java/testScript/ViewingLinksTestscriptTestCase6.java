package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.ViewingLinksTestCase6;
import utilities.ExcelUtility;

public class ViewingLinksTestscriptTestCase6 extends Base{
	@Test
	public void isUserAbleToViewLinkDetails() throws IOException, InterruptedException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		ViewingLinksTestCase6 vlt=new ViewingLinksTestCase6(driver);
		vlt.clickLink();
		String linkid=ExcelUtility.readIntegerData(1, 0, "viewinglink");
		System.out.println("linkid..."+linkid);
		//vlt.clicklinkid(linkid);;
		vlt.clickLinkById(linkid);
	}

}
