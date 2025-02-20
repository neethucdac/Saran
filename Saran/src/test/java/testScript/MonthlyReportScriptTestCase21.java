package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginpageTestCase1;
import pages.MonthlyReportTestCase21;
import pages.WeeklyReportTestCase21;
import utilities.ExcelUtility;

public class MonthlyReportScriptTestCase21 extends Base{
	@Test
	public void verifyAbleToGenerateMonthlyProvision() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		MonthlyReportTestCase21 drt=new MonthlyReportTestCase21(driver);
		drt.clickrReport();
		String profile=ExcelUtility.readStringData(1, 0, "dailyreport");
		String compltype=ExcelUtility.readStringData(1, 1, "dailyreport");
		String category=ExcelUtility.readStringData(1, 2, "dailyreport");
		String statusvalue=ExcelUtility.readIntegerData(1, 3, "dailyreport");
		String assignee=ExcelUtility.readStringData(1, 4, "dailyreport");
		String createduser=ExcelUtility.readStringData(1, 5, "dailyreport");
		String reportformat=ExcelUtility.readStringData(1, 6, "dailyreport");
		String choosefilteer=ExcelUtility.readStringData(1, 7, "dailyreport");
		String title=ExcelUtility.readStringData(1, 8, "dailyreport");
		drt.generateWeeklyReport(profile,compltype,category,statusvalue,assignee,createduser,reportformat,choosefilteer,title);
	}

}
