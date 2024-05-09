package pages.FTandPreSchool;

import static utils.ExtentReporter.extentLog;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class emergencyContactPage {
	
	private Page page;
	private ExtentTest extentTest;
	private String hasCustody ="//input[@data-testid = 'parentHasCustody']";
	private String livesWith = "//input[@data-testid = 'parentLivesWith']";
	private String schoolPickUp = "//input[@data-testid = 'parentSchoolPickup']";
	private String emergencyContact = "//input[@data-testid = 'parentEmergencyContact']";
	private String receivesMail = "//input[@data-testid = 'parentReceivesMail']";
	private String hasCustodySpouse ="//input[@data-testid = 'spouseHasCustody']";
	private String livesWithSpouse = "//input[@data-testid = 'spouseLivesWith']";
	private String schoolPickUpSpouse = "//input[@data-testid = 'spouseSchoolPickup']";
	private String emergencyContactSpouse = "//input[@data-testid = 'spouseEmergencyContact']";
	private String receivesMailSpouse = "//input[@data-testid = 'spouseReceivesMail']";
	private String emerContactFirstName = "//input[@formcontrolname = 'emContactName']";
	private String emerContacttLastName ="//input[@formcontrolname = 'emergencyContactLastName']";
	private String emerPhoneType = "//select[@formcontrolname = 'dayPhoneType']"; 					//dropdown
	private String emerPhoneNumber = "//input[@formcontrolname = 'emPhoneNumber']";
	private String emetRelationShip = "//input[@formcontrolname = 'relationship']";
	private String authorizeFirstName = "//input[@formcontrolname = 'name']";
	private String authorizeLastName = "//input[@formcontrolname = 'lastName']";
	private String authorizePhoneType = "//select[@formcontrolname = 'phoneType']";					//dropdown
	private String suthorizePhoneNumber = "//input[@formcontrolname = 'phone']";
	private String nextButton3 = "(//button[@data-testid = 'Next'])[3]";
	
	
	
	/**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
	
	public emergencyContactPage (Page page, ExtentTest extentTest) {
		this.page = page;
        this.extentTest = extentTest;
		}

	
	
	public void emergencyContactDetails (String emerconatctfirstname, String emercontactlastname, String emerphonetype, String emerphonenumber, 
											String emerrelationship, String authorizefirstname, String authorizelastname, String authorizephonetype, 
												String autorizephonenumber) throws Exception {
					//page.waitForLoadState(LoadState.DOMCONTENTLOADED);
					Thread.sleep(3000);
					page.locator(hasCustody).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(livesWith).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(schoolPickUp).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(emergencyContact).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(receivesMail).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(hasCustodySpouse).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(livesWithSpouse).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(schoolPickUpSpouse).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(emergencyContactSpouse).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(receivesMailSpouse).click(new Locator.ClickOptions().setForce(true));
					Thread.sleep(500);
					page.locator(emerContactFirstName).fill(emerconatctfirstname);
					Thread.sleep(500);
					page.locator(emerContacttLastName).fill(emercontactlastname);
					Thread.sleep(500);
					page.locator(emerPhoneType).selectOption(emerphonetype);
					Thread.sleep(500);
					page.locator(emerPhoneNumber).fill(emerphonenumber);
					Thread.sleep(500);
					page.locator(emetRelationShip).fill(emerrelationship);
					Thread.sleep(500);
					page.locator(authorizeFirstName).fill(authorizefirstname);
					Thread.sleep(500);
					page.locator(authorizeLastName).fill(authorizelastname);
					Thread.sleep(500);
					page.locator(authorizePhoneType).selectOption(authorizephonetype);
					Thread.sleep(500);
					page.locator(suthorizePhoneNumber).fill(autorizephonenumber);
					Thread.sleep(500);
					page.locator(nextButton3).scrollIntoViewIfNeeded();
					page.locator(nextButton3).click();
					extentLog(extentTest, Status.INFO, "Emergency Contact Details Successfully Added.");
					Thread.sleep(500);
					
		
	}

}
