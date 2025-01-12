package packagemaven.Project_Maven;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
//Test searching for product
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test05 extends Launch_Quit {

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void login_to_amazon_search_a_product() throws InterruptedException, EncryptedDocumentException, IOException {
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

		home.search_smartphone();
		Thread.sleep(2000);

		String t1 = driver.getTitle();
		System.out.println(t1);
		if (t1.toLowerCase().contains("samsung")) {
			System.out.println("search result matched for the product");
		} else {
			System.out.println("search result did not matched for the product");
		}
		
        Assert.assertEquals(driver.getTitle().contains("samsung"), true);
	}
}
