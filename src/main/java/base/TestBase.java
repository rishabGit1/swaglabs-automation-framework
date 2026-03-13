//13 march -code overview
package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ReadData;


public class TestBase 
{
	//new update code
    /* public static ChromeDriver driver;
	public void initialization()
	{
	s	WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
		
	}*/
	
	//**********************************************no changes from laptop
	//Compatability Testing 
	
	public static WebDriver driver;
	public void initialization() throws IOException
	{
		
		//String browser = ReadData.readConfigFile("Browser");
		String browser = ReadData.readConfigFile("Browser");
		
		if(browser.equals("chrome"))
		{
			 driver = new ChromeDriver();
			
		}
		else if(browser.equals("edge"))
		{
		 driver = new EdgeDriver();
		 	
		}
		else if(browser.equals("firefox"))
		{
		 driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ReadData.readConfigFile("URL"));
		
		
	}
	
	
	
	
	
	 
}
