package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.NewLinkTestCase6;
import utilities.ExcelUtility;

public class NewLinkScriptTestCase6 extends Base {
	@Test
	public void verifyAbleTocreateNewComplaint() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		NewLinkTestCase6 nlt=new NewLinkTestCase6(driver);
		nlt.clickLink();
		String title=ExcelUtility.readStringData(1, 0, "newlink");
		String servicetype=ExcelUtility.readStringData(1, 1, "newlink");
		String cktid=ExcelUtility.readIntegerData(1, 2, "newlink");
		String custid=ExcelUtility.readIntegerData(1, 3, "newlink");
		String cpno=ExcelUtility.readIntegerData(1, 4, "newlink");
		String customerorgvalue=ExcelUtility.readStringData(1, 5, "newlink");
		String custname=ExcelUtility.readStringData(1, 6, "newlink");
		String wanip=ExcelUtility.readStringData(1, 7, "newlink");
		String sla=ExcelUtility.readIntegerData(1, 8, "newlink");
		
		String portdetail_a= ExcelUtility.readStringData(1, 9, "newlink");
		String portdetail_b= ExcelUtility.readStringData(1, 10, "newlink");
		String region_from= ExcelUtility.readStringData(1, 11, "newlink");
		String region_to= ExcelUtility.readStringData(1, 12, "newlink");
		String linkfrom= ExcelUtility.readStringData(1, 13, "newlink");
		String linkto= ExcelUtility.readStringData(1, 14, "newlink");
		String handoverconnectivity= ExcelUtility.readStringData(1, 15, "newlink");
		String cktmediatype= ExcelUtility.readStringData(1, 16, "newlink");
		String capacity= ExcelUtility.readIntegerData(1, 17, "newlink");
		String uomcapacity= ExcelUtility.readStringData(1, 18, "newlink");
		String remarks= ExcelUtility.readStringData(1, 19, "newlink");

		String description= ExcelUtility.readStringData(1, 20, "newlink");
		String time= ExcelUtility.readIntegerData(1, 21, "newlink");

		
		nlt.newLink(title,servicetype,cktid,custid,cpno,customerorgvalue,custname,wanip,sla,portdetail_a,portdetail_b,region_from,region_to,linkfrom,linkto,handoverconnectivity,cktmediatype,capacity,uomcapacity,remarks,time);
		nlt.robotclass(description);
		nlt.observerTagUpdate();
	}

}
