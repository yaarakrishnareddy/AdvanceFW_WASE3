package practice;

import org.testng.annotations.Test;

public class ReadDataFromMvnCommend {

	@Test
	public void readData()
	{
	String URL=	System.getProperty("url");
	System.out.println(URL);
	String Browser=	System.getProperty("browser");
	System.out.println(Browser);
	String USN=	System.getProperty("username");
	System.out.println(USN);
	String PASS=	System.getProperty("password");
	System.out.println(PASS);
	}
}
