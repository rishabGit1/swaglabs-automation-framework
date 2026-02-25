package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Checkout_Step1_Page;
import pages.Checkout_Step2_Page;
import pages.LoginPage;
import pages.inventoryPage;
import utility.screenshot_Class;

public class Checkout_Step2_Page_Test extends TestBase
{

	LoginPage login;
	inventoryPage invent;
	Cart_Page cart;
	Checkout_Step1_Page check1;
	Checkout_Step2_Page check2;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException 
	{
		initialization();
		login = new LoginPage();
		invent = new inventoryPage();
		cart=new Cart_Page();
		check1= new Checkout_Step1_Page();
		check2 = new Checkout_Step2_Page();
		login.loginToApp();
		invent.clickOnCart();
		cart.clickonCheckoutBtn();
		check1.enterDetails();
	}
	
	@Test
	public void verifyCheckoutPageTitleTest()
	{
		
	 String expTitle = "Checkout: Overview";
	 String actTitle = check2.verifyCheckoutPageTitle();
	 Assert.assertEquals(expTitle, actTitle);
	 Reporter.log("Checkout Page2  title = " + actTitle);
		
	}
	@Test
	public void verifyPaymentLableTxtTest1()
	{
		 String expLable = "Payment Information:";
		 String actLable = check2.verifyPaymentLableTxt();
		 Assert.assertEquals(expLable, actLable);
		 Reporter.log("Checkout Page2  Lable = " + actLable);
	}
	@Test
	public void clickOnfinishBtnTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-complete.html";
		 String actURL = check2.clickOnfinishBtn();
		 Assert.assertEquals(expURL, actURL);
		 Reporter.log("Checkout Page2  Lable = " + actURL);
	}
	
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException 
	{
		
		if(it.FAILURE== it.getStatus())
		{
			screenshot_Class.takeSS(it.getName());
		}
		driver.close();
	}
	
	
	
}
