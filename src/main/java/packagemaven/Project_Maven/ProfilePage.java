package packagemaven.Project_Maven;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement user_accountandlist;
	@FindBy(xpath = "//span[contains(text(),'Your Account')]")
	WebElement youraccount;
	@FindBy(xpath = "//span[.='Edit login, name, and mobile number']")
	WebElement editinfo;
	
	@FindBy(xpath = "//a[@aria-label='Edit name']")
	WebElement editname;
	@FindBy(css = "*[name='customerName']")
	WebElement cutomername;
	@FindBy(id = "cnep_1C_submit_button")
	WebElement updatenamebutton;
	@FindBy(id = "SUCCESS_MESSAGES")
	WebElement updatenamesuccessmassage;
	

	public void user_profile(WebDriver driver) {
		Actions a2 = new Actions(driver);
		a2.moveToElement(user_accountandlist).perform();
	}

	public void user_account() {
		youraccount.click();
	}

	public void user_info() {
		editinfo.click();
	}

	public void edit_name() {
		editname.click();
	}
	
	public void user_name() {
		cutomername.clear();
		cutomername.sendKeys("Vishal Avhad");
	}
    
	public void user_update() {
		updatenamebutton.click();		
	}
	
	public boolean updateMassage() {
		return updatenamesuccessmassage.isDisplayed();
	}
	
	public String updateMassageText() {
		return updatenamesuccessmassage.getText();
	}
	
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
