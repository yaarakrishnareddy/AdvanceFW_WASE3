package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VtigerGenericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility {
	@FindBy(xpath ="//a[text()='Contacts']" )
	private WebElement ContactEdit;
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement orgEdit;
	@FindBy(xpath = "(//img[@border='0'])[3]")
	private WebElement logutbutt;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	public WebElement getContactEdit() {
		return ContactEdit;
	}
	public WebElement getOrgEdit() {
		return orgEdit;
	}
	public WebElement getLogutbutt() {
		return logutbutt;
	}
	public WebElement getSignout() {
		return signout;
	}
	public void clcikOnContactLink()
	{
		ContactEdit.click();
	}
	public void clickOnOrgLink()
	{
		orgEdit.click();
	}
	public void signOutPage(WebDriver driver)
	{
		mouseoverActionClass(driver, logutbutt);
	    signout.click();
	}
}
