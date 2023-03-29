package Vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	
	public class LoginPage {
		
		

		@FindBy(name="user_name")
	   private WebElement userNameEdit;
		
	   @FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
		private WebElement passWordEdit;
		
	   @FindBy(id="submitButton")
		private WebElement loginsubmit;
		
		//Rule 3: Create a constructor to initialise these web elements

		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//Rule 4: Provide getters to access these elements

		public WebElement getUserNameEdit() {
			return userNameEdit;
		}
		public WebElement getPassWord() {
			return passWordEdit;
		}
		public WebElement getLoginsubmit() {
			return loginsubmit;
		}
		
		//Business Libraries - generic methods specific to current project
			/**
			 * This method will login to app with username and password
			 * @param Username
			 * @param Password
			 */
		 public void loginToApp(String Username,String Password)
		 {
			 userNameEdit.sendKeys(Username);
			 passWordEdit.sendKeys(Password);
			 loginsubmit.click();
		 }
	}	
		


