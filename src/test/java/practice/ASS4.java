package practice;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ASS4 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new EdgeDriver();
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
	WebElement element=	driver.findElement(By.name("industry"));
		Select sc=new Select(element);
		sc.selectByValue("Energy");
		Thread.sleep(4000);
	WebElement ele=	driver.findElement(By.xpath("(//select[@class='small'])[4]"));
			ele.click();

		Select s=new Select(ele);
			s.selectByValue("Customer");
	
     driver.findElement(By.name("button")).click();
     Thread.sleep(4000);
     WebElement element1=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
      String com=element1.getText();
      if(com.contains("kirttu1"))
     {
	System.out.println(com+"--------pass");
      }
     else
       {
	System.out.println("no pass");
}
Thread.sleep(4000);
                WebElement element2=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
        Actions ac=new Actions(driver);
         ac.moveToElement(element2).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();

	}

}


	
