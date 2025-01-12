package packagemaven.Project_Maven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelSHeet_Data 
{
	static String fullnamevalue;
	static String mobilenumbervalue;
	static String passwordvalue ;
	static String unsername1;
	static String password1 ;
	
	void datafetching() throws EncryptedDocumentException, IOException
	{
		FileInputStream file1 = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\Project_Maven\\Vishal007.xlsx");
		Workbook w1 = WorkbookFactory.create(file1);
		

			 fullnamevalue = w1.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
			 mobilenumbervalue = NumberToTextConverter
					.toText(w1.getSheet("Sheet1").getRow(0).getCell(1).getNumericCellValue());
			 passwordvalue = w1.getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();
			 
			 unsername1 = NumberToTextConverter.toText(w1.getSheet("Sheet2").getRow(0).getCell(0).getNumericCellValue());
			 password1 = w1.getSheet("Sheet2").getRow(0).getCell(1).getStringCellValue();
						
		
	}
}
