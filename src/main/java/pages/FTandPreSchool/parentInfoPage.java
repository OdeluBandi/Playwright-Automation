package pages.FTandPreSchool;

import static utils.ExtentReporter.extentLog;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class parentInfoPage {
	
		private Page page;
		private ExtentTest extentTest;
		private String userPrimaryContact = "//input[@data-testid = 'IsUserPrimaryContact']";
		private String userGender = "//select[@formcontrolname = 'userGender']";
		private String useraddress ="//input[@data-testid = 'isFatherAddDifferentCheck']";
		private String street = "//input[@formcontrolname = 'userAddressLine1']";
		private String appartment = "//input[@formcontrolname = 'userAddressLine2']";
		private String city = "//input[@formcontrolname = 'userCity']";
		private String province = "//input[@formcontrolname = 'userProvince']";
		private String postalcode = "//input[@formcontrolname = 'userPostalCode']";
		private String userCellphone = "//input[@formcontrolname = 'userCellName']";
		private String spousefirstname = "//input[@formcontrolname = 'spouseFirstName']";
		private String spouselastname = "//input[@formcontrolname = 'spouseLastName']";
		private String spousecellnumber = "//input[@formcontrolname = 'spouseCellName']";
		private String spouseemail = "//input[@formcontrolname = 'spouseEmail']";
		private String nextButton = "(//button[@data-testid= 'Next'])[1]";
		
	
	/**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
	
	public parentInfoPage (Page page, ExtentTest extentTest) {
		this.page = page;
        this.extentTest = extentTest;
		}
	
			public void primaryContactCheck () throws Exception {
		
					if (page.isChecked(userPrimaryContact)) {
						extentLog(extentTest, Status.INFO, "User is the Primary Contact.");
						return;
					}
					else {
						extentLog(extentTest, Status.INFO, "Spouse is the Primary Contact.");
						return;
					}
			}
		
			public void genderCheck (String usergender, String Street, String Appartment, String City, String Province, 
										String Postalcode, String usercellphone, String spouseFirstName, String spouseLastname, 
											String spouseCellPhone, String spouseEmail) throws Exception {
							Thread.sleep(3000);
							//page.waitForLoadState(LoadState.DOMCONTENTLOADED);
					if (!(page.locator(userGender).inputValue() != null)) {
						extentLog(extentTest, Status.INFO, "New User - need to update all.");
						page.locator(userGender).fill(usergender);
						page.locator(street).fill(Street);
						page.locator(appartment).fill(Appartment);
						page.locator(city).fill(City);
						page.locator(province).fill(Province);
						page.locator(postalcode).fill(Postalcode);
						page.locator(userCellphone).fill(usercellphone);
						page.locator(spousefirstname).fill(spouseFirstName);
						page.locator(spouselastname).fill(spouseLastname);
						page.locator(spousecellnumber).fill(spouseCellPhone);
						page.locator(spouseemail).fill(spouseEmail);
						extentLog(extentTest, Status.INFO, "New User added parent/guardian info successfully and navigated to Student info page.");
						Thread.sleep(2000);
						page.click(nextButton);
												
						return;
					}
					else {
						Thread.sleep(3000);
						Locator NextButton = page.locator(nextButton);
						NextButton.scrollIntoViewIfNeeded();
						NextButton.click();
						Thread.sleep(5000);
						extentLog(extentTest, Status.INFO, "Existing User navigated to Student info page");
						return;
					}
			}
		
			
	}
	



