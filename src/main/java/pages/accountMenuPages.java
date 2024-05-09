package pages;

import static utils.ExtentReporter.extentLog;
import static utils.ExtentReporter.extentLogWithScreenshot;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static base.PlaywrightFactory.takeScreenshot;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Page Object Class for Accounts Menu Pages
  */
public class accountMenuPages {

    private Page page;
    private ExtentTest extentTest;
    private String YourAccountheader = "//div//a[text()=' Your Account ']";
    private String Subscriptions = "//div//a[text()=' Subscriptions ']";
    private String Subscriptiontext = "//div//h3[text()='Subscriptions']";
    private String directWithdrawals = "//div//a[text()='Direct Withdrawal']";
    private String editEFTInformation = "//button[text()=' Edit Banking Information ']";
    private String branchTransitNo = "//input[@formcontrolname = 'branchTransitNumber']";
    private String InstitutionIdNo = "//input[@formcontrolname = 'institutionIdNumber']";
    private String accountNo = "//input[@formcontrolname = 'accountNumber']";
    private String voidCheque = "//input[@data-testid = 'voidCheque']";
    private String authcheckbox = "//input[@type = 'checkbox']";
    private String authorizebutton = "//button[text() = ' Authorize ']";
    static String paymentHistoryoption = "//div//a[text()='Payment History']";
    private String paymentHistoryText ="//div//h3[text()='Payment History']";
    private String Donations = "//div//a[text()='Donations']";
    private String donationText = "//div//h3[text()='Donations']";
    private String taxReceipts = "//div//a[text()='Tax Receipts']";
    private String taxReceiptsText = "//div//h3[text()='Tax Receipts']";
    private String viewTaxReceipts = "//a[@class='fe fe-eye receipt-action-icon']";
    private String downloadTaxReceipts = "//a[@class='fe fe-download mr-2 receipt-action-icon']";
    static String Invoices	= "//div//a[text()='Invoices']";
    private String invoicesText = "//div//h3[text()='Invoice']";
    static String applicationStatus = "//div//a[text()='Application status']";
    private String applicationStatusText = "//div//h3[text()='Application Status']";
    private String editProfile = "//div//a[text()='Edit Profile']";
    private String profileImage = "//img[@class='avatar-xl rounded-circle']";
    private String updateImagebutton = "//button[text()=' Update Image ']";
    private String Children = "//div//a[text()='Children']";
    private String addChildbutton = "//button[text()=' Add Child']";
    private String addFirstName	= "//input[@formcontrolname = 'firstName']";
    private String addMiddleName = "//input[@formcontrolname = 'middleName']";
    private String addLastName = "//input[@formcontrolname = 'lastName']";
    private String addDOB = "//input[@formcontrolname = 'dob']";
    private String yearbutton ="//button[@class ='current']";
    private String monthtable = "//table[@class ='months']";
    private String previousButton = "//span[contains(text(),'‹')]";
    private String nextButton = "//span[contains(text(),'›')]";
    private String childGender ="//select[@formcontrolname = 'gender']";
    private String childEmail = "//input[@formcontrolname = 'email']";
    private String saveChilddetails = "//button[text() = ' Save ']";
    private String changePassword = "//div//a[text()='Change Password']";
    private String cancelButton ="//button[@id='cancel']";
    //private String signOut = "//div//a[text()=' Sign Out']";
    private String welcomeimage = "//div//h1[text()='Welcome to MAC Portal ']";
    private String clearfilterbutton = "//button[text() = 'Clear filter ']";
    private String clickhomebutton = "//img[@class = 'brand-image']";
    private String clickonyouraccountimage	 = "(//img[@class = \"rounded-circle\"])[3]";
    private String Signout2 = "(//a[@data-testid ='signOut'])[2]";
    
    

    public accountMenuPages(Page page, ExtentTest extentTest) {
        this.page = page;
        this.extentTest = extentTest;
    }

    		public void subcriptionsPage() throws Exception {
    			
    				page.hover(YourAccountheader);
    				page.waitForSelector(Subscriptions).isVisible();
    				page.waitForLoadState();
    				page.click(Subscriptions);
    				page.waitForLoadState();
    				page.waitForSelector(Subscriptiontext).isVisible();
    				page.waitForLoadState();
    				Thread.sleep(3000);
    				
    				extentLogWithScreenshot(extentTest, Status.INFO, "Subscription details.", takeScreenshot(page));
					return;
    		    				
    		}
    		/**
    	     * Method to add direct withdrawals
      	     * @return 
    	     * @throws Exception 
    	     */
    		
    		public boolean directWithdrwalPage(String branchtransitno, String institutionidno, String AccNo, String voidcheque) throws Exception {
    				
    				page.click(directWithdrawals);
    				page.waitForLoadState();
    				Thread.sleep(2000);
    					
    				if ((page.locator(authorizebutton).isVisible())) {
    					Thread.sleep(3000);
    					page.locator(branchTransitNo).fill(branchtransitno);
    					Thread.sleep(2000);
    					page.locator(InstitutionIdNo).fill(institutionidno);
        				Thread.sleep(2000);
        				page.locator(accountNo).fill(AccNo);
        				Thread.sleep(2000);
        				FileChooser fileChooser = page.waitForFileChooser(() -> page.locator(voidCheque).click());
        				fileChooser.setFiles(Paths.get(voidcheque));
        				page.waitForLoadState();
        				page.locator(authcheckbox).click(new Locator.ClickOptions().setForce(true));
        				Thread.sleep(2000);
        				page.click(authorizebutton);
        				Thread.sleep(5000);
        				extentLogWithScreenshot(extentTest, Status.INFO, "User successfully added directwithdrawal details.", takeScreenshot(page));
        				return true;
        					
    					}
    					boolean isDisplayed = page.textContent(editEFTInformation).contains(" Edit Banking Information ");
    				
    					extentLogWithScreenshot(extentTest, Status.INFO, "User already added directwithdrawal details.", takeScreenshot(page));
        				return isDisplayed;
    				
    		}
    		
    		public void paymentHistoryPage() throws Exception {
    			
    			page.click(paymentHistoryoption);
				page.waitForLoadState();
				page.waitForSelector(paymentHistoryText).isVisible();
				page.waitForLoadState();
				Thread.sleep(3000);
				extentLogWithScreenshot(extentTest, Status.INFO, "Payment History details.", takeScreenshot(page));
		  				
    		}
    		
    		public void donationsPage() throws Exception {
    			
    			page.click(Donations);
    			page.waitForLoadState();
				page.waitForSelector(donationText).isVisible();
				page.waitForLoadState();
				Thread.sleep(3000);
				
				extentLogWithScreenshot(extentTest, Status.INFO, "Donation details.", takeScreenshot(page));
				return;
    		    			
    		}
    		
    		public void taxReceiptPage() throws Exception {
    			Thread.sleep(2000);
    			page.click(taxReceipts);
    			page.waitForLoadState();
				page.waitForSelector(taxReceiptsText).isVisible();
				Thread.sleep(3000);
				/* if (page.locator(viewTaxReceipts).isVisible()) {
					Thread.sleep(2000);
					page.click(downloadTaxReceipts);
					Thread.sleep(5000);
					page.click(viewTaxReceipts);
					Thread.sleep(5000); 
					
					
					extentLogWithScreenshot(extentTest, Status.INFO, "TaxReceipts details were viewed and downloaded.", takeScreenshot(page));
					return;
				} */
							
				extentLogWithScreenshot(extentTest, Status.INFO, "No Tax Receipts found for the User.", takeScreenshot(page));
				return;
    			
    		}
    		
    		public void invoicesPage() throws Exception {
    			
    			Thread.sleep(2000);
    			page.click(Invoices);
    			page.waitForLoadState();
				page.waitForSelector(invoicesText).isVisible();
				Thread.sleep(3000);
				extentLogWithScreenshot(extentTest, Status.INFO, "All invoices for the parent", takeScreenshot(page));
				return;
    		}
    		
    		public void applicationStatusPage() throws Exception {
    			
    			Thread.sleep(2000);
    			page.click(applicationStatus);
    			page.waitForLoadState();
				page.waitForSelector(applicationStatusText).isVisible();
				Thread.sleep(3000);
				extentLogWithScreenshot(extentTest, Status.INFO, "All Applications with respective status", takeScreenshot(page));
				return;
    			
    		}
    		
    		public boolean editProfilePage(String ProfileImagePath) throws Exception {
    			
    			Thread.sleep(2000);
    			page.click(editProfile);
    			page.waitForLoadState();
				page.waitForSelector(profileImage).isVisible();
				Thread.sleep(3000);
				extentLogWithScreenshot(extentTest, Status.INFO, "Profile details", takeScreenshot(page));
				
				
				if ((page.locator(updateImagebutton).isDisabled())) {
					
					FileChooser fileChooser = page.waitForFileChooser(() -> page.locator(profileImage).click());
    				fileChooser.setFiles(Paths.get(ProfileImagePath));
    				page.click(updateImagebutton);
    				Thread.sleep(3000);
    				extentLogWithScreenshot(extentTest, Status.INFO, "Profile details", takeScreenshot(page));
				}
				boolean isEnabled = page.locator(updateImagebutton) != null;
				
				extentLogWithScreenshot(extentTest, Status.INFO, "Complete Profile details with image", takeScreenshot(page));
				return isEnabled;
    		}
    		
    		public void chidrenPageNav() throws Exception {
    			
    			Thread.sleep(2000);
    			page.click(Children);
    			page.waitForSelector(addChildbutton).isVisible();
				Thread.sleep(2000);
				page.click(addChildbutton);
    		}
    		
    		public void childrenPage(String Firstname, String Middlename, String Lastanme, String dob, String gender, String childemail) throws Exception {
    			
    			
				Thread.sleep(1000);
				page.locator(addFirstName).fill(Firstname);
				Thread.sleep(1000);
				page.locator(addMiddleName).fill(Middlename);
				Thread.sleep(1000);
				page.locator(addLastName).fill(Lastanme);
				Thread.sleep(1000);
				page.click(addDOB);

    		    String[] dateParts = dob.split(" ");
    		    String year = dateParts[2];
    		    String month = dateParts[0];
    		    String date = dateParts[1];

    		    page.click("//button[@class ='current']");
    		    Thread.sleep(2000);
    		    
    		  
    		    while (!page.isVisible("table.years span:has-text('" + year + "')")) {
    		        page.click("button.previous");
    		        Thread.sleep(500); // Add a short delay to allow the UI to update
    		    }

    		    page.click("table.years span:has-text('" + year + "')");
    		    Thread.sleep(500);
    		    page.click("table.months span:has-text('" + month + "')");
    		    Thread.sleep(500);
    		    //String currentMonthSelector = "table.days span:not(.is-other-month):not(.disabled):has-text('\" + date + \"')";
    		    page.click("table.days span:not(.is-other-month):not(.disabled):has-text('" + date + "')");
    		    //page.click(currentMonthSelector);
    		    Thread.sleep(2000);
    		    //extentLogWithScreenshot(extentTest, Status.INFO, "dob added successfully", takeScreenshot(page));
    		    
    		    page.locator(childGender).selectOption(gender);
				Thread.sleep(2000);
				page.locator(childEmail).fill(childemail);
				Thread.sleep(2000);
				page.click(saveChilddetails);
				extentLog(extentTest, Status.INFO, "child added successfully.");
				Thread.sleep(3000);
				
				//extentLogWithScreenshot(extentTest, Status.INFO, "child added successfully", takeScreenshot(page));
		   			
    		}
    	    		
		public void navigations() throws Exception { 
    				
    				page.click(Children);
    				//assertThat(page).hasTitle(Pattern.compile("pageTitle")); //"[“assertThat”] overloads with a built-in waiting mechanism. This means the assertion will patiently wait until the expected condition is fulfilled before proceeding"
    				
    				page.waitForLoadState();
    				page.click(changePassword);
    				page.click(cancelButton);
    				page.waitForLoadState();
    				page.click(clickhomebutton);
    				Thread.sleep(3000);
    				    	
    					if (page.waitForSelector(loginPage.welcomeimage) != null) {
    							extentLog(extentTest, Status.PASS, "User successfully navigated to home page.");
    								return;
    					}
    		}
    	
    		public void clearFilterOptions() throws Exception {
    	
    				if (page.locator(clearfilterbutton).isEnabled() == true) {
    						
    						page.click(clearfilterbutton);
    						extentLog(extentTest, Status.PASS, "User successfully click on clear filter if enabled.");
    						page.hover(clickonyouraccountimage);
    						page.click(Signout2);
    						extentLog(extentTest, Status.PASS, "User successfully singedout after clearing the filter if enabled.");
    						return;
    					}
    				
    				else {
    						page.hover(clickonyouraccountimage);
    						page.click(Signout2);
    						extentLog(extentTest, Status.PASS, "User successfully singedout.");
    							return;
    					  }
    		}
    
    }
    
      


