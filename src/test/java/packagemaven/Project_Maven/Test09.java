package packagemaven.Project_Maven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test09 extends Launch_Quit {
	@Test( retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void Add_to_Wishlist_Add_to_Cart() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelSHeet_Data e1=new ExcelSHeet_Data();
		e1.datafetching();
		
		HomePage home = new HomePage(driver);
		home.accountandlist_hoverhover(driver);
		Thread.sleep(2000);
		home.signin_method();
		
		LoginPage login = new LoginPage(driver);
		login.un();
		login.cnt();
		Thread.sleep(2000);
		login.pwd();
		login.signin();
		Thread.sleep(2000);
		
		home.search_smartphone();
		Thread.sleep(4000);
		home.click_on_product(driver);
		Thread.sleep(4000);
		
		ProductPage p1 = new ProductPage(driver);
		p1.child_window(driver);
		Thread.sleep(6000);
		WishlistPage w1 = new WishlistPage(driver);
		w1.add_to_wishlist(driver);
		Thread.sleep(4000);
		//String t1 = w1.add_to_wish_massage();
		//Assert.assertEquals(t1, "One item added to", "Text not matched");
		
		//home.popup_close();
		//Thread.sleep(2000);
		
		p1.add_to_cart();
		Thread.sleep(4000);
		p1.parent_window(driver);
		p1.cart_container();
		p1.remove_from_cart();

	}
}
