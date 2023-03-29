package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NeworgPage {
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement orglookupimg;
public NeworgPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}
public WebElement getOrglookupimg() {
	return orglookupimg;
}
public void  neworgpage()
{
	orglookupimg.click();
}
}
