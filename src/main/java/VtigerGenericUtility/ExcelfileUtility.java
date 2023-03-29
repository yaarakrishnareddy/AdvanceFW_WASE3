package VtigerGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author HP 840 G3
 *
 */
public class ExcelfileUtility {
	/**
	 * 
	 * @param data
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
	public String getreadExcelSheet(String data,int row,int cell) throws IOException
	{
		FileInputStream filee=new FileInputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
           Workbook	wb=	WorkbookFactory.create(filee);
       Sheet sh= wb.getSheet(data);
         Row r=sh.getRow(row);
             Cell c=r.getCell(cell);
          String Data=c.getStringCellValue();
            wb.close();
           return Data;
	}
	public int getrowcount(String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
  Workbook wb= WorkbookFactory.create(file);
	 Sheet sh = wb.getSheet(data);
	int Data  = sh.getLastRowNum();
	        wb.close();
	return Data;
		}
	public Object[][] getDataProvied(String sheet) throws IOException
	{
	FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
	Workbook  wb=WorkbookFactory.create(file);
	Sheet sh= wb.getSheet(sheet);
	int  lastRow= sh.getLastRowNum();
	int  lastCell=sh.getRow(0).getLastCellNum();
	Object[][] data=new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
		data[i][j]	=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return data;
	}

}
