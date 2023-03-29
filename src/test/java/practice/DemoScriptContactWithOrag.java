package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import VtigerGenericUtility.ExcelfileUtility;
import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.PropertiFileUtility;
import VtigerGenericUtility.WebDriverUtility;

public class DemoScriptContactWithOrag {

	public static void main(String[] args) throws IOException {
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		PropertiFileUtility putil=new PropertiFileUtility();
	String Brow=	putil.readDataFromPropertyFile("browser");
	String URL=	putil.readDataFromPropertyFile("url");
	String UNM=putil.readDataFromPropertyFile("username");
	String PAW= putil.readDataFromPropertyFile("password");
	ExcelfileUtility eutil=new ExcelfileUtility();
         String LastName=	eutil.getreadExcelSheet("Customer", 1, 2);
         String Org=eutil.getreadExcelSheet("Org", 1, 2)+jutil.getRandomNumber();

WebDriver driver=null;
  if(Brow.equalsIgnoreCase("Chrome")) 
  {
	  driver=new ChromeDriver();
  }
  driver.get(URL);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
  driver.findElement(By.name("user_name")).sendKeys(UNM);
	driver.findElement(By.name("user_password")).sendKeys(PAW);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(Org);
	driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
String com=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(com.contains(Org))
{
	System.out.println(com+"---pass");
}
else
{
	System.out.println("fail");
}
	WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions ac=new Actions(driver);
	ac.moveToElement(ele).perform();

	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
        wutil.switchToWindow(driver,"Accounts");
        driver.findElement(By.name("search_text")).sendKeys(Org);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.linkText(Org)).click();
       wutil.switchToWindow(driver, "Contacts");
       driver.findElement(By.name("button")).click();
  String CON=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  if(CON.contains(LastName))
  {
	  System.out.println("pass");
  }
  else
  {
	 System.out.println("fail");
  }
 WebElement ele1=  driver.findElement(By.xpath("(//td[@class='small'])[2]"));
 ele1.click();
   wutil.mouseoverActionClass(driver, ele1);
   driver.findElement(By.linkText("Sign Out")).click();
   driver.quit();
   
	}

}
