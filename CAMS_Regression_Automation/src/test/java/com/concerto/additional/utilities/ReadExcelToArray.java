package com.concerto.additional.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

import com.concerto.common.utilities.ExcelDataProvider;

public class ReadExcelToArray {
	
	private static HSSFSheet ExcelWSheet;

	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;
		
		public static String getModuleName(String className) {
			String moduleName = className;
			return moduleName;
		}
		
		public static String getCellData(int RowNum, int ColNum) throws Exception {

			try{

				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

//				int dataType = Cell.getCellType();

//				if  (dataType == 3) {

					//return "";

//				}else{
				try {

					String CellData = Cell.getStringCellValue();

					return CellData;
				}catch(IllegalStateException e) {
					try {
					String CellData = Cell.getDateCellValue().toString();
					return CellData;
					}catch(IllegalStateException e1) {
						double CellData = Cell.getNumericCellValue();
						return Double.toString(CellData);
					}

				}
			}catch (Exception e){

				System.out.println(e.getMessage());

				throw (e);

				}

			}
		
		public static String[][] getTableArray(String FilePath, String ClassName) throws Exception {   

			String SheetName = getModuleName(ClassName);
			   String[][] tabArray = null;

			   try {

				   FileInputStream ExcelFile = new FileInputStream(FilePath);

				   // Access the required test data sheet

				   ExcelWBook = new HSSFWorkbook(ExcelFile);

				   ExcelWSheet = ExcelWBook.getSheet(SheetName);

				   int startRow = 1;

				   int startCol = 0;

				   int ci,cj;

				   int totalRows = ExcelWSheet.getLastRowNum();

				   // you can write a function as well to get Column count

				   int totalCols = ExcelWSheet.getRow(1).getLastCellNum();

				   tabArray=new String[totalRows][totalCols];

				   ci=0;

				   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

					  cj=0;

					   for (int j=startCol;j<totalCols;j++, cj++){

						   tabArray[ci][cj]=getCellData(i,j).toString();

						   System.out.println(tabArray[ci][cj]);  

							}

						}

					}

				catch (FileNotFoundException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}

				catch (IOException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}

				return(tabArray);

				}
		
		public static List<List<String>> ArrayToArrayList(String[][] tabArray) {
			
			List<List<String>> collection = Arrays.stream(tabArray)  //'array' is two-dimensional
				    .map(Arrays::asList)
				    .collect(Collectors.toList());
			return collection;
		}
		
		@Test
		public void demotest() throws Throwable {
			String[][] tabArray = getTableArray("Resources/SimulatorData.xls", "Sheet1");
			WriteArrayToText.ArrayToText(tabArray, "src/test/resources/com/simulator/files/NewDownList.txt");
		}

}
