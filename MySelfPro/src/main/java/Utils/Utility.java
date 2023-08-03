package Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	WebDriver driver;
	
	public static void captureScreenshot(WebDriver driver, String testID) throws IOException {
		TakesScreenshot tss= (TakesScreenshot)driver;
		File src= tss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\hp\\Desktop\\SS Selenium\\" + testID +  ".jpg");
		FileHandler.copy(src, dest);	
		
		
	}

}

