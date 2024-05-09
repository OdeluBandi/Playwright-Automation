package pages.FTandPreSchool;

import static utils.ExtentReporter.extentLog;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class medicalInfoPage {

	private Page page;
	private ExtentTest extentTest;
	private String nextButton4 = "(//button[@data-testid = 'Next'])[4]";

	
	
	/**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
	
	public medicalInfoPage (Page page, ExtentTest extentTest) {
		this.page = page;
        this.extentTest = extentTest;
		}

	
	
	public void mediaclDetails () throws Exception {
		
		//page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		Thread.sleep(3000);
		page.locator(nextButton4).click();
		extentLog(extentTest, Status.INFO, "Medical Info Details Successfully Added.");
		Thread.sleep(500);
	}
}
