package testScript;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.UpdateUserTestCase7;
import utilities.ExcelUtility;

public class UpdateUserScriptTestCase7 extends Base {
	@Test
	public void verifyUserUpdated() throws IOException, AWTException
	{

		String usernamefield = ExcelUtility.readStringData(1, 0, "loginpage"); // sheetname-loginpage
		System.out.println("username...." + usernamefield);
		String passwordfield = ExcelUtility.readStringData(1, 1, "loginpage");
		System.out.println("password" + passwordfield);
		LoginpageTestCase1 loginpage = new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		UpdateUserTestCase7 uut=new UpdateUserTestCase7(driver);
		uut.clickAdmin();
		String username = ExcelUtility.readStringData(1, 0, "updateuser");
		uut.updateAdmin(username);
		String descr = ExcelUtility.readStringData(1, 1, "updateuser");
		String usrphn = ExcelUtility.readIntegerData(1, 2, "updateuser");
		String mble = ExcelUtility.readIntegerData(1, 3, "updateuser");
		String selectrole = ExcelUtility.readStringData(1, 4, "updateuser");
		String address = ExcelUtility.readStringData(1, 5, "updateuser");
		String email = ExcelUtility.readStringData(1, 6, "updateuser");
		String depthierachy = ExcelUtility.readStringData(1, 7, "updateuser");
		String sitegroup = ExcelUtility.readStringData(1, 8, "updateuser");
		String cusorganization = ExcelUtility.readStringData(1, 9, "updateuser");
		 // Example usage - Read multiple items from an Excel column
        List<String> targetItems = ExcelUtility.readColumnData(10, "updateuser"); // Read column index 0
        System.out.println("Items from Excel Column: " + targetItems);
		uut.enterAdminDetails(descr,usrphn,mble,selectrole,address,email,depthierachy,sitegroup,cusorganization,targetItems);
		uut.robotclass();
		uut.clickUpdate();
	}

}
