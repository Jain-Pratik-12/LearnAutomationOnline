package testcases;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utility.Helper;
import utility.MobileBaseClass;

public class StartApplication extends MobileBaseClass
{
	WebDriver driver;
    @Test
	public void test1()
	{
    	DesiredCapabilities cap=DesiredCapabilities.android();
    	
    	cap.setCapability("platformVersion","5.1.1");
    	cap.setCapability("platformName","Android");
    	cap.setCapability("deviceName","b7b8b8a8");
    	cap.setCapability("appPackage", "io.selendroid.testapp");
    	cap.setCapability("appActivity", ".HomeScreenActivity");
    	
    	try 
    	{
			URL url= new URL("http://127.0.0.1:4727/wd/hub");
  
			driver = new AndroidDriver(url, cap);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			
		}
    	logger=report.startTest("Test Native Application");
    	driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");
        logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver, "Login")));
    	
	}
	
	
}