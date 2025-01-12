package packagemaven.Project_Maven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//verify login with correct email and password
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listeners_Logic.class)
public class Test02 extends Launch_Quit {

	
	@Test( retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void login_to_amazon() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelSHeet_Data e1=new ExcelSHeet_Data();
		e1.datafetching();
		
		HomePage home = new HomePage(driver);
		home.accountandlist_hoverhover(driver);
		home.signin_method();
		
        LoginPage login = new LoginPage(driver);
		login.un();
		login.cnt();
		Thread.sleep(2000);
		login.pwd();
		login.signin();
		Thread.sleep(2000);

		String txt = home.user_profile();
		Assert.assertEquals(true, txt.contains("Hello, Vishal"), "assertion fail txt user is incorrect");

	}

}
