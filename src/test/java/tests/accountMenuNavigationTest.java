package tests;

import java.nio.file.Path;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.homePage;
import pages.accountMenuPages;
import testUtils.ExcelUtils;


/**
 * TestNG Test class - Add Product to Cart
 * @param <loginPage>
 * @param <loginPage>
 */
public class accountMenuNavigationTest extends testBase {
	
	 @DataProvider(name = "menuoptionTest")
		public static Object[][] loginData() throws Exception {
		
			ExcelUtils loginData = new ExcelUtils();
			Object[][] testObjArray = loginData.getTableArray(".\\src\\test\\java\\testUtils\\datasheet.xlsx", "DirectWithdrawal");
		

		System.out.println(testObjArray.length);
		return (testObjArray);
	}

	/**
	 * BeforeClass Method to create ExtentTest in Extent Report
	 */
	@BeforeClass
	public void setupBeforeClass() {
		extentTest = reporter.createTest("Verify all Menu Options Test", "Verify all Navigations of Menu Options");
	}

	/**
	 * Test the product search which not exists in inventory
	 * @throws Exception 
	 */
	@Test(dataProvider = "menuoptionTest")
	public void clickOnAllMenuOptions(String Username, String Password, String branchtransitno, String institutionidno, String AccNo, String voidcheque,
			String ProfileImagePath, String Firstname, String Middlename, String Lastname, String dob, String gender, String childemail) throws Exception {
		testNode = extentTest.createNode("Verify Login",
				"Test Case 02 Expected: results should be displayed for the respective pages");
		homePage = new homePage(page, testNode);
		softAssert.assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE);
		loginPage = homePage.navigateToLoginPage();
		loginPage.doLogin( Username, Password);
		accountMenuPages accountMenuPages = new accountMenuPages(page, extentTest);
		accountMenuPages.subcriptionsPage();
		accountMenuPages.directWithdrwalPage(branchtransitno, institutionidno, AccNo, voidcheque);
		accountMenuPages.paymentHistoryPage();
		accountMenuPages.donationsPage();
		accountMenuPages.taxReceiptPage();
		accountMenuPages.invoicesPage();
		accountMenuPages.applicationStatusPage();
		accountMenuPages.editProfilePage(ProfileImagePath);
		accountMenuPages.childrenPage(Firstname, Middlename, Lastname, dob, gender, childemail);
		
		/*accountMenuPages.navigations();
		accountMenuPages.clearFilterOptions();*/
		
	}

}
