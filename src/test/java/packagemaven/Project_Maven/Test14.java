package packagemaven.Project_Maven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test14 extends Launch_Quit{

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void give_five_star_rating() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelSHeet_Data e1=new ExcelSHeet_Data();
		e1.datafetching();
		
		HomePage home = new HomePage(driver);
		home.accountandlist_hoverhover(driver);
		home.signin_method();
		Thread.sleep(2000);

		LoginPage login = new LoginPage(driver);
		login.un();
		login.cnt();
		Thread.sleep(2000);
		login.pwd();
		login.signin();
		
		home.user_accountlist_hoverover(driver);
		
		MyOrdersPage m1 = new MyOrdersPage(driver);
		m1.your_orders();
		Thread.sleep(3000);
		//m1.orders();
		Thread.sleep(2000);
		m1.write_product_review();
		Thread.sleep(2000);
		
		m1.clear_ratings();
		Thread.sleep(2000);
		m1.give_five_star_rating();
		Thread.sleep(2000);
		m1.ratings_submitted();
		
		Assert.assertTrue(m1.ratings_submitted(),"five star rating submitted");
		
	}
}
