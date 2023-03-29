package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfomPage {
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement informorg;
public OrgInfomPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}
public WebElement getInformorg() {
	return informorg;
}
public String orgInfor()
{
return	informorg.getText();
}
}
