package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step:1 open the document in java readable format
		
		  FileInputStream file=new FileInputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
		  
		//step:2 create a WorkBook 
		  
		   Workbook book=WorkbookFactory.create(file);
		
		//step:3 get Control of Sheet
		   
		   Sheet sh = book.getSheet("Org");
		   
		//step:4 get Control of row

		    Row   r  = sh.getRow(0);
		    
		//step:5 get Control of Cell

	       Cell  c =r.getCell(2);
	       
	   //step:6 Read the data inside the cell
	       
	    String s=   c.getStringCellValue();
	       
	       System.out.println(s);
	       
	       //other way
	       
	     //  String s =  sh.getRow(0).getCell(2).getStringCellValue();
	      // System.out.println(s);
	       
	  
	      

	}

}
