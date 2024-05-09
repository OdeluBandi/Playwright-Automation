	package pages;

import static utils.ExtentReporter.extentLog;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLog;
import static utils.ExtentReporter.extentLogWithScreenshot;

/**
 * Page Object Class for Login Page
*/
public class loginPage {

    private Page page;
    private ExtentTest extentTest;
    private String emailId = "//input[@id='email']";
    private String secretkey = "//input[@id='password']";
    private String loginBtn = "//button[@id='next']";
    static String welcomeimage = "//div//h1[text()='Welcome to MAC Portal ']";
    private String alertErrorSelector ="//div[@class='error pageLevel']";
    
    
    /**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
    public loginPage(Page page, ExtentTest extentTest) {
        this.page = page;
        this.extentTest = extentTest;
    }

    /**
     * Method to get Login page title
     * 
     * @return String - Returns page title
     */
    public String getLoginPageTitle() {
        page.waitForLoadState();
        return page.title();
    }

    /**
     * Method to Login using the username and password
     * 
     * @param appUserName - {@link String} username for the App
     * @param appPassword - {@link String} username for the password
     * @return 
     * @throws Exception 
     */
    public boolean doLogin(String Username, String Password) throws Exception {
    	extentLog(extentTest, Status.INFO, "Login to Application using username and password " + Username + Password);
        page.fill(emailId, Username);
        page.fill(secretkey, Password);
        Thread.sleep(2000);
        page.click(loginBtn);
        Thread.sleep(5000);
        
        if (page.locator(welcomeimage).isVisible()) {
            extentLog(extentTest, Status.PASS, "User login to the Application successful.");
            return true;
        }
        boolean isErrorDisplayed = page.textContent(alertErrorSelector)
                .contains("We can't seem to find your account.");
        extentLogWithScreenshot(extentTest, Status.FAIL, "User login to the Application is unsuccessful.",
                takeScreenshot(page));
        return !isErrorDisplayed;
    }
    
    public void applyLogin(String Username, String Password) throws Exception {
    	extentLog(extentTest, Status.INFO, "Login to Application using username and password " + Username + Password);
        page.fill(emailId, Username);
        page.fill(secretkey, Password);
        Thread.sleep(2000);
        page.click(loginBtn);
        Thread.sleep(5000);
        extentLog(extentTest, Status.PASS, "User login to the Application successful.");
    }
         	
}

