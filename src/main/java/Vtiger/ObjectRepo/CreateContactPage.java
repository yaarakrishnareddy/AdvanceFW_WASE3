package Vtiger.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VtigerGenericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
@FindBy(name="lastname")
private WebElement lastname;
@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@title='Select']")
private WebElement orglookupimg;
@FindBy(name="search_text")
private WebElement searchbox;
@FindBy(name = "search")
private WebElement searhbutt;
@FindBy(name = "button")
private WebElement save;
public CreateContactPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getLastname() {
	return lastname;
}
public WebElement getOrglookupimg() {
	return orglookupimg;
}
public WebElement getSearchbox() {
	return searchbox;
}
public WebElement getSearhbutt() {
	return searhbutt;
}
public WebElement getSave() {
	return save;
}
public void createcontactpage(String name)
{
	lastname.sendKeys(name);
	save.click();
}
public void createContactPage(WebDriver driver,String name,String org) throws InterruptedException
{
lastname.sendKeys(name);
orglookupimg.click();
switchToWindow(driver, "Accounts");
searchbox.sendKeys(org);
searhbutt.click();
Thread.sleep(4000); 
driver.findElement(By.xpath("//a[text()='"+org+"']")).click();
switchToWindow(driver, "Contacts");
save.click();
}

}
