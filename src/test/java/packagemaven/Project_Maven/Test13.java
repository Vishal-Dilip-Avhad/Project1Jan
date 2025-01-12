package packagemaven.Project_Maven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
//user is able to apply coupon code 
public class Test13 extends Launch_Quit {

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void apply_coupon_code() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelSHeet_Data e1=new ExcelSHeet_Data();
		e1.datafetching();
		 
		HomePage home = new HomePage(driver);
		home.accountandlist_hoverhover(driver);
		home.signin_method();
		Thread.sleep(2000);
		LoginPage login = new LoginPage(driver);
		login.un();
		login.cnt();
		login.pwd();
		login.signin();
		Thread.sleep(2000);

		home.search_smartphone();
		home.click_on_new_product(driver);

		ProductPage p2 = new ProductPage(driver);
		p2.child_window(driver);
		p2.add_to_cart();
		Thread.sleep(2000);
		p2.close_cart_window();
		Thread.sleep(2000);
		p2.cart_container();
		Thread.sleep(2000);
		p2.proceed_to_buy();
		Thread.sleep(5000);
		
		PaymentPage p1 = new PaymentPage(driver);
		p1.use_this_adresss(driver);
		p1.apply_coupon();
		
		p2.parent_window(driver);
		Thread.sleep(3000);
		p2.cart_container();
		Thread.sleep(3000);
		p2.remove_from_cart();

	}
}
