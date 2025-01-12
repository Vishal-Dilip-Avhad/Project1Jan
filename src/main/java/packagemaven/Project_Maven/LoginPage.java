package packagemaven.Project_Maven;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ExcelSHeet_Data{
	
	//step 1
	@FindBy(xpath="//input[@type='email']") WebElement username;
	@FindBy(id="continue") WebElement continue_button;
	@FindBy(name="password") WebElement password;
	@FindBy(id="signInSubmit") WebElement signin_button;

	
	@FindBy(xpath ="//h4[normalize-space()='Incorrect phone number']") WebElement wrong_phone_error;
	@FindBy(xpath ="//span[contains(text(),'Your password is incorrect')]") WebElement wrong_password_error;
	
	//     (//span[@class='a-list-item'])[1]
  
	public void un()
	{
		username.sendKeys(unsername1);	
	}
	public void cnt()
	{
		continue_button.click();
	}
	public void pwd()
	{
		password.sendKeys(password1);
		
	}
	public void signin()
	{
		signin_button.click();
	}
	public void wrong_un()
	{
		username.sendKeys("9922510365");	
	}
	public void right_un()
	{
		username.sendKeys("9922510362");	
	}
	public void wrong_pwd()
	{
		password.sendKeys("Iamback@");
		
	}

	public String get_phone_ErrorMessage() {
        return wrong_phone_error.getText();
    }

    public boolean is_phone_ErrorMessageDisplayed() {
        return wrong_phone_error.isDisplayed();
    }
    public String get_password_ErrorMessage() {
        return wrong_password_error.getText();
    }

    public boolean is_password_ErrorMessageDisplayed() {
        return wrong_password_error.isDisplayed();
    }
	//step 3
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
