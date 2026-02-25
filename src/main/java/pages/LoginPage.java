package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{

	   @FindBy(xpath="//input[@name='user-name']") private WebElement usernameTxtBox;
	   @FindBy(xpath="//input[@name='password']") private WebElement passwordTxtBox;
	   @FindBy(xpath="//input[@name='login-button']") private WebElement loginBtn;
       
	   public LoginPage()
	   {
		   PageFactory.initElements(driver, this);
	   }
	   public void loginToApp() throws IOException, InterruptedException
	   {
		   usernameTxtBox.sendKeys(ReadData.readConfigFile("Username"));
		   passwordTxtBox.sendKeys(ReadData.readConfigFile("Password"));
		   loginBtn.click();
	   }
	public String verifyURLofWebsite()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleofWebsite()
	{
		
		return driver.getTitle();
	}
	public String verifyMultipleCredentialUsers(String un , String password)
	{
		
		usernameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();
		
	}
	
	
	
	
}
