package packagemaven.Project_Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	WebDriver driver;

	@FindBy(xpath = "//span[@data-a-selector='increment-icon']")
	WebElement incrementquantities;
	@FindBy(xpath = "//span[@data-a-selector='value']")
	WebElement quantities;
	@FindBy(xpath = "(//input[@value='Delete'])[1]")
	WebElement removefromcart;
	@FindBy(xpath = "//h2[@class='a-size-extra-large a-spacing-mini a-spacing-top-base a-text-normal']")
	WebElement cartemptymassage;

	public void increment_cart_quantities() {
		incrementquantities.click();
	}

	public void validate_quantities() {

		int s1 = Integer.parseInt(quantities.getText());
		System.out.println(s1);

		if (s1 >= 1) {
			System.out.println(" product quantity icremented");
		} else {
			System.out.println("cart quantity not incremented");
		}

	}

	public void remove_from_cart() {
		removefromcart.click();
	}

	public void validate_cart_empty_massage(WebDriver driver) throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		String t1 = removefromcart.getText();
		if (t1.contains("Your Amazon Cart is empty.")) {
			System.out.println("test passesd cart is empty now");
		}

	}

	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
