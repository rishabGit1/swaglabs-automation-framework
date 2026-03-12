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
import utility.ReadData;
import utility.screenshot_Class;

//12 march jhatu

public class LoginPage_Test extends TestBase {

	LoginPage login;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		initialization();
		login = new LoginPage();

		 
	 

	publi
	 {  
		String expURL =   R
		String actURL = gin.verifyURLofWebsite();  
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Login Successful = " +

	public void verifyURLofWebsiteTest() throws InterruptedException, EncryptedDocumentException, IOException
	{ 	String expURL = ReadData.readExcel(0, 1);            //"https://www.saucedemo.com/";(0,1)
		String actURL = login.verifyURLofWebsite(  
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of website = " + actURL);
		

	@

	public void verifyTitleofWebsite() throws EncryptedDocumentException, IOException {
		String expTitle = ReadData.readExcel(0, 2);// "Swag Labs";(0,2)
		String actTitle = login.verifyTitleofWebsite();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of website = " + actTitle);
	}

	public void closeBrowser(ITestResult it) throws IOException 
	{ 	

		{   	screenshot_Class.takeSS(it.getName());
		}
		driver.close();
	}
