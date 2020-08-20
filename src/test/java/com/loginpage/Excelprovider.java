package com.loginpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelprovider 
{
	XSSFWorkbook wb;

	public Excelprovider() throws Exception 
	{
		try {
			File src = new File("F:\\ramya_selenium\\maven_proj\\Testdata\\data.xlsx");
			FileInputStream file = new FileInputStream(src);
			wb = new XSSFWorkbook(file);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public String getstringdata(String sheetname, int row, int cell)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

}
