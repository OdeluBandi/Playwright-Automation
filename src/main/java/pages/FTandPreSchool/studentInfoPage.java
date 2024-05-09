package pages.FTandPreSchool;

import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLog;
import static utils.ExtentReporter.extentLogWithScreenshot;

import java.util.regex.Pattern;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.LocatorOptions;
import com.microsoft.playwright.options.SelectOption;

public class studentInfoPage {
	
	
	private Page page;
	private ExtentTest extentTest;
	private String selectChild = "//select[@formcontrolname='selectedChild']";
	private String addChildbutton = "//*[@data-testid='add_new_child']";
	private String studentFormheader = "//span[text()='Complete the section below and click Next']";
	private String alertErrorSelector = "//*[@class='alertify-notifier ajs-top ajs-right']";
	private String selectLegal = "//select[@formcontrolname='legalStatus']";
	private String selectAboriginal = "//input[@value='First Nations (status)']"; // need to implement more scenarios here
	private String selectNRStatus = "//select[@data-testid='new_returning']";
	private String selectLevel = "(//div[@class='form-group col-12']/select)[3]";
	private String addEthnicity = "//input[@formcontrolname='ethnicity']";
	private String addOEN = "//input[@formcontrolname='stateStudentNumber']";
	private String currentSchool = "//input[@formcontrolname='currentSchoolName']";
	private String currentGrade = "//select[@formcontrolname='currentSchoolGrade']";
	private String spokenLanguage = "//select[@formcontrolname='languageSpoken']";
	private String nextbutton = "(//button[@data-testid='Next'])[2]";
	

	/**
     * Constructor to initialize the page objects with the {@link Page} instance and
     * {@link ExtentTest} instance
     * 
     * @param page       - {@link Page}
     * @param extentTest - {@link ExtentTest}
     */
	
	public studentInfoPage (Page page, ExtentTest extentTest) {
		this.page = page;
        this.extentTest = extentTest;
		}
	
	
		public boolean selectChild (String child, String schoolName1 ) throws Exception {
			Thread.sleep(2000);
			page.locator(selectChild).click();
			page.locator(selectChild).selectOption(child);
			
			
			Thread.sleep(1000);
			
			if (page.locator(studentFormheader).isVisible()) {
				extentLog(extentTest, Status.INFO, "Selected child not Registered to Selected School.");
	            return true;
	        }
	        boolean isErrorDisplayed = page.textContent(alertErrorSelector)
	                .contains("The child "+child+" is already registered for "+schoolName1+"");
	        	extentLog(extentTest, Status.INFO, "Selected child already Registered to Selected School.");
	        return !isErrorDisplayed;
			
		}

		public void addChildbutton() throws Exception {
			
			page.click(addChildbutton);
			
		}
		
		public void studentInformation(String legalStatus, String nrstatus, String level, String ethnicity, String OEN,
					String currentschool, String currentgrade, String language) throws Exception {
			
			Thread.sleep(1000);
			page.locator(selectLegal).scrollIntoViewIfNeeded();
			page.locator(selectLegal).selectOption(legalStatus);
			Thread.sleep(1000);
			page.locator(selectAboriginal).click(new Locator.ClickOptions().setForce(true));
			Thread.sleep(1000);
			page.locator(selectNRStatus).scrollIntoViewIfNeeded();
			page.locator(selectNRStatus).selectOption(new SelectOption().setValue(nrstatus));
			Thread.sleep(1000);
			page.selectOption(selectLevel, new SelectOption().setLabel(level));
			Thread.sleep(1000);
			page.locator(addEthnicity).fill(ethnicity);
			Thread.sleep(1000);
			page.locator(addOEN).fill(OEN);
			Thread.sleep(1000);
			page.locator(currentSchool).fill(currentschool);
			Thread.sleep(1000);
			page.locator(currentGrade).scrollIntoViewIfNeeded();
			Locator currentgradeselector = page.locator(currentGrade);
			currentgradeselector.selectOption(new SelectOption().setValue(currentgrade));
			Thread.sleep(1000);
			page.locator(spokenLanguage).scrollIntoViewIfNeeded();
			page.locator(spokenLanguage).selectOption(language);
			Thread.sleep(1000);
			page.click(nextbutton);
			extentLog(extentTest, Status.INFO, "Student information added successfully.");
		
			
		}
		
	
		

}
