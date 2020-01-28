package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibUtils implements IAutoConstnt{
	public String read_XL_Data(String sheetname, int row, int cell) throws EncryptedDocumentException, FileNotFoundException, IOException {
		String data="";
		Workbook wb=WorkbookFactory.create(new FileInputStream(getDataFromPropertyFile("EXCELPATH")));
		data=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return data;
	}
	
	public int read_XL_RowCount(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException {
		int rc=0;
		Workbook wb=WorkbookFactory.create(new FileInputStream(getDataFromPropertyFile("EXCELPATH")));
		rc=wb.getSheet(sheetname).getPhysicalNumberOfRows();
		return rc;
	}
	public int read_XL_ColumnCount(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException {
		int cc=0;
		Workbook wb=WorkbookFactory.create(new FileInputStream(getDataFromPropertyFile("EXCELPATH")));
		cc=wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
		return cc;
	}
	
	public Object[][] dataInput(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException{
		int rowCount=read_XL_RowCount(sheetname);
		int colCount=read_XL_ColumnCount(sheetname);
		Object[][] data=new Object[rowCount-1][colCount];
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i-1][j]=read_XL_Data(sheetname, i, j);
			}
		}
		return data;
	}
	
	public int  write_XL_Data(String sheet, int row, int cell, int value) throws Exception, FileNotFoundException, IOException {
		Workbook wb=WorkbookFactory.create(new FileInputStream(getDataFromPropertyFile("EXCELPATH")));
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		wb.write(new FileOutputStream(getDataFromPropertyFile("EXCELPATH")));
		return value;
	}
	
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fObj=new FileInputStream("./dataResources/common.properties");
		Properties pObj = new Properties();
		pObj.load(fObj);
		return pObj.getProperty(key);
	}
}
