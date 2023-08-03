package TestPack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserSetup.Base;
import Utils.Utility;
import pack1.LoginPage;
import pack1.ProductPage;

public class ToVerifyProductPage extends Base {
  WebDriver driver;
  LoginPage loginpage;
  ProductPage productpage;
  String testID;
  
   @Parameters("browser")
   @BeforeTest
   public void beforeTest(String browserName) {
		if (browserName.equals("Chrome")){
	       driver=openChromeBrowser();			
		}
		if (browserName.equals("FireFox")) {
			driver = openFirefoxBrowser();
		}
		if(browserName.equals("Opera")) {
			driver=openOperaBrowser();
		}
	}
  
	@BeforeClass
	public void openBrowser() {
		
		driver.get("https://www.saucedemo.com/");
		loginpage= new LoginPage(driver);
		productpage = new ProductPage(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() {
		loginpage.enterUsename();
		loginpage.enterPassword();
		loginpage.clickOnLoginButton();
	}
	
	@Test
	public void islandedOnProductPage() {
		testID= "Test004";
		boolean r= productpage.isProductTextDisplayed();
		Assert.assertEquals(r, true);
	}
	
	@AfterTest
	 public void clearObject() {
		driver.quit();
		System.gc();
	}
	
	@AfterMethod
	public void logOutApplication(ITestResult result) throws IOException{
		if(ITestResult.FAILURE==result.getStatus()){
		  Utility.captureScreenshot(driver, testID);
		
		}
		
		
	}
	
	@AfterClass
	  public void closeBrowser() {
		loginpage= null;
		productpage=null;
	}

	
	
	
}

