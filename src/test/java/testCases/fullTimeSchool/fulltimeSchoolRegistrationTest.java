package testCases.fullTimeSchool;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.accountMenuPages;
import pages.homePage;
import pages.selectingSchool;
import pages.FTandPreSchool.documentsFinancePage;
import pages.FTandPreSchool.emergencyContactPage;
import pages.FTandPreSchool.medicalInfoPage;
import pages.FTandPreSchool.parentInfoPage;
import pages.FTandPreSchool.studentInfoPage;
import pages.paymentOptions.paymentOptions;
import testUtils.ExcelUtils;
import tests.testBase;

public class fulltimeSchoolRegistrationTest extends testBase {
	
		@DataProvider(name = "registrationsTest")
		public static Object[][] fulltimetest() throws Exception {
	
				ExcelUtils fulltimetest = new ExcelUtils();
					Object[][] testObjArray = fulltimetest.getTableArray(".\\src\\test\\java\\testUtils\\datasheet.xlsx", "FT-R-Registration");
	
						System.out.println(testObjArray.length);
						return (testObjArray);
		}
		@BeforeClass
		public void setupBeforeClass() {
			extentTest = reporter.createTest("Verify Full Time School Registration Test");
		}

		
		/**
		 * Test the product search which not exists in inventory
		 * @throws Exception 
		 */
		@Test(dataProvider = "registrationsTest")
		public void clickOnAllMenuOptions(String schoolName, String Username, String Password, String usergender, String Street, String Appartment, 
											String City, String Province, String Postalcode, String usercellphone, String spouseFirstName, 
											String spouseLastname, String spouseCellPhone, String spouseEmail, String Firstname, String Middlename, 
											String Lastname, String dob, String gender, String childemail, String legalStatus, 
											String nrstatus, String level, String ethnicity, String OEN, String currentschool, String currentgrade, 
											String language, String emerconatctfirstname, String emercontactlastname, String emerphonetype, 
											String emerphonenumber, String emerrelationship, String authorizefirstname, String authorizelastname, 
											String authorizephonetype, String autorizephonenumber, String birthcertificate, 
											String healthcard, String custodydocument, String previousreportcard, String immunizationrecord, 
											String financesignature, String parentalSingature, String comments, String cardName, String cardNumber, 
											String monthYear, String cvc, String zip) throws Exception {
			
			testNode = extentTest.createNode("Verify FullTime Registration Test",
					"Test Case 03 Expected: results should be displayed for the respective pages");
			homePage = new homePage(page, testNode);
			softAssert.assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE);
			selectingSchool selectSchoolProgram = new selectingSchool(page, extentTest);
			selectSchoolProgram.selectProgram(schoolName);
			
			pages.loginPage loginPage = new pages.loginPage(page, extentTest);
			loginPage.applyLogin( Username, Password);
			
			parentInfoPage parentInfoPage =  new parentInfoPage(page, extentTest);
			parentInfoPage.genderCheck(usergender, Street, Appartment, City, Province, Postalcode, usercellphone, spouseFirstName, spouseLastname, 
												spouseCellPhone, spouseEmail);
			
			studentInfoPage studentInfoPage = new studentInfoPage(page, extentTest);
			studentInfoPage.addChildbutton();
			//navigating to addchildren pages
			accountMenuPages accountMenuPages = new accountMenuPages(page, extentTest);
			accountMenuPages.childrenPage(Firstname, Middlename, Lastname, dob, gender, childemail);
			//after adding child redicting to student info page
			studentInfoPage.studentInformation(legalStatus, nrstatus, level, ethnicity, OEN, currentschool, currentgrade, language);
			
			emergencyContactPage emergencyContact = new emergencyContactPage(page, extentTest);
			emergencyContact.emergencyContactDetails(emerconatctfirstname,  emercontactlastname,  emerphonetype,  emerphonenumber, 
					 emerrelationship,  authorizefirstname,  authorizelastname,  authorizephonetype, 
						 autorizephonenumber);
			
			medicalInfoPage medicaldetails = new medicalInfoPage (page, extentTest);
			medicaldetails.mediaclDetails();
			
			documentsFinancePage documnetsfinance = new documentsFinancePage (page, extentTest);
			documnetsfinance.documentsAndFinanceDetails(birthcertificate,  healthcard, custodydocument, 
					 previousreportcard,  immunizationrecord);
			
			documnetsfinance.agreements(financesignature, parentalSingature, comments);
			
			paymentOptions paymentoptions = new paymentOptions(page, extentTest);
			paymentoptions.payInFull(cardName, cardNumber, monthYear, cvc, zip);
			paymentoptions.payButton();
			
			
			
		
			
			
		}
}
