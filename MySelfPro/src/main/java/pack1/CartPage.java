package pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy (xpath= "//button[@id='remove-sauce-labs-backpack']")
	private WebElement removeButton;
	
	@FindBy (xpath= "//button[@id='checkout']")
	private WebElement checkOutButton;
	
	@FindBy (xpath= "//button[@id='continue-shopping']")
	private WebElement continueShoppingButton;
	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonRemoveButton() {
		removeButton.click();
	}
	
	public void clickOnCheckOutButton() {
		checkOutButton.click();
	}
	
	public void clickOncontinueShoppingButton() {
		continueShoppingButton.click();
	}
	
	public String getTextofContinueWithShoppingButton() {
	String str=	continueShoppingButton.getText();
	return str;
	}

}
