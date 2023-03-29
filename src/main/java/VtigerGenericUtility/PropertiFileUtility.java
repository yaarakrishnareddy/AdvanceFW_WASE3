package VtigerGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this is consist of read data from property file
 * @author HP 840 G3
 *
 */
public class PropertiFileUtility {
	/**
	 * this is method will  readDataFromPropertyFile
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream filep=new FileInputStream(IconstantUtility.propertiesfilepath);
		Properties p=new Properties();
		p.load(filep);
    String data=p.getProperty(Key);
       return data;
	
	}

}
