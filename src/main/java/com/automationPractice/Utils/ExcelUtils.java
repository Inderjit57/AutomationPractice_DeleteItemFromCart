package com.automationPractice.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automationPractice.BasePackage.TestBase;

public class ExcelUtils extends TestBase {
	// All the Excel Classes are coming from Apache Poi dependency
	
	// Identify Excel file in the directory
	public static FileInputStream fi;

	// Identify Workbook in Excel:
	public static XSSFWorkbook wb;

	// Identify Excel sheet in the workbook
	public static XSSFSheet ws;

	// Identify Rows in excel sheet
	public static XSSFRow wr;

	// Identify Cell in a row
	public static XSSFCell wc;

	// Get the Maximum active rows in a sheet
	public static int getRowCount(String filePath, String sheetName) throws IOException {
		int rowCount = 0;
		fi = new FileInputStream(filePath);

		// Initialize the workbook at a location mentioned in FileInputStream
		wb = new XSSFWorkbook(fi);
		// get the sheetName from the location
		ws = wb.getSheet(sheetName);
		// get the last row so it can identify last filled row for the active sheet
		rowCount = ws.getLastRowNum();

		wb.close();
		fi.close();
		logger.info("The Row count is " + rowCount);
		return rowCount;
	}

	// // Get the Maximum active Cells in a sheet
	public static int getCellCount(String xFile, String xSheet, int rowno) throws IOException {

		int colCount;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);
		
		// To work on a particular Row in a sheet, initialize the row 
		wr = ws.getRow(rowno);
		
		colCount = wr.getLastCellNum();

		wb.close();

		fi.close();

		System.out.println("Column count is  : " + colCount);

		return colCount;

	}

	// Get Cell Data form active row
	@SuppressWarnings("deprecation")
	public static String getCellData(String xFile, String xSheet, int rowno, int colno) throws IOException {

		String data;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);

		wr = ws.getRow(rowno);

		wc = wr.getCell(colno);

		wc.setCellType(wc.CELL_TYPE_STRING);
		
		// Get the value from the cell and return type is String
		data = wc.getStringCellValue();

		return data;

	}

}
