package practice;

import java.io.IOException;

import VtigerGenericUtility.ExcelfileUtility;
import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.PropertiFileUtility;

public class GenericUtitlityPracties {

	public static void main(String[] args) throws IOException {
		PropertiFileUtility pf=new PropertiFileUtility();
		String URL=pf.readDataFromPropertyFile("url");
		System.out.println(URL);
		
         ExcelfileUtility ex=new ExcelfileUtility();
    //   System.out.println(ex.getreadExcelSheet("Customer", 4, 2));
    String s=   ex.getreadExcelSheet("Customer", 4, 2);
            System.out.println(s);
            
           int s1= ex.getrowcount("Org");
             System.out.println(s1);
             
             JavaUtility ju=new JavaUtility();
     System.out.println(ju.systemDate());
	
	System.out.println(ju.getSystemDateFormet());
	}
}
