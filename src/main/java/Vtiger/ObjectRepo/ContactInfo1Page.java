package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo1Page {
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement continfo;
public ContactInfo1Page(WebDriver driver)
{
	PageFactory.initElements( driver,this);
	
}
public WebElement getContinfo() {
	return continfo;
}
public String infoCon() {
	return continfo.getText();
}

}

