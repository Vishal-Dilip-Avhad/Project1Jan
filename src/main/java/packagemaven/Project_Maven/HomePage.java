package packagemaven.Project_Maven;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath ="//span[@class='nav-line-2 ']")
	WebElement accountandlist;
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement user_accountandlist;
	@FindBy(xpath = "//a[normalize-space()='Start here.']")
	WebElement createnewaccount;
	@FindBy(xpath = "(//span[.='Sign in'])[1]")
	WebElement signin;
	@FindBy(id = "twotabsearchtextbox")
	WebElement search_tf;
	
	@FindBy(xpath = "(//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal'])[1]")
	WebElement product;
	@FindBy(xpath = "(//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal'])[1]")
	WebElement newproduct;
	@FindBy(xpath = "//span[@class='a-price']")
	List<WebElement> allprices;
    
	@FindBy(xpath = "//button[@data-action='a-popover-close']")
	WebElement closepopup;
	@FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
	WebElement closeaddtocartwindow;
    @FindBy(id = "nav-flyout-wl-items")
	WebElement viewshoppinglist;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement userprofile;

	@FindBy(xpath="//span[.='Featured']") WebElement sortby;
	@FindBy(xpath="//a[.='Price: Low to High']") WebElement sortbypricelowtohigh;
	@FindBy(xpath="//a[.='Newest Arrivals']") WebElement sortbynewarrival;
	@FindBy(xpath="(//input[@id='p_36/range-slider_slider-item_upper-bound-slider'])[2]") WebElement priceslider;
	
	@FindBy(xpath="//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']") List<WebElement> jeans;
	
	
	public void create_new_account() {
		//createnewaccount.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(createnewaccount)).click();
	}
	// step 2
	public void accountandlist_hoverhover(WebDriver driver) {
		Actions a1 = new Actions(driver);
		a1.moveToElement(accountandlist).perform();

	}
	public void user_accountlist_hoverover(WebDriver driver) {
		Actions a1 = new Actions(driver);
		a1.moveToElement(accountandlist).perform();
	}

	public void signin_method() {
		signin.click();
	}

	public void search_smartphone() {
		search_tf.sendKeys("samsung smartphone 2024" + Keys.ENTER);
	}
	public void searching_jeans() {
		search_tf.sendKeys("jeans" + Keys.ENTER);
	}
	public void get_jeans() {
		int s1 = jeans.size();
		System.out.println("number of jeans on webpage "+s1);
		WebElement first_jeans = jeans.get(0);
		String s2 = first_jeans.getText();
		if(s2.contains("Men's")) {
			System.out.println("result matches with category");
		}	
	}
	public void click_on_product(WebDriver driver) {
         product.click();	
	}
	public void click_on_new_product(WebDriver driver) {
         newproduct.click();	
	}
   public void popup_close() throws InterruptedException {
		closepopup.click();
		Thread.sleep(2000);
	}
    public void price_slider(WebDriver driver) {
	Actions a1 = new Actions(driver);
	a1.dragAndDropBy(priceslider, 80, 88).perform();
	
   }
	public void verifyPriceAscendingOrder() {
		for (int i = 0; i < allprices.size() - 2; i++) {
	        WebElement price = allprices.get(i);  
	        System.out.println(price.getText()); 
	    }
	}
    public void close_add_to_cart_window() throws InterruptedException {
		closeaddtocartwindow.click();
		Thread.sleep(2000);
	}
    public void shopping_list() throws InterruptedException {
		viewshoppinglist.click();
		Thread.sleep(2000);
	}
    public String user_profile() {
		String t1 = userprofile.getText();
		return t1;
	}
	public void sort_low_to_high() {
		sortby.click();
		sortbypricelowtohigh.click();
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
