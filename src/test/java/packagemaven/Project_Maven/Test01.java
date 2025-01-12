package packagemaven.Project_Maven;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test01 extends Launch_Quit {

	@Test( retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void registration() throws IOException, InterruptedException {
		ExcelSHeet_Data e1=new ExcelSHeet_Data();
		e1.datafetching();
		
		HomePage h1 = new HomePage(driver);
		h1.accountandlist_hoverhover(driver);
		
		h1.create_new_account();
		
		CreateNewAccountPage c1 = new CreateNewAccountPage(driver);
		c1.entername();
		c1.entermobile();
		c1.enterpassword();
		c1.submit();
		Thread.sleep(2000);
		c1.verify_code();

	}
}
