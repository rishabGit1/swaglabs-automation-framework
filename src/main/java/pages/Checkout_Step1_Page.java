package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Checkout_Step1_Page extends TestBase
{

	@FindBy(xpath ="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath ="//input[@name='lastName']") private WebElement lastNameTxtBox;
	@FindBy(xpath ="//input[@id='postal-code']") private WebElement zipCodeTxtBox;
	@FindBy(xpath ="//input[@id='continue']") private WebElement continueBtn;
	
	
	public Checkout_Step1_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	 public String enterDetails() throws InterruptedException
	{
		 Thread.sleep(2000);
		zipCodeTxtBox.sendKeys("380550");
		
		lastNameTxtBox.sendKeys("QA");
		Thread.sleep(2000);
		firstNameTxtBox.sendKeys("Rishabh");
		Thread.sleep(1000);
		continueBtn.click();
		
		return driver.getCurrentUrl(); 
		
	}
	
	/*public String enterDetails()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(lastNameTxtBox));
	    firstNameTxtBox.sendKeys("Rishabh");
	    System.out.println(firstNameTxtBox.isDisplayed());


	    lastNameTxtBox.sendKeys("QA");
	    zipCodeTxtBox.sendKeys("380550");

	    continueBtn.click();

	    return driver.getCurrentUrl();
	}
*/
	
	
	
}
