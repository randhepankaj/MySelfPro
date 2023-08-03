package TestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pack1.LoginPage;
import pack1.ProductPage;

public class ToVerifyProductPage {
  WebDriver driver;
  LoginPage loginpage;
  ProductPage productpage;
  String testID;
  
  
  
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Class Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
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
	
	
	
	
}

