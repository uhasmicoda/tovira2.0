package com.geneuineCare.healthCare.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromEXcel(String path, String sheet, int indexRow, int indexCell)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet she = wb.getSheet(sheet);
		Row row = she.getRow(indexRow);
		String data = row.getCell(indexCell).toString();
		return data;
	}

	public int getLastRow(String path, String sheet) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int rowNum = wb.getSheet(sheet).getLastRowNum();
		return rowNum;
	}

	public void setDataIntoExcel(String path, String sheet, int index, String vlaue) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet She = wb.getSheet(sheet);
		Row row = She.getRow(index);
		Cell cell = row.createCell(index);
		cell.setCellValue(vlaue);
		wb.close();
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		

	}
}
