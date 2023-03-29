package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertiesfiles {

	public static void main(String[] args) throws IOException {
		
  //Step:1  open the file in java radable format
		
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
		
  //Step:2 Create object of properties from java.util.pakage
		
        Properties p=new Properties();
    
  //Step:3  load the stream input file into Properties
    
        p.load(file);
    
  //Step:4 Access values with keys
    
           String URL =  p.getProperty("url");
           String BRO =  p.getProperty("browser");
           String USN =  p.getProperty("username");
           String PAW =  p.getProperty("password");
  
  //Step:5 Print 
           System.out.println(URL);
           System.out.println(BRO);
           System.out.println(USN);
           System.out.println(PAW);

  
    
    
	}

}
