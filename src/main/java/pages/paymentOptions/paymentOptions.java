package pages.paymentOptions;

import static utils.ExtentReporter.extentLog;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class paymentOptions {
	
	private Page page;
	private ExtentTest extentTest;
	private String CardName = "//input[@placeholder='Name on card']";
	private String CardNumber = "//input[@name='cardnumber']";
	private String MonthYear = "//input[@name='exp-date']";
	private String CVC = "//input[@name='cvc']";
	private String ZIP = "//input[@name='postal']";
	
	private String PayButton = "//button[@data-tid='payment.form.pay_button']";
	private String Successtext = "//*[text()='Application submitted successfully']";
	
	private String GotoInvoice = "//*[text()='Go to Invoice']";
	
	private String ViewInvoices = "//*[text()='View invoices']";
	private String GotoHome = "//*[text()='Go to home']";
	 private String clickhomebutton = "//img[@class = 'brand-image']";
	 private String clickonyouraccountimage	 = "(//img[@class = \"rounded-circle\"])[3]";
	 private String Signout2 = "(//a[@data-testid ='signOut'])[2]";
	
	
	
	
	
	
	/**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
	
	public paymentOptions (Page page, ExtentTest extentTest) {
		this.page = page;
        this.extentTest = extentTest;
		}

	
	public void payInFull (String cardName, String cardNumber, String monthYear, String cvc, String zip) throws Exception {
		
			Thread.sleep(2000);
			page.locator(CardName).fill(cardName);
			Thread.sleep(2000);
			FrameLocator framelocator = page.frameLocator("//iframe[@title='Secure card payment input frame']");
			framelocator.locator(CardNumber).fill(cardNumber);
			Thread.sleep(500);
			framelocator.locator(MonthYear).fill(monthYear);
			Thread.sleep(500);
			framelocator.locator(CVC).fill(cvc);
			Thread.sleep(500);
			framelocator.locator(ZIP).fill(zip);
		
			Thread.sleep(2000);
			//page.locator(PayButton).click(new Locator.ClickOptions().setForce(true));
			//Thread.sleep(2000);
		
		
	}
	public void payButton () throws Exception {
		
			page.locator(PayButton).click();
			Thread.sleep(2000);
			page.waitForSelector(Successtext).isVisible();
			extentLog(extentTest, Status.PASS, "User successfully completed application.");
			Thread.sleep(2000);
			page.locator(GotoInvoice).click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(2000);
			page.locator(ViewInvoices).click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(2000);
			page.locator(clickhomebutton).click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(2000);
		
			page.hover(clickonyouraccountimage);
			Thread.sleep(500);
			page.locator(Signout2).click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			extentLog(extentTest, Status.PASS, "User successfully singedout.");
		
		
		
	}
	
	
}
