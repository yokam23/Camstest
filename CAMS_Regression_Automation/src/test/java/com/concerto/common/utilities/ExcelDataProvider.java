package com.concerto.common.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class ExcelDataProvider {
	
	private static HSSFSheet ExcelWSheet;

	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;

	public static Object[][] getTableArray(String FilePath, String ClassName) throws Exception {   

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

					   tabArray[ci][cj]=getCellData(i,j);

//					   System.out.println("data in cell" +i+","+j+" : "+tabArray[ci][cj]);  

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

					String CellData = Cell.getStringCellValue();
					System.out.println(CellData);
					return CellData;

//				}
			}catch (Exception e){

				System.out.println(e.getMessage());

				throw (e);

				}

			}

}
