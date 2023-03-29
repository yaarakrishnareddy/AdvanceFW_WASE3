package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
@Listeners(VtigerGenericUtility.ListenersImplementation.class)
public class ASS1 {

	public static void main(String[] args) throws AWTException, InterruptedException {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("-remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://localhost:8888/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Random r1=new Random();
		int r2=r1.nextInt();
		driver.findElement(By.name("accountname")).sendKeys("kirttu1"+r2);
		driver.findElement(By.name("industry")).click();
		
		Robot r=new Robot();
       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);

       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);

       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);

       r.keyPress(KeyEvent.VK_DOWN);
       r.keyRelease(KeyEvent.VK_DOWN);

       r.keyPress(KeyEvent.VK_ENTER);
       r.keyRelease(KeyEvent.VK_ENTER);
	//	WebDriverUtility wb=new WebDriverUtility();  
	//	wb.KeyBordStrokHandaling();

     driver.findElement(By.name("button")).click();
     WebElement element=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
      String com=element.getText();
      Assert.fail();
      if(com.contains("kirttu1"))
     {
	System.out.println(com+"--------pass");
      }
     else
       {
	System.out.println("no pass");
}
Thread.sleep(4000);
                WebElement element1=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
        Actions ac=new Actions(driver);
         ac.moveToElement(element1).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();

	}

}
