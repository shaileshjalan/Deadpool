package frontpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class readexcel {
File src;
FileInputStream fis;
XSSFWorkbook wb;
XSSFSheet sheet1;
String path;
String sheetname;
String	data;

@Test
public readexcel(String path, String sheetname)
{
	this.path=path;
	this.sheetname=sheetname;

}

public String readExecl(int row , int cel) {
	 src=new File(path);
	
	try {
		fis = new FileInputStream(src);
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	
	try {
		wb = new XSSFWorkbook(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
//String value
	sheet1=wb.getSheet(sheetname);
	
	if(sheet1.getRow(row).getCell(cel).getCellType()==XSSFCell.CELL_TYPE_STRING)
	{
	data=sheet1.getRow(row).getCell(cel).getStringCellValue();
		   }
	else if(sheet1.getRow(row).getCell(cel).getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
	{
		double d=sheet1.getRow(row).getCell(cel).getNumericCellValue();
		long i=(long)d;
		data=String.valueOf(i);
	}

	else if(sheet1.getRow(row).getCell(cel).getCellType()==XSSFCell.CELL_TYPE_BLANK)
	{
		data="";
	}
    
	return data ;

	}

}
	




