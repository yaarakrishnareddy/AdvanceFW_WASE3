package VtigerGenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public String systemDate()
	{
		Date d=new Date();
     return	d.toString();
	}
public String getSystemDateFormet()
{
	Date d=new Date();
         String date[]=	d.toString().split(" ");
                 String month= date[1];
        		 String date1= date[2];	
        		 String time = date[3].replace(":", "-")	;
        		 String year = date[5];
        String filedata= month+" "+date1+" "+ time+" "+year;
        return filedata;
}
/**
 * This method will return a random number for every run
 * @return
 */
public int getRandomNumber() {
	Random r=new Random();
	return r.nextInt(1000);
}
}
