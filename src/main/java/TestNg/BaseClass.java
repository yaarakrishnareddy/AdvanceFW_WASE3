package TestNg;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Vtiger.ObjectRepo.Homepage;
import Vtiger.ObjectRepo.LoginPage;
import VtigerGenericUtility.ExcelfileUtility;
import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.PropertiFileUtility;
import VtigerGenericUtility.WebDriverUtility;

public class BaseClass {
public 	PropertiFileUtility putil=new PropertiFileUtility();
public	ExcelfileUtility    eutil=new ExcelfileUtility();
public	WebDriverUtility    wutil=new WebDriverUtility();
public	    JavaUtility     jutil=new JavaUtility();
public static  WebDriver driver=null;
 @BeforeSuite(groups = "SmokeSuite")
           public void Connectiondataase()
{
	System.out.println("successfully connetcted");
}
	
@BeforeClass(groups = "SmokeSuite")
	public void lanchthebrowser() throws IOException
	{
	String bro=	 putil.readDataFromPropertyFile("browser");
	String Url=  putil.readDataFromPropertyFile("url");
	if(bro.contains("Edge"))
	{
		driver =new EdgeDriver();
	}
	
		driver.get(Url);
	wutil.Waitforimplicity(driver);
		System.out.println("urlopen");
	}
	@BeforeMethod(groups = "SmokeSuite")
	public void loginpage() throws IOException, InterruptedException
	{
String UNM	=putil.readDataFromPropertyFile("username");
String pAW	=putil.readDataFromPropertyFile("password");
	LoginPage l=new LoginPage(driver);
			l.loginToApp(UNM, pAW);
			System.out.println("successlogin");
			
	}
	@AfterMethod(groups = "SmokeSite")

	public void Logut()
	{
		Homepage h=new Homepage(driver);
		h.signOutPage(driver);
		System.out.println("logutsuccess");
	}
	
	@AfterClass(groups = "SmokeSuite")
	public void closebrowser() {
		driver.quit();
		System.out.println("successfull close");
	}
	
	@AfterSuite(groups = "SmokeSuite")
	public void closedatabase()
	{
		System.out.println("closedatabase");
	}
}



