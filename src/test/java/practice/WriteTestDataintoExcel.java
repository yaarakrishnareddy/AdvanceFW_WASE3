package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteTestDataintoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
 Workbook book= WorkbookFactory.create(file);
 Sheet sh=book.getSheet("Org");
     Row r= sh.getRow(4);
        Cell c=  r.createCell(5);
     c.setCellValue("yaara");
     FileOutputStream file1=new FileOutputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
     book.write(file1);
     System.out.println("added data");
	}

}
