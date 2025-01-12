package packagemaven.Project_Maven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
//test updating item quantities and remove from cart
import org.testng.annotations.Test;

@Listeners(Listeners_Logic.class)
public class Test10 extends Launch_Quit {

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void check_update_quantities_remove_add_to_cart() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelSHeet_Data e1 = new ExcelSHeet_Data();
		e1.datafetching();
		
		HomePage home = new HomePage(driver);
		home.accountandlist_hoverhover(driver);
		Thread.sleep(2000);
		home.signin_method();
		Thread.sleep(2000);
		
		LoginPage login = new LoginPage(driver);
		login.un();
		login.cnt();
		Thread.sleep(2000);
		login.pwd();
		login.signin();
		Thread.sleep(2000);
		
		home.search_smartphone();
		home.click_on_product(driver);
		Thread.sleep(2000);

		ProductPage p1 = new ProductPage(driver);
		p1.child_window(driver);
		p1.add_to_cart();
		Thread.sleep(3000);
		p1.close_cart_window();
		Thread.sleep(2000);
		p1.cart_container();
		Thread.sleep(3000);

		ShoppingCart s1 = new ShoppingCart(driver);
		s1.increment_cart_quantities();
		Thread.sleep(4000);
		s1.validate_quantities();
		Thread.sleep(2000);
		s1.remove_from_cart();
		Thread.sleep(2000);
		s1.validate_cart_empty_massage(driver);

	}
}
