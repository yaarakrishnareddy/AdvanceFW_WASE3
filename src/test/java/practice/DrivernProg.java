package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrivernProg {
	
        	public static void main(String[] args) throws IOException {
   FileInputStream f=new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
		      Properties p=new Properties();
		        p.load(f);
           String URL   =	p.getProperty("url");
           String PAW   =	p.getProperty("username");
           String USN   =  p.getProperty("password");
           WebDriver driver=new ChromeDriver();
        driver.get(URL);
  driver.findElement(By.name("user_name")).sendKeys(USN,Keys.TAB,PAW,Keys.ENTER);
  driver.findElement(By.linkText("Contacts")).click();
  driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

  FileInputStream f2=new FileInputStream(".\\src\\test\\resources\\Exelfile1.xlsx");
        Workbook wb=WorkbookFactory.create(f2);
  Sheet sh=  wb.getSheet("Customer");
         Row r=  sh.getRow(1);
  Cell c=r.getCell(2);
      String s= c.getStringCellValue();
 
  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(s);
	driver.findElement(By.name("button")).click();
	  String con=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(con.contains(s))
	{
		System.out.println(con+"--pass");
	}
	else
	{
		System.out.println("not pass");
	}
	WebElement element=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
	Actions ac=new Actions(driver);
	ac.moveToElement(element).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	}}
