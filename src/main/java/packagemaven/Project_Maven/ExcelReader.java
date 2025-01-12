package packagemaven.Project_Maven;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

	@DataProvider(name = "data1")
	public Object[][] registrationData() throws EncryptedDocumentException, IOException {

		FileInputStream file1 = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\Project_Maven\\Vishal007.xlsx");
		Workbook w1 = WorkbookFactory.create(file1);
		Object input1[][] = new Object[1][3];

		for (int i = 0; i < input1.length; i++) {

			String fullnamevalue = w1.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			String mobilenumbervalue = NumberToTextConverter
					.toText(w1.getSheet("Sheet1").getRow(i).getCell(1).getNumericCellValue());
			String passwordvalue = w1.getSheet("Sheet1").getRow(i).getCell(2).getStringCellValue();

			input1[i][0] = fullnamevalue;
			input1[i][1] = mobilenumbervalue;
			input1[i][2] = passwordvalue;
		}
		return input1;

	}
	@DataProvider(name = "data2")
	public Object [][] loginData() throws EncryptedDocumentException, IOException {
		FileInputStream file2 = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\Project_Maven\\Vishal007.xlsx");
		Workbook w2 = WorkbookFactory.create(file2);
		Object input2[][] = new Object[1][2];

		for (int j = 0; j < input2.length; j++) {

			String loginid = NumberToTextConverter.toText(w2.getSheet("Sheet2").getRow(j).getCell(0).getNumericCellValue());
			String loginpassword = w2.getSheet("Sheet2").getRow(j).getCell(1).getStringCellValue();
			

			input2[j][0] = loginid;
			input2[j][1] = loginpassword;
			
		}
		return input2;
		
	}
}
