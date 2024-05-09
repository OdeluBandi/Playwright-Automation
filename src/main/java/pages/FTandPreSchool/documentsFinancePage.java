package pages.FTandPreSchool;

import static utils.ExtentReporter.extentLog;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class documentsFinancePage {
	
	
	private Page page;
	private ExtentTest extentTest;
	private String birthCertificate = "//input[@data-testid = 'birthCert']";
	private String healthCard = "//input[@data-testid = 'albertaHealthCard']";
	private String financialAgreement = "//*[@data-target= '#financialAgreementModal']";
	private String parentalAgreement = "//*[@data-target= '#agreementModal']";
	private String custodyDoc = "//input[@data-testid= 'custodyDoc']";
	private String previousReportCard = "//input[@data-testid= 'reportCard']";
	private String immunizationRecord = "//input[@data-testid= 'immunizationDoc']";
	private String termsofService = "//input[@data-testid= 'temsCheck']";
	private String additionalComments = "//textarea[@formcontrolname= 'additionalComment']";
	private String applyButtonOnPage4 = "//button[text() = 'Apply']";
	private String Waitlistconfirmation = "//button[text()='Continue']";
	
	
	/**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
	
	public documentsFinancePage (Page page, ExtentTest extentTest) {
		this.page = page;
        this.extentTest = extentTest;
		}

	
	public void documentsAndFinanceDetails(String birthcertificate, String healthcard, String custodydocument, 
											String previousreportcard, String immunizationrecord) throws Exception {
		
			//page.waitForLoadState(LoadState.DOMCONTENTLOADED);
			Thread.sleep(2000);
			FileChooser fileChooser1 = page.waitForFileChooser(() -> page.locator(birthCertificate).click());
			fileChooser1.setFiles(Paths.get(birthcertificate));
			Thread.sleep(2000);
			FileChooser fileChooser2 = page.waitForFileChooser(() -> page.locator(healthCard).click());
			fileChooser2.setFiles(Paths.get(healthcard));
			Thread.sleep(2000);
			FileChooser fileChooser3 = page.waitForFileChooser(() -> page.locator(custodyDoc).click());
			fileChooser3.setFiles(Paths.get(custodydocument));
			Thread.sleep(2000);
			FileChooser fileChooser4 = page.waitForFileChooser(() -> page.locator(previousReportCard).click());
			fileChooser4.setFiles(Paths.get(previousreportcard));
			Thread.sleep(2000);
			FileChooser fileChooser5 = page.waitForFileChooser(() -> page.locator(immunizationRecord).click());
			fileChooser5.setFiles(Paths.get(immunizationrecord));
		
	}
	
	public void agreements (String financesignature, String parentalSingature, String comments)throws Exception {
			//Financial Agreement
			page.locator(financialAgreement).click();
			Thread.sleep(2000);
			//Payment Terms: 
			page.locator("//input[@data-testid= 'financial_agreement_0']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_1']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_2']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_3']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_4']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_5']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_6']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_7']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_8']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			
			//Refund/Withdrawal Policy: 
			page.locator("//input[@data-testid= 'financial_agreement_02']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_12']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_22']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_32']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'financial_agreement_42']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			//Signature:
			page.locator("(//input[@placeholder= 'Your name'])[1]").fill(financesignature);
			Thread.sleep(500);
			page.locator("(//button[text()= 'Accept'])[1]").click();
			
			Thread.sleep(3000);
			
			//Parental Agreement
			page.locator(parentalAgreement).click();
			Thread.sleep(2000);
			//Parental Agreement Statement: 
			page.locator("//input[@data-testid= 'parentalAgreement_01']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_11']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_21']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_31']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_41']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_51']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_61']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_71']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_81']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_91']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_101']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_111']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_121']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_131']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_141']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_151']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_161']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_171']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_181']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_191']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			
			//In the Event of Illness and/or Medical Emergencies: 
			page.locator("//input[@data-testid= 'parentalAgreement_07']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_17']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			page.locator("//input[@data-testid= 'parentalAgreement_27']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			
			//Media/School Website Permission: 
			page.locator("//input[@data-testid= 'medicalPermissionYes']").click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			
			//Signature:
			page.locator("(//input[@placeholder= 'Your name'])[2]").fill(parentalSingature);
			Thread.sleep(500);
			
			
			page.locator("(//button[text()= 'Accept'])[2]").click();
			
			Thread.sleep(3000);
			
			
			//terms of service
			page.locator(termsofService).click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(500);
			//Additional comments:
			page.locator(additionalComments).fill(comments);
			Thread.sleep(500);
			page.locator(applyButtonOnPage4).click();
	
	}
	
	public void refreshWebPage01() throws Exception{
			Thread.sleep(3000);
			page.locator("//*[@id='registerPaymentModalLabel']").isVisible();
			page.reload();
					
	}
	
	public void waitlistAlertPopup () throws Exception {
			
			Thread.sleep(2000);
			page.waitForSelector(Waitlistconfirmation).isVisible();
			extentLog(extentTest, Status.INFO, "Waitlist Confirmation Popup displayed");
			page.locator(Waitlistconfirmation).click();
		
	}
}
