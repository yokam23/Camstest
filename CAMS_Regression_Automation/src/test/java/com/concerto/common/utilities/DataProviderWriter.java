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

public class DataProviderWriter {
	
	/**
	 * @author abhijit.bhattacharya
	 */
	
	private static HSSFSheet excelWSheet;
	private static HSSFWorkbook excelWBook;	
	
	/**
	 * To set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	 * @param filePath
	 * @param sheetName
	 */
	public static void setExcelFile(String filePath, String sheetName) {
	   try {
				FileInputStream excelFile = new FileInputStream(filePath);
				excelWBook = new HSSFWorkbook(excelFile);
				excelWSheet = excelWBook.getSheet(sheetName);
		
			} catch (Exception e){
				Logger.logConsoleMessage("Error while opening TestData file.");
			}
	}
	
	/**
	 * To read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	 * @param rowNo
	 * @param colNo
	 * @return cellData
	 */
	public static String getCellData(int rowNo, int colNo) {
		 String cellData = null;
		 
		 try {
				 FormulaEvaluator evaluator = excelWBook.getCreationHelper().createFormulaEvaluator();
				 HSSFCell cell = excelWSheet.getRow(rowNo).getCell(colNo);
				 cell.setCellType(CellType.STRING);
				 CellValue cellValue = evaluator.evaluate(cell); 
				 cellData = cellValue.getStringValue().toString();
				 if (cellData.isEmpty())
					 cellData = ""; 
				 
		 } catch (Exception e) {
			 cellData = "";
		 }
	
		 return cellData;
	}
	
	/**
	 * To set the test data in the Excel cell, in this we are passing parameters as Row num and Col num
	 * @param rowNo
	 * @param colNo
	 * @return cellData
	 */
	public static void setCellData(int rowNo, int colNo, Object obj) {
		Cell cell=null;
		try {
		cell = excelWSheet.getRow(rowNo).createCell(colNo);
		}catch(Exception e1) {
			cell = excelWSheet.getRow(rowNo).getCell(colNo);
		}
		
		 if(obj instanceof Date) 
			 cell.setCellValue((Date)obj);
		 else if(obj instanceof Boolean)
			 cell.setCellValue((Boolean)obj);
		 else if(obj instanceof String)		        
			 cell.setCellValue((String)obj);		          				        		         
		 else if(obj instanceof Integer)
			 cell.setCellValue((Integer)obj);
		 else if(obj instanceof Double)
			 cell.setCellValue((Double)obj);		      					        	
	}
	
	/**
	 * To verify TestCase Id existance
	 * @param testCaseName
	 * @param colNum
	 * @return rowNo
	 */
	public static int getRowContainsTestCaseId(String testCaseId, int colNo){
		int rowNo;
		int rowCount = excelWSheet.getLastRowNum();
		for (rowNo=1;rowNo<=rowCount;rowNo++)
			if (getCellData(rowNo, colNo).equalsIgnoreCase(testCaseId))
				break;
	
		return rowNo;
	 }

	 /** To fetch colno based on TestCase Name existance
	 * @param testCaseName
	 * @param colNum
	 * @return
	 */
	public static int getColContains(String colName){
		int colNo;
		int colCount = excelWSheet.getRow(0).getLastCellNum();
		
		for (colNo=0;colNo<colCount;colNo++){
			if(getCellData(0,colNo).equals(colName)){
				break;
			}
		}
	
		return colNo;
	 }
	 
	/**
	 * To get the module name
	 * @param className
	 * @return
	 */
	public static String getModuleName(String packageName) {
		String upPackage= packageName.replace(".", "_");
		String moduleName = upPackage.split("_")[upPackage.split("_").length-1];
		return moduleName;
	}
	
	/**
	 * To get the Test Case Id
	 * @param className
	 * @return
	 */
	public static String getTestCaseId(String className) {
		String testCaseID = className;
		return testCaseID;
	}
	
	/**
	 * To fetch the test data
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> getTestData(String TEST_DATA_FILE_PATH, String className,String Package) {
		String sheetName;
		int totalCols, testCaseRow, startCol=0;
		String testCaseId;
		Map<String, String> testData = new LinkedHashMap<String, String>();	
		
		sheetName = getModuleName(Package);
	    testCaseId = getTestCaseId(className);
		System.out.println(sheetName+"____"+testCaseId);
		setExcelFile(TEST_DATA_FILE_PATH, sheetName);
		testCaseRow = getRowContainsTestCaseId(testCaseId, 0);
		totalCols = excelWSheet.getRow(0).getLastCellNum();
		
		for (int j=startCol;j<=totalCols-1;j++)
		{
			testData.put(getCellData(0,j), getCellData(testCaseRow,j));
	    }
		return testData;
	  }
	
	/**
	 * To update the test data file
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public static void setTestData(String TEST_DATA_FILE_PATH,String className,int rowNo, String colName, Object value) {
		FileOutputStream fout=null;
		
		String sheetName = getModuleName(className);
	    
		setExcelFile(TEST_DATA_FILE_PATH, sheetName);
		int colNo = getColContains(colName);
		System.out.println("Column Number is: "+ colNo);
		setCellData(rowNo, colNo, value);
		
		try {
			fout = new FileOutputStream(new File(TEST_DATA_FILE_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			excelWBook.write(fout);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }


}
