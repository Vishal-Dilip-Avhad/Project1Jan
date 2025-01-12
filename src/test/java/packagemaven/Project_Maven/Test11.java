package packagemaven.Project_Maven;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//valiadte checkout process including adress a+selection, payment selection, order review
@Listeners(Listeners_Logic.class)
public class Test11 extends Launch_Quit {
	@Test( retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void entirecheckoutprocess() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelSHeet_Data e1=new ExcelSHeet_Data();
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
		Thread.sleep(2000);
		home.click_on_new_product(driver);
		Thread.sleep(3000);

		ProductPage p2 = new ProductPage(driver);
		p2.child_window(driver);
		Thread.sleep(3000);
		p2.add_to_cart();
		Thread.sleep(3000);
		p2.close_cart_window();
		Thread.sleep(3000);
		p2.cart_container();
		Thread.sleep(3000);
		p2.proceed_to_buy();
		Thread.sleep(6000);

		PaymentPage p1 = new PaymentPage(driver);
		// p1.remove_quantity_error();
		
		p1.change_delivery_adress();
		Thread.sleep(8000);
		p1.use_this_adresss(driver);
		//p1.use_new_adress();
		Thread.sleep(9000);
		//p1.use_this_adresss();
		//Thread.sleep(8000);
		p1.change_payment_method();
		Thread.sleep(8000);
	    p1.use_this_payment_method(driver);
	    Thread.sleep(3000);
	    
	    String t1 = p1.arriving_txt();
	    System.out.println(t1);
	    Assert.assertEquals(t1.contains("Arriving"), true);
	    
	    Assert.assertTrue(p1.place_your_order());
	   
		
		p2.parent_window(driver);
		Thread.sleep(3000);
		p2.cart_container();
		Thread.sleep(3000);
		p2.remove_from_cart();
	
	

	}

}
