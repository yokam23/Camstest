package com.concerto.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportReader {
	
	
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	public static Object[][] getTableArray(String FilePath, String sheetName,int StartRow,int RowCount, int ColumnCount) throws Exception {   

		String SheetName = getModuleName(sheetName);
		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   ExcelWBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWBook.getSheet(SheetName);

			   int startRow = StartRow;

			   int startCol = 0;

			   int ci,cj;

			   int totalRows = StartRow+RowCount;

			   // you can write a function as well to get Column count

			   int totalCols = ColumnCount;

			   tabArray=new String[RowCount+1][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<totalCols;j++, cj++){

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println("data in cell" +i+","+j+" : "+tabArray[ci][cj]);  

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
