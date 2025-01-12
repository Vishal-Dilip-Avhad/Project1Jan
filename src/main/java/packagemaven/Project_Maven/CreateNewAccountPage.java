package packagemaven.Project_Maven;

import java.util.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage extends ExcelSHeet_Data
{

	@FindBy(xpath = "//input[@name='customerName']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id='ap_phone_number']")
	WebElement mobileField;
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement passwordField;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement verifyphonebutton;
	@FindBy(xpath = "//input[@id='auth-pv-enter-code']")
	WebElement verifycodeField;
	@FindBy(xpath = "//button[normalize-space()='Start Puzzle']")
	WebElement solvethispuzzle;

	public void entername() {

		usernameField.sendKeys(fullnamevalue);
	}

	public void entermobile() {

		mobileField.sendKeys(mobilenumbervalue);
	}

	public void enterpassword() {

		passwordField.sendKeys(passwordvalue);
	}

	public void submit() {
		verifyphonebutton.click();
	}

	public void verify_code() {
		try {

			if (solvethispuzzle.isDisplayed()) {
				System.out.println("Puzzle is displayed and the user can register.");
			} else {
				System.out.println("Puzzle is not displayed.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Puzzle element not found on the page.");
		} catch (StaleElementReferenceException e) {
			System.out.println("The element reference is no longer valid.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	public CreateNewAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
