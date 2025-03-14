package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.AttachmentOptionTestCase34;
import pages.LinkDownTimeOccurrenceforTicketTestCase32;
import pages.LoginpageTestCase1;
import utilities.ExcelUtility;

public class AttachmentOptionScriptTestCase34 extends Base{
	@Test
	public void verifyAbleToUploadAttachments() throws IOException, InterruptedException, AWTException
	{
		String usernamefield= ExcelUtility.readStringData(1, 0, "loginpage"); //sheetname-loginpage
	 	 System.out.println("username...."+usernamefield);
	 	 String passwordfield = ExcelUtility.readStringData(1, 1,"loginpage"); 
	 	System.out.println("password"+passwordfield);
		LoginpageTestCase1 loginpage=new LoginpageTestCase1(driver);
		loginpage.enterUsername(usernamefield);
		loginpage.enterPassword(passwordfield);
		loginpage.clickLogin();
		AttachmentOptionTestCase34 aot=new AttachmentOptionTestCase34(driver);
		String complaintid=ExcelUtility.readStringData(1, 0, "updatecomplaint");
		aot.newTicket();
		aot.robotclassforWord();
		aot.robotclassforPDF();
		aot.robotclassforPaint();
		aot.robotclassforExcel();

}
}
