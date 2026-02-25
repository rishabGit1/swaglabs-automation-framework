package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.inventoryPage;
import utility.ReadData;
import utility.screenshot_Class;

public class inventoryPage_Test extends TestBase

{

	// new testcases added
	LoginPage login;
	inventoryPage invent;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new LoginPage();
		invent = new inventoryPage();
		login.loginToApp();

	}

	@Test
	public void verifyPageTitleTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String expTitle = ReadData.readExcel(0, 3);            //"Products";(0,3)
		String actTitle = invent.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Inventory Page title = " + actTitle);
	}

	@Test
	public void addProductToCartTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String expCount = ReadData.readExcel(0, 4);//"6";(0,4);
		String actCount = invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Added product in cart count is = " + actCount);
	}
	@Test
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount = ReadData.readExcel(0, 5);//"4";(0,5)
		String actCount = invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Added product in cart count is = " + actCount);
	}
	
	
	@Test
	public void topLeftMenuLinkTextsTest()
	{
		Reporter.log("Pass");
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
