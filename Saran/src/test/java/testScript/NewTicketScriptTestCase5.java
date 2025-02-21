package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneNewComplaintTestCase5;
import pages.LoginpageTestCase1;
import pages.NewTicketTestCase5;
import utilities.ExcelUtility;

public class NewTicketScriptTestCase5 extends Base{
	@Test
	public void verifyAbleToCreateNewTicket() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		NewTicketTestCase5 compl=new NewTicketTestCase5(driver);
		
		
		compl.newTicket();
		String title=ExcelUtility.readStringData(1, 0,"newcomplaint");
		String description=ExcelUtility.readStringData(1, 1,"newcomplaint");
		String assignee=ExcelUtility.readStringData(1, 2,"newcomplaint");
		String category=ExcelUtility.readStringData(1, 3,"newcomplaint");
		String priority=ExcelUtility.readStringData(1, 4,"newcomplaint");
		String source=ExcelUtility.readStringData(1, 5,"newcomplaint");
		String id=ExcelUtility.readIntegerData(1, 6,"newcomplaint");
		String teamdropdown=ExcelUtility.readStringData(1, 7,"newcomplaint");
		String esclregion=ExcelUtility.readStringData(1, 8,"newcomplaint");
		String escllocation=ExcelUtility.readStringData(1, 9,"newcomplaint");
		String reasonforoccurrence=ExcelUtility.readStringData(1, 10,"newcomplaint");
		String subreasonforoccurrence=ExcelUtility.readStringData(1, 11,"newcomplaint");
		String callername=ExcelUtility.readStringData(1, 12,"newcomplaint");
		String calleremail=ExcelUtility.readStringData(1, 13,"newcomplaint");
		String callermobile=ExcelUtility.readIntegerData(1, 14,"newcomplaint");
		String callerlandline=ExcelUtility.readIntegerData(1, 15,"newcomplaint");
		String descriptionupdate=ExcelUtility.readStringData(1, 16,"newcomplaint");
		String observername=ExcelUtility.readStringData(1, 17,"newcomplaint");
		compl.editnewTIcketform(title,description,assignee,category,priority,source,id,teamdropdown,esclregion,escllocation,reasonforoccurrence,subreasonforoccurrence,callername,calleremail,callermobile,callerlandline);
		compl.robotclass(descriptionupdate);
		compl.observerTagUpdate(observername);
	}

}
