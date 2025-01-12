package packagemaven.Project_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='add-to-wishlist-button']") WebElement addtowishlist_btn;
	@FindBy(xpath = "(//span[@id='atwl-list-privacy-2M32WOWULGITX'])[1]") WebElement addtowishlist_nxt_btn;
	
	@FindBy(xpath="//span[normalize-space()='One item added to']") WebElement addedtowishlistmassage;
	@FindBy(xpath="//span[normalize-space()='This item was already in']") WebElement alreadyaddedtowishlistmassage;
	
	@FindBy(xpath="//a[normalize-space()='View Your List']") WebElement viewyourlist;
	
	@FindBy(xpath="//div[@id='itemMain_I2CVHODA2CYDCY']") WebElement unorderlist;
	@FindBy(xpath="//span[contains(text(), 'shopping')]") WebElement shoppinglist;
	@FindBy(xpath = "(//input[@name='submit.deleteItem'])[1]")
	WebElement removefromlist;
	@FindBy(xpath="//div[.='Deleted']") WebElement deletedbutton;
	
	
	public void add_to_wishlist(WebDriver driver) throws InterruptedException  {
	
		addtowishlist_btn.click();
		Thread.sleep(3000);
	    addtowishlist_nxt_btn.click();
	    Thread.sleep(8000);
	    Actions actions = new Actions(driver);
        actions.moveToElement(addtowishlist_btn).click().perform();		
	}
	public String add_to_wish_massage() {
		
		return addedtowishlistmassage.getText();
	}
	public void is_shoppinglist_displayed() {
		
		boolean b1 = addedtowishlistmassage.isDisplayed();
		boolean b2 = alreadyaddedtowishlistmassage.isDisplayed();
		
		if(b1==true ||b2==true) {
			System.out.println("product added to wishlist");
		}
		else {
			System.out.println("product not added to wishlist");
		}
	}
	public void viewyourlist() {
		viewyourlist.click();
	}
	public void remove_from_wishlist() {
		removefromlist.click();
		if(deletedbutton.isDisplayed()) {
			System.out.println("items removed from wishlist");
		}
		
	}
	public WishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
