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
import org.testng.annotations.Test;

import BrowserSetup.Base;
import Utils.Utility;
import pack1.CartPage;
import pack1.LoginPage;
import pack1.ProductPage;

public class ToVerifyLoginPage extends Base {
	
	LoginPage loginpage;
	WebDriver driver;
	ProductPage productpage;
	CartPage cartpage;
	String testID;
	
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
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Class Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();		
		loginpage=new LoginPage(driver);
		productpage = new ProductPage(driver);
		cartpage = new CartPage(driver);
		
		
	}
	
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		loginpage.enterUsename();
		loginpage.enterPassword();
		loginpage.clickOnLoginButton();
		
		
	}
	
	@Test 
	public void VerifyCheckOutButton() throws InterruptedException  { 
		testID= "Test001";
		productpage.clickonsortContainer();
		Thread.sleep(5000);
		productpage.clickonBag();
		productpage.addBagToCart();
		productpage.clickOnCartButton();
		String expUrl= "https://www.saucedemo.com/cart.html";
		String actUrl= driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expUrl);

		
	}
	
	@Test
	public void verifyContinueWithShoppingButton() {
		testID= "Test002";
		productpage.clickOnCartButton();
		String expUrl= "Continue Shoppin";
		String actURl=cartpage.getTextofContinueWithShoppingButton();
		Assert.assertEquals(actURl, expUrl);
		
	}
	
	@Test
	public void verifyRemoveButton() throws InterruptedException {
		testID= "Test003";
		productpage.clickOnCartButton();
		cartpage.clickonRemoveButton();
		
		
		
	}
	
	@AfterMethod
	 public void logOutApplication(ITestResult result) throws IOException{
		if(ITestResult.FAILURE==result.getStatus()){
		  Utility.captureScreenshot(driver, testID);
		
		}
		
		
	}
	
	@AfterClass
	 public void closeTheBrowser() {
	
		loginpage=null;
		productpage=null;
		cartpage= null;
		testID=null;
		
		
	}
	
	@AfterTest 
	public void clearObject() {
		System.out.println("After Class");
		driver.quit();
		driver = null ;
		System.gc();
	}
}
