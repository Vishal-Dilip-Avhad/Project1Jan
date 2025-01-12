package packagemaven.Project_Maven;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
//verify that searching with filters(category(done), price range(not able to use slider)) 
public class Test06 extends Launch_Quit{

	@Test( retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void verify_searching_with_filters_category_price_range() throws InterruptedException  {
	
		HomePage h1 = new HomePage(driver);
		h1.searching_jeans();
		h1.get_jeans();
		
		
		List<WebElement> t1 = driver.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']"));
		int validItemCount = 0;
		int totalItems = t1.size();
		
		for (WebElement element : t1) {
		    String itemName = element.getText().toLowerCase(); 
		    
		    
		    if (itemName.contains("men") || itemName.contains("mens")) {
		    	validItemCount++;
		        System.out.println("Valid item: " + itemName); 
		    } else {
		        System.out.println("Invalid item: " + itemName); 
		    }
		}
		double validItemPercentage = (validItemCount / (double) totalItems) * 100;
		Assert.assertTrue(validItemPercentage >= 80);
		System.out.println("Valid items: " + validItemCount + "/" + totalItems);
		System.out.println("Valid item percentage: " + validItemPercentage + "%");
	}
}
