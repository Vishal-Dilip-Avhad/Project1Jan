package packagemaven.Project_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage {

	WebDriver driver;
	@FindBy(xpath = "//a[@id='nav_prefetch_yourorders']")
	WebElement yourorders;
	@FindBy(xpath = "(//a[normalize-space(text())='Write a product review'])[1]")//*[@id="a-autoid-8-announce"]
	WebElement writeproductreview;
	@FindBy(xpath = "//img[@alt='select to rate item five star.']")
	WebElement givefivestarrating;

	@FindBy(xpath = "//span[contains(text(),'Submitted')]")
	WebElement ratingssubmitted;
	@FindBy(xpath = "(//a[contains(text(),'Orders')])[1]")
	WebElement orders;
	@FindBy(xpath = "//span[contains(text(),'Clear')]")
	WebElement clearratings;
	
	public void your_orders() {
		yourorders.click();
	}
    public void orders() {
    	orders.click();
    }
    public void clear_ratings() {
    	clearratings.click();
    }
	public void write_product_review() {
		writeproductreview.click();
	}

	public void give_five_star_rating() {
		givefivestarrating.click();
	}

	public boolean ratings_submitted() {
		return ratingssubmitted.isDisplayed();
	}
    
	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
