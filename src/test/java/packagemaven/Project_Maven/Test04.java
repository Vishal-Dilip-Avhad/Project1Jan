 package packagemaven.Project_Maven;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
//user can successfully edit their info
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Listeners_Logic.class)
public class Test04 extends Launch_Quit{

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void verify_user_info_edit() throws InterruptedException, EncryptedDocumentException, IOException {
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
		
		ProfilePage p1 = new ProfilePage(driver);
		p1.user_profile(driver);
		p1.user_account();
		Thread.sleep(2000);
		p1.user_info();
		Thread.sleep(3000);
		p1.edit_name();
		
		p1.user_name();
		p1.user_update();

		boolean b1 = p1.updateMassage();
		Assert.assertTrue(b1, "Error message not displayed!");

		String expectedErrorMessage = "Name updated.";
		String actualErrorMessage = p1.updateMassageText().trim();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected.");
		
		
		
	}
}
