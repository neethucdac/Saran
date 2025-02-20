package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.AutoClosureOfTicketTestCase13;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class AutoClosureTicketScriptTestCase13 extends Base {
	@Test
	public void verifyAbleToAutoClosingTicket() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		AutoClosureOfTicketTestCase13 act=new AutoClosureOfTicketTestCase13(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "autoclosureticket");
		String comment=ExcelUtility.readStringData(1, 1, "autoclosureticket");
		String assignee=ExcelUtility.readStringData(1, 2, "autoclosureticket");
		String compcategory=ExcelUtility.readStringData(1, 3, "autoclosureticket");
		String comppriority=ExcelUtility.readStringData(1, 4, "autoclosureticket");
		String compstatus=ExcelUtility.readStringData(1, 5, "autoclosureticket");
		String sourcetype=ExcelUtility.readStringData(1, 6, "autoclosureticket");
		String id=ExcelUtility.readIntegerData(1, 7, "autoclosureticket");
		String teamdropdown=ExcelUtility.readStringData(1, 8, "autoclosureticket");
		String time=ExcelUtility.readIntegerData(1, 9, "autoclosureticket");
		String reasonforoccurence=ExcelUtility.readStringData(1, 10, "autoclosureticket");
		String callername=ExcelUtility.readStringData(1, 11, "autoclosureticket");
		String calleremail=ExcelUtility.readStringData(1, 12, "autoclosureticket");
		String callermobile=ExcelUtility.readIntegerData(1, 13, "autoclosureticket");
		String callerlandline=ExcelUtility.readIntegerData(1, 14, "autoclosureticket");
		String descriptionupdate=ExcelUtility.readStringData(1, 15, "autoclosureticket");
		String observername=ExcelUtility.readStringData(1, 16, "autoclosureticket");
		String escalatedtime=ExcelUtility.readIntegerData(1, 17, "autoclosureticket");
		System.out.println(comppriority);
		act.updateComplaint(complaintid,comment,assignee,compcategory,comppriority,compstatus,sourcetype,id,teamdropdown,time,reasonforoccurence,callername,calleremail,callermobile,callerlandline,escalatedtime);
		act.robotclass(descriptionupdate);
		act.observerTagUpdate(observername);
	}

}
