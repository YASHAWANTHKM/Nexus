package FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityClass {
	
		public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
			FileInputStream fis = new FileInputStream("./src/test/resources/Data_for_Automation .xlsx");
			Workbook Book = WorkbookFactory.create(fis);
			String data = Book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			Book.close();
			return data;

		}

		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis = new FileInputStream("./src/test/resources/Data_for_Automation .xlsx");
			Workbook Book = WorkbookFactory.create(fis);
			int data = Book.getSheet(sheetName).getLastRowNum();
			Book.close();
			return data;
		}

		@SuppressWarnings("deprecation")
		public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
			FileInputStream fis = new FileInputStream("./src/test/resources/Data_for_Automation .xlsx");
			Workbook Book = WorkbookFactory.create(fis);
			Cell cell = Book.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream("./src/test/resources/Data_for_Automation .xlsx");
			Book.write(fos);
			Book.close();

		}

	


}
