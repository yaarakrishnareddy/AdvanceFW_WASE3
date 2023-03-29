package VtigerGenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author kittu
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize window
	 * @param driver
	 */
public void maxmizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize window
	 * @param driver
	 */
public void minwin(WebDriver driver)
{
	driver.manage().window().minimize();
	}
/**
 * This method will Wait for implicit
 * @param driver
 */
public void Waitforimplicity(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
/**
 * This method will wait for element to be visible
 * @param driver
 * @param element
 */
public void waitForElementtobevisible(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method will waitForelement to be click able
 * @param driver
 * @param elemet
 */
public void waitForElementClickble(WebDriver driver,WebElement elemet)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(elemet));
}
/**
 * This method will mouseActionclass based on web page
 * @param driver
 * @param element1
 */
public void mouseoverActionClass(WebDriver driver,WebElement element1) {
	Actions ac=new Actions(driver);
	ac.moveToElement(element1).perform();
}
/**
 * this method will right click on web page
 * @param driver
 */
public void rightclickmouseoverActionClass(WebDriver driver) {
	Actions ac=new Actions(driver);
	ac.contextClick().perform();
}
/**
 * This method will right click on web page
 * @param element
 * @param driver
 */
public void rightclickmouseoverActionClass(WebElement element,WebDriver driver) {
	Actions ac=new Actions(driver);
	ac.contextClick(element).perform();
}
/**
 * This method will double click on web page
 * @param driver
 */
public void doubleclickmouseoverActionClass(WebDriver driver) {
	Actions ac=new Actions(driver);
	ac.doubleClick().perform();
}
/**
 *  
 * This method will double click on web page

 * @param driver
 * @param element
 */
public void doubleclickmouseoverActionClass(WebDriver driver,WebElement element) {
	Actions ac=new Actions(driver);
	ac.doubleClick(element).perform();
}

/**
 * This method will work Drop down
 * @param driver
 * @throws AWTException
 */
public void KeyBordStrokHandaling() throws AWTException {
	Robot rb=new Robot();
	for(int i=0;i<3;i++)
	{
	rb.keyPress(KeyEvent.VK_DOWN);
	rb.keyRelease(KeyEvent.VK_DOWN);
	}
	
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
}

/**
 * This method will slide handling
 * @param driver
 * @param drag
 * @param drop
 */
public void sliderHandaling(WebDriver driver,WebElement drag,WebElement drop)
{
	Actions ac=new Actions(driver);
	ac.dragAndDropBy(drag, 0, 0);
	}
/**
 * This method will handleDropDown base on index
 * @param element
 * @param index
 */
public void handlDropDown(WebElement element ,int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
/**
 * This method will handleDropDown base on value
 * @param element
 * @param index
 */
public void handlDropDown(WebElement element ,String value)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * This method will handleDropDown base on visible text
 * @param element
 * @param index
 */
public void handlDropDown(String value,WebElement element )
{
	Select s=new Select(element);
	s.selectByVisibleText(value);
}
/**
 * This method will accept the alert on page
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * This method will dismiss the alert on page
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
 * This method will get text the alert on page
 * @param driver
 */
public String gettAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
/**
 * This method will handle frame based on index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

/**
 * This method will handle frame based on webpage
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,WebElement elemnt)
{
	driver.switchTo().frame(elemnt);
}
/**
 * This method will handle frame based on id or name
 * @param driver
 * @param index
 */
public void handaleFrame(WebDriver driver,String idorname)
{
	driver.switchTo().frame(idorname);
}

/**
 * This method will parent frame switch to 
 * @param driver
 * @param index
 */
public void parentFrame(WebDriver driver) {
	driver.switchTo().parentFrame();
}

/**
 * This method will 
 * @param driver
 * @param index
 */
public void defuitFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 *This method will switch the window based on partial window title.
 * @param driver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver,String partialWinTitle) {
	
	//Step 1: Capture all the Window IDs
Set<String>	WinIds=driver.getWindowHandles();

//Step 2: Navigate to each window 
for(String Win:WinIds)
{
	//Step 3: switch to window and capture the title	
String wintitle	=driver.switchTo().window(Win).getTitle();

//Step 4: compare the title with required partial title
if(wintitle.contains(partialWinTitle))
{
	break;
}
}
}
/**
 * This method will take screen short and save  it in folder
 * @param sDriver
 * @param ScreenShortname
 * @return
 * @throws IOException
 */
public String takeScreenShort(Object sDriver,String ScreenShortname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)sDriver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dse=new File(".\\TakeScreenShort\\"+ ScreenShortname +".png");
	FileUtils.copyFile(src, dse);
	return dse.getAbsolutePath();
}
/**
 * This method will perform random scroll downwards vertically
 * @param driver
 */
 public void scrollAction(WebDriver driver)
 {
	 JavascriptExecutor jse=(JavascriptExecutor) driver;
	 jse.executeScript("Window.scrollBy(0,500)", "");
 }
 /**
  *This method will scroll until the element is identified in DOM
  * @param driver
  * @param element
  */
 public void scrollaction(WebDriver driver,WebElement element)
 {
	 JavascriptExecutor jse=(JavascriptExecutor) driver;
     int y=element.getLocation().getY();
     jse.executeScript("Window.scrollBy(0,"+y+")", "");
 
	
}
public void waitForPage(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

	
}

