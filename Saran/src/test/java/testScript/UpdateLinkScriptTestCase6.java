package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.UpdateLinkTestCase6;
import utilities.ExcelUtility;

public class UpdateLinkScriptTestCase6 extends Base{
	@Test
	public void verifyAbletoUpdateLink() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		UpdateLinkTestCase6 ult=new UpdateLinkTestCase6(driver);
		ult.clickLink();
		String linkid= ExcelUtility.readIntegerData(1, 0, "updatelink");
		String linkname= ExcelUtility.readStringData(1, 1, "updatelink");
		String servicetype= ExcelUtility.readStringData(1, 2, "updatelink");
		String statusoflink= ExcelUtility.readStringData(1, 3, "updatelink");
		String circuitID= ExcelUtility.readStringData(1, 4, "updatelink");
		String customerId= ExcelUtility.readIntegerData(1, 5, "updatelink");
		String cpnumber= ExcelUtility.readStringData(1, 6, "updatelink");
		String customerorgoptions= ExcelUtility.readStringData(1, 7, "updatelink");
		String customerorname= ExcelUtility.readStringData(1, 8, "updatelink");
		String slafield= ExcelUtility.readIntegerData(1, 9, "updatelink");
		String wanip= ExcelUtility.readStringData(1, 10, "updatelink");
		String terno= ExcelUtility.readIntegerData(1, 11, "updatelink");
		String portdetail_a= ExcelUtility.readStringData(1, 12, "updatelink");
		String portdetail_b= ExcelUtility.readStringData(1, 13, "updatelink");
		String region_from= ExcelUtility.readStringData(1, 14, "updatelink");
		String region_to= ExcelUtility.readStringData(1, 15, "updatelink");
		String linkfrom= ExcelUtility.readStringData(1, 16, "updatelink");
		String linkto= ExcelUtility.readStringData(1, 17, "updatelink");
		String handoverconnectivity= ExcelUtility.readStringData(1, 18, "updatelink");
		String cktmediatype= ExcelUtility.readStringData(1, 19, "updatelink");
		String capacity= ExcelUtility.readIntegerData(1, 20, "updatelink");
		String uomcapacity= ExcelUtility.readStringData(1, 21, "updatelink");
		String remarks= ExcelUtility.readStringData(1, 22, "updatelink");
		
		String description= ExcelUtility.readStringData(1, 23, "updatelink");
		String time= ExcelUtility.readIntegerData(1, 24, "updatelink");


		System.out.println("circuitID"+circuitID);
		ult.clickLinkById(linkid);
		ult.clickUpdate(linkname,servicetype,statusoflink,circuitID,customerId,cpnumber,customerorgoptions,customerorname,slafield,wanip,terno,portdetail_a,portdetail_b,region_from,region_to,linkfrom,linkto,handoverconnectivity,cktmediatype,capacity,uomcapacity,remarks,time);
		ult.robotclass(description);
		ult.observerTagUpdate();
	}

}
