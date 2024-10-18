package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic method related to excel file
 * 
 * @author kiran
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will Read the data from excel
	 * 
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String toReadDataFromExcel(String sheetname, int row, int cell)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath );
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	/**
	 * This method will get the total row utilized
	 * 
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowcount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		return rowCount;
	}
}
