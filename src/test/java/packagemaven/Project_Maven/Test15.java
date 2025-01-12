package packagemaven.Project_Maven;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
//add to cart without login
public class Test15 extends Launch_Quit{

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void add_to_cart_without_login() throws InterruptedException {
		
		HomePage h1 = new HomePage(driver);
		h1.search_smartphone();
		h1.click_on_product(driver);
		Thread.sleep(3000);
		ProductPage p1 = new ProductPage(driver);
		p1.child_window(driver);
		Thread.sleep(4000);
		p1.add_to_cart();
		Thread.sleep(2000);
		p1.close_cart_window();
		Thread.sleep(2000);
		p1.cart_container();
	}
}
