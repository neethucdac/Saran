package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;// This is used to obtain input bytes from the file. 
 	// It represents the file input stream for reading data from the Excel file. 
 	static XSSFWorkbook w;// This represents the workbook instance, which refers to the entire Excel file. 
 	static XSSFSheet sh;// class representing the sheet in an XLSX file. 
  
 	public static String readStringData(int row, int col, String sheet) throws IOException { 
 		String filepath = Constant.TESTDATAFILE; 
 		//System.out.println("username");
 		f = new FileInputStream(filepath);// obtaining input bytes from a file 
 		w = new XSSFWorkbook(f);// creating workbook instance that refers to the xlsx file 
 		sh = w.getSheet(sheet);// Retrieves the specified sheet named "Sheet1" 
 		XSSFRow r = sh.getRow(row);// retrieves specified row 
 		//System.out.println(r);

 		XSSFCell c = r.getCell(col);// retrieves specified column 
 		System.out.println(c.getStringCellValue());
 		return c.getStringCellValue();// retrieves cell string value 
 	} 
  
 	public static String readIntegerData(int row, int col, String sheet) throws IOException { 
 		String filepath = Constant.TESTDATAFILE; 
 		f = new FileInputStream(filepath); 
 		w = new XSSFWorkbook(f); 
 		sh = w.getSheet(sheet); 
 		XSSFRow r = sh.getRow(row); 
 		XSSFCell c = r.getCell(col); 
// 		int val = (int) c.getNumericCellValue(); // Retrieves and casts the numeric cell value to an integer
// 		System.out.println(String.valueOf(val));
// 		return String.valueOf(val); // Converts the integer value to a string and returns it
// 		
 		 // Check if the cell type is numeric
 	    if (c.getCellType() == CellType.NUMERIC) {
 	        // Use DataFormatter to convert numeric value to String
 	        DataFormatter formatter = new DataFormatter();
 	        String value = formatter.formatCellValue(c);
 	        System.out.println("Value: " + value);
 	        return value; // Returns the value as a String
 	    } else {
 	        throw new IllegalArgumentException("Cell does not contain numeric data.");
 	    }
}
 	
 	 // Read an entire column as a List<String>
    public static List<String> readColumnData(int col, String sheet) throws IOException {
        List<String> data = new ArrayList<>();
        String filepath = Constant.TESTDATAFILE;
        f = new FileInputStream(filepath);
        w = new XSSFWorkbook(f);
        sh = w.getSheet(sheet);

        int rowCount = sh.getLastRowNum(); // Get total rows

        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = sh.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(col);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    data.add(cell.getStringCellValue().trim());
                }
            }
        }

        w.close();
        f.close();
        return data;
    }
 	
 	
}