package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// To Create obj of FIS
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");

		// Create obj of Workbook
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Contacts");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		String value = cell.getStringCellValue();
		System.out.println(value);
	}

}
