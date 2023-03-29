package TestNg;

import java.io.IOException;
import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Vtiger.ObjectRepo.Homepage;
import Vtiger.ObjectRepo.LoginPage;
import VtigerGenericUtility.ExcelfileUtility;
import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.PropertiFileUtility;
import VtigerGenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass_1 {
	
public 	PropertiFileUtility putil=new PropertiFileUtility();
public	ExcelfileUtility    eutil=new ExcelfileUtility();
public	WebDriverUtility    wutil=new WebDriverUtility();
public	    JavaUtility     jutil=new JavaUtility();
public static WebDriver driver=null;

@BeforeSuite(groups = { "SmokeSuite","RegrestionSuite"})
    public void Connectiondataase()
{
	System.out.println("successfully connetcted");
}
	//@Parameters("browser")
//	@BeforeTest
@BeforeClass(groups = { "SmokeSuite","RegrestionSuite"})
	public void lanchthebrowser() throws IOException
	{
	String bro=	 putil.readDataFromPropertyFile("browser");
	String Url=putil.readDataFromPropertyFile("url");
		if(bro.equalsIgnoreCase("Edge"))
		{
		 //  System.setProperty("webdriver.edge.driver", "D:\\SeleniumKittu\\msedgedriver.exe");
		   driver=new EdgeDriver();
		}
		if(bro.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		driver.get(Url);
		System.out.println("urlopen");
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegrestionSuite"})
	public void loginpage() throws IOException
	{
String UNM	=putil.readDataFromPropertyFile("username");
String pAW	=putil.readDataFromPropertyFile("password");
	LoginPage l=new LoginPage(driver);
			l.loginToApp(UNM, pAW);
			System.out.println("successlogin");
		}
	
	@AfterMethod(groups = {"SmokeSuite","RegrestionSuite"})
	public void Logut()
	{
		Homepage h=new Homepage(driver);
		h.signOutPage(driver);
		System.out.println("logutsuccess");
	}
	
	@AfterClass(groups = { "SmokeSuite","RegrestionSuite"})
	public void closebrowser() {
		driver.quit();
		System.out.println("successfull close");
	}
	
	@AfterSuite(groups = { "SmokeSuite","RegrestionSuite"})
	public void closedatabase()
	{
		System.out.println("closedatabase");
	}
}
