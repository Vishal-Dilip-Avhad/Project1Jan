package packagemaven.Project_Maven;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
// prices are not in ascending order check console
//verify product can be sorted by relevance, price, ratings
//ascending order assertion remaining
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test08 extends Launch_Quit{
	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void sort_by_price_low_to_high() throws InterruptedException {
		
		HomePage home = new HomePage(driver);
        home.search_smartphone();
		home.sort_low_to_high();
		Thread.sleep(3000);
		home.verifyPriceAscendingOrder();
		
		List<WebElement> allprices = driver.findElements(By.xpath("//span[@class='a-price']"));
		
		 double[] prices = new double[allprices.size()-5];
	        for (int i = 0; i < allprices.size()-5; i++) {
	            String priceText = allprices.get(i).getText().replaceAll("[^0-9.]", "");
	            prices[i] = Double.parseDouble(priceText); 
	        }

	        
	        for (int i = 0; i < prices.length - 1; i++) {
	            Assert.assertTrue(prices[i] <= prices[i + 1], "Prices are not sorted correctly. At index " + i);
	        }
		
	}
}
//Assertion used 