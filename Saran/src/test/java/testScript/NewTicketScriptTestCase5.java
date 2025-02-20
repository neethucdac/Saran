package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneNewComplaintTestCase5;
import pages.LoginpageTestCase1;
import pages.NewTicketTestCase5;
import utilities.ExcelUtility;

public class NewTicketScriptTestCase5 extends Base{
	@Test
	public void verifyAbleToCreateNewTicket() throws IOException, InterruptedException
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
		compl.editnewTIcketform(title,description,assignee,category,priority,source,id,teamdropdown);
	}

}
