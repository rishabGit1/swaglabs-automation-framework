package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class screenshot_Class extends TestBase
{

	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		
	}
	public static void takeSS(String nameofMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//desktop file path
		File dest = new File("C:\\Users\\dell\\Downloads\\Rishabh_Main_12feb\\Rishabh_Main\\Screenshots\\"+nameofMethod+"--"+getDate()+".jpeg");
		
		//Laptop file path
		//File dest = new File("C:\\Users\\DELL\\Desktop\\SwagLabsWeb_Automation-\\Screenshots"+nameofMethod+"--"+getDate()+".jpeg");

		
		FileHandler.copy(source, dest);
	}
	

}
