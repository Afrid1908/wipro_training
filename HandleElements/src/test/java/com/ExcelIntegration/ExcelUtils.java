package com.ExcelIntegration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook workbook;
	private static Sheet sheet;
	private static String filePath;
	
	//loading Excel file
	public static void loadExcel(String path, String sheetName) throws IOException {
		filePath = path;
		FileInputStream finput = new FileInputStream(path);
        workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetName);
		finput.close();
	}
	
	//Get total rows
	public static int getRowCount() {
		return sheet.getLastRowNum();
	}
	
	//reading cell data
	public static String getCellData(int rowNum, int colNum) {
		Row row = sheet.getRow(rowNum);
		if(row == null)
			return "";
		Cell cell = row.getCell(colNum);
		if(cell == null)
			return "";
		
		return cell.toString();	
	}
	
	//write pass/fail result with color
	public static void writeResult(int rowNum, int colNum, String result) throws IOException {
		Row row = sheet.getRow(rowNum);
		if(row==null) {
			row = sheet.createRow(rowNum);
		}
		
		Cell cell = row.createCell(colNum);
		cell.setCellValue(result);
		
		CellStyle style = workbook.createCellStyle();
		
		//Setting the color for result
		if(result.equalsIgnoreCase("PASS")) {
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}else if(result.equalsIgnoreCase("FAIL")) {
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		
		FileOutputStream fout = new FileOutputStream(filePath);
		workbook.write(fout);
		fout.close();
	}
	
	//close workbook
	public static void closeWorkbook() throws IOException {
		if(workbook != null) {
			workbook.close();
		}
	}
}
