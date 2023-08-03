package pack1;

import java.awt.Window;
import java.awt.event.WindowStateListener;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	WebDriver driver;
	JavascriptExecutor js;
	
	@FindBy (xpath="//select[@class='product_sort_container']")
	private WebElement sortingMenu;
	
	@FindBy (xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement bag;
	
	@FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addBagToCart;
	
	@FindBy (xpath ="//a[@class='shopping_cart_link']")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement menuButton;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	private WebElement logoutButton;
	
	@FindBy (xpath="//span[text()='Products']")
	private WebElement productText;
	
	
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickonsortContainer() {
		Select s= new Select (sortingMenu);
		s.selectByValue("za");
	}
	
	public void clickonBag() {
		js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", bag);
		js.executeScript("window.scrollBy(0,-50)");
		bag.click();
	}
	
	public void addBagToCart() {
		addBagToCart.click();
	}
	
	public void clickOnCartButton() {
		shoppingCart.click();
	}
	
	public void logOutApplication() throws InterruptedException {
		menuButton.click();
		Thread.sleep(3000);
		logoutButton.click();
	}

	public boolean isProductTextDisplayed() {
		boolean r =productText.isDisplayed();
		return r;
		
	}
	

}
