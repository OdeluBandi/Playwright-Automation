package pages;

import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLogWithScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class applicationStatusFlowRegistrationPages {
	
	private Page page;
    private ExtentTest extentTest;
    private String YourAccountheader = "//div//a[text()=' Your Account ']";
    static String applicationStatus = "//div//a[text()=' Application status ']";
    private String applicationStatusText = "//div//h3[text()='Application Status']";
    private String incompleteapplication = "(//div//a[text() = 'Complete your application '])[1]";
    
    
    public applicationStatusFlowRegistrationPages(Page page, ExtentTest extentTest) {
        this.page = page;
        this.extentTest = extentTest;
    }
    
	public void applicationStatusflowPage() throws Exception {
		
		Thread.sleep(2000);
		page.locator(YourAccountheader).scrollIntoViewIfNeeded();
		page.hover(YourAccountheader);
		page.waitForSelector(applicationStatus).isVisible();
		page.waitForLoadState();
		page.click(applicationStatus);
		page.waitForLoadState();
		page.waitForSelector(applicationStatusText).isVisible();
		page.locator(incompleteapplication).click(new Locator.ClickOptions().setForce(true));
		
		
		
		
		
	}

}
