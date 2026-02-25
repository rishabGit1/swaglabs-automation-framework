package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Complete_Page extends TestBase
{

	@FindBy(xpath = "//h2[text()='Thank you for your order!']")private WebElement thankYouTxt;
	@FindBy(xpath = "//button[text()='Back Home']")private WebElement backHomeBtn;
	
	public Complete_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifythankyouText()
	{
		return thankYouTxt.getText();
		
	}
	
	public String clickHomebtn()
	{
		backHomeBtn.click();
		return driver.getCurrentUrl();
		
	}
	
	
	
}
