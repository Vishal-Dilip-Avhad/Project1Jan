package packagemaven.Project_Maven;
//ensure product details price,reviews,description

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test07 extends Launch_Quit{

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void test_details_price_reviews_description() {
	
		
		ProductPage p1 = new ProductPage(driver);
		p1.search_product();
		p1.click_on_product(driver);
		p1.child_window(driver);
		
		p1.get_product_title();
		p1.get_product_price();
		p1.get_product_rating();
		p1.get_product_discription();
		
		Assert.assertEquals(p1.get_product_title().contains("Samsung Galaxy "), true);
		Assert.assertNotNull(p1.get_product_price());
		Assert.assertTrue(p1.get_product_rating());
		Assert.assertTrue(p1.get_product_discription());
		
	}
	
}
