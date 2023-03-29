package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VtigerGenericUtility.WebDriverUtility;

public class CreateOrgPage extends WebDriverUtility {
@FindBy(name = "accountname")
private WebElement orginame;
@FindBy(name = "industry")
private WebElement dropdown;
@FindBy(name = "button")
private WebElement save;
public CreateOrgPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}
public WebElement getOrginame() {
	return orginame;
}
public WebElement getDropdown() {
	return dropdown;
}
public WebElement getSave() {
	return save;
}
public void createOrgPage(String org)
{
	orginame.sendKeys(org);
	save.click();
}
public void createOrgPage(String org,String industry)
{
	orginame.sendKeys(org);
	handlDropDown(industry, dropdown);
	save.click();
}
}
