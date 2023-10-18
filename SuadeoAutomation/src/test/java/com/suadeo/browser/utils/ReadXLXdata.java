package com.suadeo.browser.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ReadXLXdata {

//	public static void main(String[] args) throws EncryptedDocumentException,IOException {
//		
//		ReadXLXdata red = new ReadXLXdata();
//		red.getData("login");
//
//
//	}
	
	@DataProvider(name="Login")
	public String[][] getData(Method method) throws EncryptedDocumentException, IOException
	{
		
		String excelSheetName = method.getName();
		 // Specify the path of file
		File f = new File(System.getProperty("user.dir")+"//src//test//resources//testdata//testdata.xlsx");
		
		  // load file
		FileInputStream fis = new FileInputStream(f);
		// Load workbook
		Workbook wb = WorkbookFactory.create(fis);
		// Load sheet- Here we are loading first sheetonly
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println("Total number of rows: "+totalRows);
		Row rowcells = sheetName.getRow(0);

		
		int totalcols = rowcells.getLastCellNum();
		System.out.println("Total number of colums: "+totalcols);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalcols];
		
//		System.out.println(sheetName.getRow(1).getCell(0).getStringCellValue());
//
//		 System.out.println(sheetName.getRow(1).getCell(1).getStringCellValue());
//
//		 System.out.println(sheetName.getRow(2).getCell(0).getStringCellValue());
//
//		 System.out.println(sheetName.getRow(2).getCell(1).getStringCellValue());
//
//		 System.out.println(sheetName.getRow(3).getCell(0).getStringCellValue());
//
//		 System.out.println(sheetName.getRow(3).getCell(1).getStringCellValue());
//		 
//		 System.out.println(sheetName.getRow(4).getCell(0).getStringCellValue());
//
//		 System.out.println(sheetName.getRow(4).getCell(1).getStringCellValue());
		
		
		
		for(int i=1;i<=totalRows;i++)
		{

			
			for(int j=0;j<totalcols;j++)
		
			{
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		
		return testData;


	}

}
