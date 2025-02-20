package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.DailyReportTestCase21;
import pages.DailyReportWithAdvancedFiltersTestCase21;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class DailyReportWithAdvancedFiltersScriptTestCase21 extends Base {
	@Test
	public void verifyCreationofDailyReportWithFilters() throws IOException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
		 System.out.println("username...."+usernamefield);
		 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
		System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		DailyReportWithAdvancedFiltersTestCase21 drt=new DailyReportWithAdvancedFiltersTestCase21(driver);
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
		drt.generateReport(profile,compltype,category,statusvalue,assignee,createduser,reportformat,choosefilteer,title);
	}
	
	

}
