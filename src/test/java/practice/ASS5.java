package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class ASS5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("websele");
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	String s=driver.getWindowHandle();
	Set	<String> s1=driver.getWindowHandles();
	for(String allid:s1)
	{
		if(!allid.equals(s))
		{
			driver.switchTo().window(allid);
		}
	}
	
	driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[2]")).click();
		driver.switchTo().window(s);

	driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
	
String com=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

//String ele1=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();

if(com.contains("websele"))
{
	System.out.println(com+"-----pass");
}
else
{
	System.out.println("no pass");
}
WebElement element2=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
Actions a1=new Actions(driver);
 a1.moveToElement(element2).perform();
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();
	}

}
