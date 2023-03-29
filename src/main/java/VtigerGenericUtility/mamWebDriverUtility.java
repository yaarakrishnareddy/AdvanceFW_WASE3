package VtigerGenericUtility;



	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	/**
	 * This class consists of generic methods related to webdriver actions
	 * @author Chaitra M
	 *
	 */
	public class mamWebDriverUtility {
		
		/**
		 * This method will maximize the window
		 * @param driver
		 */
		public void maximizeWindow(WebDriver driver)
		{     
			driver.manage().window().maximize();
		}
		
		/**
		 * This method will minimize the window
		 * @param driver
		 */
		public void minimizeWindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}

		/**
		 * This method will wait for the page Load
		 * @param driver
		 */
		public void waitForPage(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		/**
		 * This method will wait until the element becomes visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeVisible(WebDriver driver, WebElement element) 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * This method will wait until the element becomes clickable
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/**
		 * This method will handle the drop down based on index
		 * @param element
		 * @param index
		 */
		public void handleDropdown(WebElement element, int index)
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		/**
		 * This method will handle the drop down based on value
		 * @param element
		 * @param value
		 */
		public void handleDropdown(WebElement element, String value)
		{
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		
		/**
		 * This method will handle dropdown based on visible text
		 * @param text
		 * @param element
		 */
		public void handleDropdown(String text, WebElement element)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
		/**
		 * This method will perform mouse hover action
		 * @param driver
		 * @param element
		 */
		public void mouseHoverAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		/**
		 * This method will perform right click anywhere in web page
		 * @param driver
		 */
		public void rightClickAction(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.contextClick().perform();
		}
		
		/**
		 * This method will perform right click on a web element
		 * @param driver
		 * @param element
		 */
		public void rightClickAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * This method will perform double click anywhere on web page
		 * @param driver
		 */
		public void doubleClickAction(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.doubleClick().perform();
		}
		
		/**
		 * This method will perform double click on a web element
		 * @param driver
		 * @param element
		 */
		public void doubleClickAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		/**
		 * This method will perform drag and drop action
		 * @param driver
		 * @param srcElement
		 * @param dstElement
		 */
		public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement)
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(srcElement, dstElement).perform();
		}
		
		/**
		 * This method will aceept the alert
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * This method will dismiss the alert
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * This method will capture the text from Alert popup
		 * @param driver
		 * @return
		 */
		public String getAlertText(WebDriver driver)
		{
			return driver.switchTo().alert().getText();
		}
		
		/**
		 * This method will handle frame based on index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * This method will handle frame based on name or ID
		 * @param driver
		 * @param nameOrId
		 */
		public void handleFrame(WebDriver driver, String nameOrId)
		{
			driver.switchTo().frame(nameOrId);
		}
		
		/**
		 * This method will handle frame based on web element
		 * @param driver
		 * @param element
		 */
		public void handleFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * This method will switch to immediate parent frame
		 * @param driver
		 */
		public void switchToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 * This method will switch to default frame
		 * @param driver
		 */
		public void switchToDefaultFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		
		
		
		
		
		
		
		
	}



