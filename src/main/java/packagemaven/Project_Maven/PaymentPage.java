package packagemaven.Project_Maven;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
	 WebDriver driver;
		
		//@FindBy(xpath="(//div[@data-a-input-name='ppw-instrumentRowSelection'])[1]") WebElement bajajfinserveradiobutton;
		@FindBy(xpath="//input[@value='SelectableAddCreditCard']") WebElement creditordebitcardbutton;
		
		@FindBy(xpath="//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']") WebElement netbankingbutton;
		@FindBy(xpath = "//input[@value='instrumentId=amzn1.pm.poa.YW16bjEucG9hOmFtem4xLnBvYS5wb2RhLlVuaWZpZWRQYXltZW50c0ludGVyZmFjZTox.QTFJVFVXMzczVDk3RDA&isExpired=false&paymentMethod=UnifiedPaymentsInterface&tfxEligible=false']") WebElement otherupiappbutton;
		
		@FindBy(xpath="//input[@value='instrumentId=EMI&isExpired=false&paymentMethod=CC&tfxEligible=false']") WebElement emibutton;
		@FindBy(xpath="//input[@value='instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']") WebElement cashondeliverybutton;
		
		 
		
		@FindBy(xpath="//input[@id='pp-L9h3OV-106']") WebElement entercodefield;
		@FindBy(xpath="//a[normalize-space()='Change']") WebElement changedeliveryaddress;
		@FindBy(xpath="//span[@id='shipToThisAddressButton']") WebElement usethisaddress;
		@FindBy(xpath="(//span[contains(text(),'Deliver to this address')])[2]") WebElement delivertothisaddress;
		
		
		@FindBy(xpath ="(//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'])[1]") WebElement usethispaymentmethod;
		@FindBy(xpath="(//span[@data-action='select-address-in-list'])[2]") WebElement usenewaddress;
		//shipToThisAddressButton
		
		@FindBy(xpath="//h3[@class='a-color-state']") WebElement selectpaymentmethodtxt;
		@FindBy(xpath="//h4[@class='a-color-error']") WebElement errortxt;
		@FindBy(xpath="//input[@name='continue-bottom']") WebElement savequantities;
		
		
		@FindBy(xpath="//a[@id='payChangeButtonId']") WebElement changepaymentmethod;
		@FindBy(xpath="//span[contains(text(),'Arriving')]") WebElement arrivingdate;
		@FindBy(xpath="(//input[@name=\"placeYourOrder1\"])[1]") WebElement placeyourorder;
		@FindBy(xpath ="//input[@class='a-input-text a-form-normal a-width-large a-span9 pmts-claim-code']") WebElement applycoupon;
		@FindBy(xpath ="//input[@name='ppw-claimCodeApplyPressed']") WebElement submitcoupon;
		@FindBy(xpath ="//div//p[contains(text(),'The promotional code you entered is not valid.')]") WebElement couponerrormassage;
		
//		public boolean select_bajaj_finserve() throws InterruptedException
//		{
//			//bajajfinserveradiobutton.click();
//			Thread.sleep(2000);
//			return bajajfinserveradiobutton.isSelected();
//			
//		}
		public boolean select_creditcard() throws InterruptedException
		{
			creditordebitcardbutton.click();
			Thread.sleep(1000);
			return creditordebitcardbutton.isSelected();
				
		}
		public boolean select_netbanking() throws InterruptedException
		{
			netbankingbutton.click();
			Thread.sleep(1000);
			return netbankingbutton.isSelected();
		
		}
		public boolean select_otherupi()
		{
			otherupiappbutton.click();
			return otherupiappbutton.isSelected();
			
		}
		public boolean select_emi()
		{
			emibutton.click();
			return emibutton.isSelected();
				
		}
		public boolean select_cashondelivery()
		{
			cashondeliverybutton.click();
			return cashondeliverybutton.isSelected();
			
		}
		public void save_quantities(WebDriver driver) throws InterruptedException {
			try {
				savequantities.click();
			}
			catch(NoSuchElementException e) {
				System.out.println("quantities saved moving to next step");
			}
			driver.navigate().refresh();
		      Thread.sleep(5000);
		}
		public void use_this_adresss(WebDriver driver) throws InterruptedException {
			try {
			
				usethisaddress.click();
				Thread.sleep(7000);
				
			}
			catch(NoSuchElementException e) {
				delivertothisaddress.click();
			}
	
			 catch (Exception e) {
			       
			        System.out.println("An unexpected error occurred while interacting with the address element");
			        
			    }
		      driver.navigate().refresh();
		      Thread.sleep(5000);
			
			
		}
		public void finalcheckout() {
			usethispaymentmethod.click();
		}
		public boolean place_your_order() {
			return placeyourorder.isDisplayed();
		}
		public String arriving_txt() {
			
			return arrivingdate.getText();
			
		}
		public void apply_coupon() throws InterruptedException {
			applycoupon.sendKeys("Chrismas10");
			submitcoupon.click();
			Thread.sleep(4000);
			if(couponerrormassage.isDisplayed()) {
				System.out.println("user can able to apply coupon");
			}
		}
		public void change_delivery_adress() {
			try {
			WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(changedeliveryaddress)).click();
			}
			catch(NoSuchElementException e ) {
				System.out.println("change deliver adresss not present moving to next step");
			}
		}
		public void use_new_adress() throws InterruptedException {
			Thread.sleep(2000);
			usenewaddress.click();
		}
		public void change_payment_method() throws InterruptedException {
			Thread.sleep(3000);
			try {
			changepaymentmethod.click();
			}
			catch(NoSuchElementException e) {
				System.out.println("next step ");
			}
		}
		public void use_this_payment_method(WebDriver driver) throws InterruptedException {
			try {
			WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(usethispaymentmethod)).click();
			}
			catch(NoSuchElementException e ) {
				System.out.println("next step");
			}
			
		}
		public PaymentPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
}

