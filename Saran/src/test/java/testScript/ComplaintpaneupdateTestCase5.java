package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneUpdateTestCase5;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class ComplaintpaneupdateTestCase5 extends Base {
	@Test
	public void verifyAbleToUpdateComplaint() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		ComplaintpaneUpdateTestCase5 cmpl=new ComplaintpaneUpdateTestCase5(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "updatecomplaint");
		String comment=ExcelUtility.readStringData(1, 1, "updatecomplaint");
		String assignee=ExcelUtility.readStringData(1, 2, "updatecomplaint");
		String compcategory=ExcelUtility.readStringData(1, 3, "updatecomplaint");
		String comppriority=ExcelUtility.readStringData(1, 4, "updatecomplaint");
		String compstatus=ExcelUtility.readStringData(1, 5, "updatecomplaint");
		String sourcetype=ExcelUtility.readStringData(1, 6, "updatecomplaint");
		String id=ExcelUtility.readIntegerData(1, 7, "updatecomplaint");
		String teamdropdown=ExcelUtility.readStringData(1, 8, "updatecomplaint");
		String time=ExcelUtility.readIntegerData(1, 9, "updatecomplaint");
		String reasonforoccurence=ExcelUtility.readStringData(1, 10, "updatecomplaint");
		String callername=ExcelUtility.readStringData(1, 11, "updatecomplaint");
		String calleremail=ExcelUtility.readStringData(1, 12, "updatecomplaint");
		String callermobile=ExcelUtility.readIntegerData(1, 13, "updatecomplaint");
		String callerlandline=ExcelUtility.readIntegerData(1, 14, "updatecomplaint");
		String descriptionupdate=ExcelUtility.readStringData(1, 15, "updatecomplaint");
		String observername=ExcelUtility.readStringData(1, 16, "updatecomplaint");
		String escalatedtime=ExcelUtility.readIntegerData(1, 17, "updatecomplaint");
		System.out.println(comppriority);
		cmpl.updateComplaint(complaintid,comment,assignee,compcategory,comppriority,compstatus,sourcetype,id,teamdropdown,time,reasonforoccurence,callername,calleremail,callermobile,callerlandline,escalatedtime);
		cmpl.robotclass(descriptionupdate);
		cmpl.observerTagUpdate(observername);
	}

}
