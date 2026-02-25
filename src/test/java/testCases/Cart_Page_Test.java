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
import pages.LoginPage;
import pages.inventoryPage;
import utility.screenshot_Class;

public class Cart_Page_Test extends TestBase
{
	
	LoginPage login;
	inventoryPage invent;
	Cart_Page cart;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException 
	{
		initialization();
		login = new LoginPage();
		invent = new inventoryPage();
		cart=new Cart_Page();
		login.loginToApp();
		invent.clickOnCart();
		

	}
	
	@Test
	public void verifyPageURLTest()
	{
		
		String expURL = "https://www.saucedemo.com/cart.html";
		String actURL = cart.verifyPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Inventory Page title = " + actURL);
		
	}
	
	@Test
	public void verifyPageTitleTest()
	{
		String expTitle = "Your Cart";
		String actTitle = cart.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Inventory Page title = " + actTitle);
	}
	
	@Test
	public void clickonCheckoutBtnTest()
	{
		
		String expPageURL = "https://www.saucedemo.com/checkout-step-one.html";
		String actPageURL = cart.clickonCheckoutBtn();
		Assert.assertEquals(expPageURL, actPageURL);
		Reporter.log("Inventory Page title = " + actPageURL);
		
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
