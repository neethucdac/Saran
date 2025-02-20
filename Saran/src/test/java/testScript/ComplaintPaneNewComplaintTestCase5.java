package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ComplaintpaneNewComplaintTestCase5;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class ComplaintPaneNewComplaintTestCase5 extends Base{
	@Test
	public void verifyAbletoAddComplaint() throws IOException, InterruptedException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		ComplaintpaneNewComplaintTestCase5 compl=new ComplaintpaneNewComplaintTestCase5(driver);
		
		String title=ExcelUtility.readStringData(1, 0,"newcomplaint");
		System.out.println("title..."+title);
		String description=ExcelUtility.readStringData(1, 1,"newcomplaint");
		System.out.println("description..."+description);
		String assignee=ExcelUtility.readStringData(1, 2,"newcomplaint");
		System.out.println("assignee..."+assignee);
		String category=ExcelUtility.readStringData(1, 3,"newcomplaint");
		String priority=ExcelUtility.readStringData(1, 4,"newcomplaint");
		String sourcetype=ExcelUtility.readStringData(1, 5,"newcomplaint");
		String id=ExcelUtility.readIntegerData(1, 6,"newcomplaint");
		compl.newComplaint();
		
		
		compl.editNewcomplaint(title,description,assignee,category,priority,sourcetype,id);
	}

}
