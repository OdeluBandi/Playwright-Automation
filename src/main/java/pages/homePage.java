package pages;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

/**
 * Page Object Class for Home Page
 */
public class homePage {

	private Page page;
	private ExtentTest extentTest;

	private String loginLink = "text=English English French Login >> li[role=\"button\"]";
	private String clearfilter = "getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(\"Clear filter\"))";
	/**
	 * Constructor to initialize the page objects with the {@link Page} instance and
	 * {@link ExtentTest} instance
	 * 
	 * @param page       - {@link Page}
	 * @param extentTest - {@link ExtentTest}
	 */
	public homePage(Page page, ExtentTest extentTest) {
		this.page = page;
		this.extentTest = extentTest;
	}

	/**
	 * Method to retrieve the Home Page title
	 * @return String - Returns page title
	 */
	public String getHomePageTitle() {
		page.waitForLoadState();
		return page.title();
	}

	/**
	 * Method to navigate from Homepage to Login page
	 * 
	 * @return LoginPage - Returns {@link LoginPage} instance
	 */
	public loginPage navigateToLoginPage() {
		page.click(loginLink);
		return new loginPage(page, extentTest);
	}

	public loginPage clearfilter() {
		page.click(clearfilter);
		return new loginPage(page, extentTest);
	
	}
	

}
