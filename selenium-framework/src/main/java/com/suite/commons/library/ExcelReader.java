package com.suite.commons.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	//private static HSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
	
	public static String[][] getExcelTableArray(String FilePath, String SheetName)    throws Exception
	{   
	   String[][] tabArray = null;
	   try{
		   System.out.println("*************** getExcelTableArray - File path - "+FilePath);
		   FileInputStream ExcelFile = new FileInputStream(FilePath);
		   // Access the required test data sheet
		   ExcelWBook = new XSSFWorkbook(ExcelFile);
		   ExcelWSheet = ExcelWBook.getSheet(SheetName);
		   int totalRows = getUsedRows()+1;
		   int totalCols = getUsedColumns();
		   tabArray=new String[totalRows][totalCols];
		   for(int intRowCounter =0;intRowCounter<totalRows;intRowCounter++){
			   for (int intColCounter=0;intColCounter<totalCols;intColCounter++)
			   {
				   tabArray[intRowCounter][intColCounter]=getCellData(intRowCounter,intColCounter);
			   }
		   }
		}
		catch (FileNotFoundException e)
		{
			System.out.println("!!!!!!!!!!!!!!! Excel File with class name not found, probably you have mentioned excel data provider to TestMethod but excel file not provided or incorrectly provided");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return(tabArray);
	}

	
	
	public static int getUsedRows() throws Exception {
		try{
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	public static int getUsedColumns() throws Exception {
		try{
			int ColCount = ExcelWSheet.getRow(0).getLastCellNum();
			return ColCount;
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		   try{
			  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			  String CellData = Cell.getStringCellValue();
			  return CellData;
			  }catch (Exception e){
				return"";
				}
			}

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		   try {
				FileInputStream ExcelFile = new FileInputStream(Path);
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
				} catch (Exception e){

					throw (e);
				}
		}

}
