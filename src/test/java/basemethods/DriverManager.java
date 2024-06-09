package basemethods;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager 
{
private static WebDriver driver;
	
	/**
	 * @return 
	 * @return WebDriver
	 * 
	 *         This method return ChromeDriver object
	 */
	public static  WebDriver getChromeDriver() 
	{
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
			VerifyBrowserOS();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return driver;
	}

	/**
	 * @return WebDriver
	 * 
	 *         This method return IEDriver object
	 */
	public static WebDriver getedgedriver()
	{
		try {
			driver = new EdgeDriver();
			VerifyBrowserOS();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//WebDriverManager.edgedriver().setup();
		
		return driver;
	
	}
	

	/**
	 * @return WebDriver
	 * 
	 *         This method return FirefoxDriver object
	 */
	public static WebDriver getFirefoxDriver() {
		try {
			driver = new FirefoxDriver();
			VerifyBrowserOS();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
		
	}
	
	public static  WebDriver getHeadLessChromeDriver() 
	{
		try 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			 driver = new ChromeDriver(options);
			 VerifyBrowserOS();
			
		} catch (Exception e) {
	e.printStackTrace();
		}
		
		
		 return driver;
	}
	
	

	
	/**
	 * This method provides browser name, browser version and OS
	 */
	public static void VerifyBrowserOS() 
	{
		try {
			 org.openqa.selenium.Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			  String browserName = ((org.openqa.selenium.Capabilities) caps).getBrowserName();
			  String browserVersion = caps.getBrowserVersion();
			  String os = System.getProperty("os.name").toLowerCase();
			  System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	}
}




