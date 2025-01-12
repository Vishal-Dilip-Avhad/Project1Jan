package packagemaven.Project_Maven;

import org.testng.Assert;
import org.testng.annotations.Listeners;
//ensure login failed with incorrect email and password
import org.testng.annotations.Test;

@Listeners(Listeners_Logic.class)
public class Test03 extends Launch_Quit {

	@Test(retryAnalyzer = packagemaven.Project_Maven.RetryLogic.class)
	public void checkLoginFail() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.accountandlist_hoverhover(driver);
		home.signin_method();
		Thread.sleep(2000);
		
		LoginPage login = new LoginPage(driver);
		login.wrong_un();
		login.cnt();
		Thread.sleep(2000);

		boolean b1 = login.is_phone_ErrorMessageDisplayed();
		Assert.assertTrue(b1, "Error message not displayed!");

		String expectedErrorMessage = "Incorrect phone number";
		String actualErrorMessage = login.get_phone_ErrorMessage().trim();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected.");

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		login.right_un();
		login.cnt();
		login.wrong_pwd();
		login.signin();
		Thread.sleep(3000);
		

		boolean b2 = login.is_password_ErrorMessageDisplayed();
		Assert.assertTrue(b2, "Error message not displayed!");

		String expectedErrorMessage1 = "Your password is incorrect";
		String actualErrorMessage1 = login.get_password_ErrorMessage().trim();
		Assert.assertEquals(actualErrorMessage1, expectedErrorMessage1, "Error message is not as expected.");

	}
}
