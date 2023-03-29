package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import VtigerGenericUtility.ExcelfileUtility;
import VtigerGenericUtility.JavaUtility;
import VtigerGenericUtility.PropertiFileUtility;
import VtigerGenericUtility.WebDriverUtility;

public class DemoGeneralUtility {

	public static void main(String[] args) throws IOException, InterruptedException {
		PropertiFileUtility putil=new PropertiFileUtility();
		ExcelfileUtility    eutil=new ExcelfileUtility();
		WebDriverUtility    wutil=new WebDriverUtility();
		JavaUtility         jutil=new JavaUtility();
        String URL=	putil.readDataFromPropertyFile("url");
        String USN=	putil.readDataFromPropertyFile("username");
        String PAW=putil.readDataFromPropertyFile("password");
        String BROW=putil.readDataFromPropertyFile("browser");
    String s=  eutil.getreadExcelSheet("Org", 1, 2);
		WebDriver driver=null;
          if(BROW.equalsIgnoreCase("Chrome"))
    		  {
    	  driver=new EdgeDriver();
    		  }
          driver.get(URL);
      wutil.maxmizewindow(driver);
      wutil.Waitforimplicity(driver);
    //Login to application with valid credentials
    		driver.findElement(By.name("user_name")).sendKeys(USN);
    		driver.findElement(By.name("user_password")).sendKeys(PAW);
    		driver.findElement(By.id("submitButton")).click();    		
    		Thread.sleep(4000);
      
            driver.findElement(By.linkText("Contacts")).click();

    		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
     
       driver.findElement(By.name("lastname")).sendKeys(s+jutil.getRandomNumber());
    	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
        
    		wutil.switchToWindow(driver, PAW);
    		driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[2]")).click();
    		wutil.switchToWindow(driver, PAW);
    		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
    		
    		String com=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

    		//String ele1=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();

    		if(com.contains(s))
    		{
    			System.out.println(com+"-----pass");
    		}
    		else
    		{
    			System.out.println("no pass");
    		}
    		WebElement element2=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
    		wutil.mouseoverActionClass(driver, element2);
    		driver.findElement(By.linkText("Sign Out")).click();
    		driver.quit();
    		
	}

}
