package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactLookupimgPage {
@FindBy(xpath = "//img[@title='Create Contact...']")
private WebElement newContactpage;
public NewContactLookupimgPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getNewContactpage() {
	return newContactpage;
}
public void newContactLookupImg()
{
	newContactpage.click();
}
}
