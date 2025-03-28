package DataProviderUtility;

import org.testng.annotations.DataProvider;

import FileUtility.ExcelUtilityClass;

public class DP_Utility {
	

		@DataProvider(name = "datafromExcelforNexus")
		public Object[][] getdatafromdataProvider() throws Throwable {
			ExcelUtilityClass elib = new ExcelUtilityClass();
			int rowcount = elib.getRowCount("Products");
			System.out.println(rowcount);
			Object[][] objArr = new Object[rowcount][2];
			for (int i = 0; i < rowcount; i++) {

				objArr[i][0] = elib.getDataFromExcel("Products", i + 1, 0);
				
				objArr[i][1] = elib.getDataFromExcel("Products", i + 1, 1);

			}
			return objArr;
		}
	}



