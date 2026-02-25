package pages;

import java.net.http.WebSocket;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Step2_Page extends TestBase
{

	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkoutPageTitle;
	@FindBy(xpath = "//div[text()='Payment Information:']") private WebElement paymentInfoLableTxt;
	@FindBy(xpath ="//button[@id='finish']") private WebElement finishBtnTxt;
	
	public Checkout_Step2_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyCheckoutPageTitle()
	{
		return checkoutPageTitle.getText();
		
	}
	
	public String verifyPaymentLableTxt()
	{
		return paymentInfoLableTxt.getText();
		
	}
	
	public String clickOnfinishBtn()
	{
		 finishBtnTxt.click();
		 return driver.getCurrentUrl();
		
	}
	
}
