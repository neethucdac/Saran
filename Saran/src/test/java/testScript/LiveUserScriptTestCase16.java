package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneUpdateTestCase5;
import pages.LiveUserTestCase16;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class LiveUserScriptTestCase16 extends Base {
	@Test
public void verifyAbleToAssignLiveUser() throws IOException, InterruptedException, AWTException{
	String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 System.out.println("username...."+usernamefield);
	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	System.out.println("password"+passwordfield);
	LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
	loginpage.enterUsername(usernamefield);
	loginpage.enterPassword(passwordfield);
	loginpage.clickLogin();
	LiveUserTestCase16 liv=new LiveUserTestCase16(driver);
	String complaintid=ExcelUtility.readStringData(1, 0, "liveusercomplaintupdate");
	String comment=ExcelUtility.readStringData(1, 1, "liveusercomplaintupdate");
	String assignee=ExcelUtility.readStringData(1, 2, "liveusercomplaintupdate");
	String compcategory=ExcelUtility.readStringData(1, 3, "liveusercomplaintupdate");
	String comppriority=ExcelUtility.readStringData(1, 4, "liveusercomplaintupdate");
	String compstatus=ExcelUtility.readStringData(1, 5, "liveusercomplaintupdate");
	String sourcetype=ExcelUtility.readStringData(1, 6, "liveusercomplaintupdate");
	String id=ExcelUtility.readIntegerData(1, 7, "liveusercomplaintupdate");
	String teamdropdown=ExcelUtility.readStringData(1, 8, "liveusercomplaintupdate");
	String time=ExcelUtility.readIntegerData(1, 9, "liveusercomplaintupdate");
	String reasonforoccurence=ExcelUtility.readStringData(1, 10, "liveusercomplaintupdate");
	String callername=ExcelUtility.readStringData(1, 11, "liveusercomplaintupdate");
	String calleremail=ExcelUtility.readStringData(1, 12, "liveusercomplaintupdate");
	String callermobile=ExcelUtility.readIntegerData(1, 13, "liveusercomplaintupdate");
	String callerlandline=ExcelUtility.readIntegerData(1, 14, "liveusercomplaintupdate");
	String descriptionupdate=ExcelUtility.readStringData(1, 15, "liveusercomplaintupdate");
	String observername=ExcelUtility.readStringData(1, 16, "liveusercomplaintupdate");
	String escalatedtime=ExcelUtility.readIntegerData(1, 17, "liveusercomplaintupdate");
	System.out.println(comppriority);
	liv.updateComplaint(complaintid,comment,compcategory,comppriority,compstatus,sourcetype,id,teamdropdown,time,reasonforoccurence,callername,calleremail,callermobile,callerlandline,escalatedtime);
	liv.robotclass(descriptionupdate);
	liv.observerTagUpdate(observername);
}
}