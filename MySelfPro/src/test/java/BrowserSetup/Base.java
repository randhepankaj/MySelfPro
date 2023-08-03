package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	
   public static WebDriver openChromeBrowser() {
	   System.setProperty("webdriver.chrome.driver", "E:\\Class Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   return driver;
	   
   }
   
   
   public static WebDriver openFirefoxBrowser() {
	   System.setProperty("webdriver.gecko.driver", "E:\\Class Software\\Selenium\\Gecko Driver\\geckodriver.exe");
	   WebDriver driver = new FirefoxDriver();
	   return driver;
   }

   public static WebDriver openOperaBrowser() {
	   System.setProperty("webdriver.opera.driver", "E:\\Class Software\\Selenium\\operadriver_win64\\operadriver.exe");
	   WebDriver driver = new OperaDriver();
	   return driver;
   }
}
