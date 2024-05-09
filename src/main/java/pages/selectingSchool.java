package pages;

import static base.PlaywrightFactory.takeScreenshot;
import static utils.ExtentReporter.extentLog;
import static utils.ExtentReporter.extentLogWithScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;


public class selectingSchool {
	
	 private Page page;
	 private ExtentTest extentTest;
	 private String applyButton = "//a[text() = 'Apply']";
	 
	 
	 public selectingSchool(Page page, ExtentTest extentTest) {
	        this.page = page;
	        this.extentTest = extentTest;
	    }
	    
	 public void selectProgram(String schoolName) throws Exception {
		 	Thread.sleep(3000);
		 	ElementHandle hrefElement = page.querySelector("//*[text()='"+schoolName+"']");
		 	hrefElement.click();
		 	page.waitForSelector(applyButton);
		 	Thread.sleep(2000);
		 	page.click(applyButton);
		 	Thread.sleep(2000);
		 	extentLog(extentTest, Status.INFO, "Navigated Login Page.");
		 	//extentLogWithScreenshot(extentTest, Status.INFO, "Navigated Login Page.", takeScreenshot(page));
	 }
}
