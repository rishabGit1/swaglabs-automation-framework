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
import pages.LoginPage;
import pages.inventoryPage;
import utility.screenshot_Class;

public class Checkout_Step1_Page_Test extends TestBase
{

	LoginPage login;
	inventoryPage invent;
	Cart_Page cart;
	Checkout_Step1_Page check1;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException 
	{
		initialization();
		login = new LoginPage();
		invent = new inventoryPage();
		cart=new Cart_Page();
		check1= new Checkout_Step1_Page();
		login.loginToApp();
		invent.clickOnCart();
		cart.clickonCheckoutBtn();
		
	}
	
	@Test
	public void enterDetailsTest() throws InterruptedException
	{
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actURL = check1.enterDetails();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page two title = " + actURL);
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
