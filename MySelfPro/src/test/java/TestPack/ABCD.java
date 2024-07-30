package TestPack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ABCD {
	public static void main(String[] args) throws InterruptedException {
		 
		//  System.setProperty("webdriver.chrome.driver","E:\\Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://go.trackwick.com/");
		  driver.manage().window().maximize();
		  WebElement email= driver.findElement(By.xpath("//input [@name='username']"));
		  WebElement pass= driver.findElement(By.xpath("//input [@name='password']"));
		  WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
		  email.sendKeys("abab@gmail.com");
		  pass.sendKeys("Aaaa888888977");
		  Thread.sleep(7000);
		  submit.click();
		  System.out.println("printing statement adding for commit");
	}

}
