package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShortUtilities {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { 
 		TakesScreenshot scrShot =  (TakesScreenshot) driver; 
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); 
 		
  
 		File f1 = new File(System.getProperty("user.dir ") + "//OutputScreenShot"); 
 		if (!f1.exists()) { 
 			f1.mkdirs();//java make directory 
 		} 
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); 
  
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + 
  
 				failedTestCase + timeStamp + ".png"; 
  
 		File finalDestination = new File(destination); 
  
 		FileHandler.copy(screenShot, finalDestination); 
 		File screenshotDir = new File("C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\Saran\\Saran\\outputScreenShot");
 		if (!screenshotDir.exists()) {
 		    screenshotDir.mkdirs();
 		}
 	}
}
