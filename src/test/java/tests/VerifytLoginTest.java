package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.homePage;
import testUtils.ExcelUtils;

/**
 * TestNG Test class - Login Functionality
 */
public class VerifytLoginTest extends testBase {

	 @DataProvider(name = "loginTest")
		public static Object[][] loginData() throws Exception {
		
			ExcelUtils loginData = new ExcelUtils();
			Object[][] testObjArray = loginData.getTableArray(".\\src\\test\\java\\testUtils\\datasheet.xlsx", "login");
		

		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	/**
	 * BeforeClass Method to create ExtentTest in Extent Report
	 */
	@BeforeClass
	public void setupBeforeClass() {
		extentTest = reporter.createTest("VerifytLoginTests", "Verify login functionality");
	}

	/**
	 * Test the login functionality of the application with valid credentials
	 * This test will soft assert the home page title and validate the login
	 * @throws Exception 
	 */
	@Test (dataProvider = "loginTest")
	public void loginWithValidCredentialsTest(String Username, String Password) throws Exception {
		testNode = extentTest.createNode("TC-01 Verify Login with Valid Credentials");
		testNode.assignCategory("TC01-Login");
		homePage = new homePage(page, testNode);
		softAssert.assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE);
		loginPage = homePage.navigateToLoginPage();
		loginPage.doLogin( Username, Password);
		
	}

	
}
