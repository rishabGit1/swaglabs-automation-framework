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
import pages.Complete_Page;
import pages.LoginPage;
import pages.inventoryPage;
import utility.screenshot_Class;

public class Complete_Page_Test extends TestBase
{

	LoginPage login;
	inventoryPage invent;
	Cart_Page cart;
	Checkout_Step1_Page check1;
	Checkout_Step2_Page check2;
	Complete_Page completePage;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException 
	{
		initialization();
		login = new LoginPage();
		invent = new inventoryPage();
		cart=new Cart_Page();
		check1= new Checkout_Step1_Page();
		check2 = new Checkout_Step2_Page();
		completePage = new Complete_Page();
		login.loginToApp();
		invent.clickOnCart();
		cart.clickonCheckoutBtn();
		check1.enterDetails();
		check2.clickOnfinishBtn();
	}
	
	@Test
	public void verifythankyouTextTest()
	{
		 String expTxt = "Thank you for your order!";
		 String actTxt = completePage.verifythankyouText();
		 Assert.assertEquals(expTxt, actTxt);
		 Reporter.log("Thank you Text = " + actTxt);
	}
	
	@Test
	public void clickHomebtnTest()
	{
		 String expURL = "https://www.saucedemo.com/inventory.html";
		 String actURL = completePage.clickHomebtn();
		 Assert.assertEquals(expURL, actURL);
		 Reporter.log("current page URL  = " + actURL);
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
