package basemethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass
{
	public static WebDriver driver;
	
	@Parameters({"browser", "version", "os" })
    @BeforeMethod
  public void setUp(String browser, String version, String platform) throws MalformedURLException
  {
		
		 if (browser.equals("chrome")) 
		 {   
			
			 ChromeOptions browserOptions = new ChromeOptions();
			 browserOptions.setPlatformName(platform);
			 browserOptions.setBrowserVersion(version);
			 HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			 ltOptions.put("username", "msantest3");
			 ltOptions.put("accessKey", "drvOb7xaPVjlzgmWoNQ8mwZJVua91Gx2xTbvN5KiqIjk60NynW");
			 ltOptions.put("project", "SeleniumAdvancedTest");
			 ltOptions.put("selenium_version", "4.0.0");
			 ltOptions.put("w3c", true);
			 browserOptions.setCapability("LT:Options", ltOptions);
			 driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
			
		}
		 else if (browser.equals("edge")) 
		 {
			 EdgeOptions browserOptions = new EdgeOptions();
			 browserOptions.setPlatformName(platform);
			 browserOptions.setBrowserVersion(version);
			 HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			 ltOptions.put("username", "msantest3");
			 ltOptions.put("accessKey", "drvOb7xaPVjlzgmWoNQ8mwZJVua91Gx2xTbvN5KiqIjk60NynW");
			 ltOptions.put("project", "Untitled");
			 ltOptions.put("w3c", true);
			 browserOptions.setCapability("LT:Options", ltOptions);
			 driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
		
		 init(browser);
      
     
  }
	
	public void geturl(String url)
	{
		try
		{
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		

	}
	
	public void closepresentbrowser()
	{
		 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

	        // Switch to the second tab (index 1)
	        driver.switchTo().window(tabs.get(1));

	        // Close the current tab
	        driver.close();

	        
	        System.out.println(tabs);
	        // Switch back to the main tab (index 0)
	        driver.switchTo().window(tabs.get(0));
	        
	       
	}
	
	public String  getAtributeValue(By locator)
	{
		return driver.findElement(locator).getAttribute("validationMessage");
			
		
	}
	
	public void waitForAllElementsToBeAvailable() 
    {
    	try {
    		 WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
             wait.until(new ExpectedCondition<Boolean>() {
                 public Boolean apply(WebDriver driver) {
                     // Check if any elements are present
                     return !driver.findElements(By.xpath("//*")).isEmpty();
                 }
             });
             System.out.println("All elements are Available in the page");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
       
    }

	
	public void openNewTab(By locator)
	{
		

	       try {
	    	    WebElement element = driver.findElement(locator);
	    	   String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
	    	      // open the link in new tab, Keys.Chord string passed to sendKeys
	    	     element.sendKeys(clicklnk);
	    	     sleep();

		} catch (Exception e) 
	       {
			// TODO: handle exception
		}
	}
	
	public String getTitle()
	{
		
		return driver.getTitle();
		
	}
	
	
	  public void switchToTab(int i) { try { ArrayList<String> tabs = new
	 ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(tabs.get(i)); System.out.println(tabs);
	  
	 } catch (Exception e) { // TODO: handle exception
		 } }
	 
	 
	
	public void slidebartoRequiredValue(By locator)
	{
		try {
             WebElement ele = driver.findElement(locator);
            Actions move = new Actions(driver);
            move.dragAndDropBy(ele, 215, 0);
            move.build().perform();
      
        } catch (Exception e) {
         e.printStackTrace();
        }
	}

	
	public void refreshthepage()
	{
		driver.navigate().refresh();
	}

	public void scrollTheWindow()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(250,0)");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	

	public void clickEnterButton()
	{
		try {
			Actions builder = new Actions(driver);
			builder.sendKeys(Keys.ENTER).perform();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// waitTime();
	}
	


	public void swithToIFrame(By locator)
	{
		try {
			WebElement element = driver.findElement(locator);

			driver.switchTo().frame(element);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void selectByIndex(By locator, int i)

	{
		try 
		{
			WebElement element = driver.findElement(locator);
			Select s = new Select(element);
			s.selectByIndex(i);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void selectByVisibleText(By locator, String value)

	{
		try {
			
			WebElement element = driver.findElement(locator);
			Select s = new Select(element);
			s.selectByVisibleText(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void clickTheElement(By locator) {
		try 
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	

	}
	
	public void navigateURL(String URL)
	{
		driver.navigate().to(URL);
	}
	public String gettextURL()
	{
		
		return driver.getCurrentUrl();
		
	}

	public void waitClick(By locator)
	{ 
		try 
		{
		
			WebElement element = driver.findElement(locator);
			sleep();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

	} catch (Exception e) {
		e.printStackTrace();
	}

		
	}

	public void scrollIntoView(By locator) 
	{
		
		try { WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollIntoXposition() 
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(-500,0)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void scrollIntoPosition()
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-500)");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void enterText(By locator, String input) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void cleartext(By locator)
	{
		try {
			WebElement element = driver.findElement(locator);
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void clearData(By locator) {
		try 
		{
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void waitTime() {
		try {
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			 
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e)
		
		{
			e.printStackTrace();

		}
	}

	public void navigateback()
	{
		try {
			driver.navigate().back();
			sleep();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void waitForElement(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	

	public void init(String browsername)
	{
		try {
			if (browsername.equals("chrome")) {
				driver = DriverManager.getChromeDriver();
			} else if (browsername.equalsIgnoreCase("Firefox")) {
				driver = DriverManager.getFirefoxDriver();
			} 
			else if(browsername.equalsIgnoreCase("Headlesss Chrome"))
			{
				driver = DriverManager.getHeadLessChromeDriver();
			}
			else {
				driver = DriverManager.getedgedriver();
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void uploadfile() {
		try {

			Thread.sleep(2000);
			Runtime.getRuntime().exec("src\\test\\java\\TestData\\fileuploadscript.exe");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }

	public void initApplication(String environment) {
  try 
  {
	  if (environment.equals("stage")) {
			geturl("https://inovar.sharepoint.com/sites/atstest/SitePages/Calender.aspx?env=WebViewList");

		} else {
			geturl("https://inovar.sharepoint.com/sites/ATSDev/SitePages/Candidates.aspx?env=WebViewList");

		}
		sleep();
	
} 
  catch (Exception e)
  {
	e.printStackTrace();
}
		
	}

	public void closebrowser() {
		driver.close();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void mouseHoverOnTheElement(By locator) 
	{
		try {
			WebElement ele = driver.findElement(locator);
			Actions ac = new Actions(driver);
			ac.moveToElement(ele).perform();

			
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}

		
		// return false;
	}

}


