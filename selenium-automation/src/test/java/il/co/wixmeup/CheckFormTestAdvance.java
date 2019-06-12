package il.co.wixmeup;



import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import il.co.TestNG_retry.Retry;
import il.co.base.TestUtilities;
import il.co.pages.WixFormPage;



/////////// Basic Test ////////////

// Include:
// Page object model
// Logger log4j2

// Exclude:
// External parameter data from CSV


public class CheckFormTestAdvance extends TestUtilities {


	//@Test
	@Test(retryAnalyzer = Retry.class)
	public void BasicTest() {
		
		
//		// start reporters
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/report_extent.html");
//    
//        // create ExtentReports and attach reporter(s)
//        ExtentReports extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        // creates a toggle for the given test, adds all log events under it    
//        ExtentTest test = extent.createTest("BasicTest");
        
		try {   
			
			log.info("Starting TestActions");
			logHtml.info("Starting TestActions");

			
			WixFormPage wixFormPage = new WixFormPage(driver, log);
	
			// open main page
			wixFormPage.openPage();
			
			//log.info("Check MINUS action");
			
			//Check MINUS action
			wixFormPage.typeNumber1("7")
						.typeNumber2("3")
						.dropDownAction("MINUS")
						.pushCalcButton();
	
	
			Sleep(1000);
			
			// Verifications
			wixFormPage.waitForRestuls()
						.VerifyTextElement("4", wixFormPage.restuls());
			
	    
			
		}
		catch (Exception exp)
		{			
			//log.info("Test Failed: " + exp.getMessage());
			logHtml.log(Status.FAIL,exp.getMessage());
			takeScreenshot("Exception CheckFormTestAdvance");

		}
		catch (AssertionError asr)
		{
			//log.info("Test Assertion Failed: "+ asr.getMessage());
			logHtml.log(Status.FAIL,asr.getMessage());
			takeScreenshot("Exception CheckFormTestAdvance");
		}
		
		
	}
	
	
	//@Test
	@Test(retryAnalyzer = Retry.class)
	public void BasicTest2() {
		
        
		try {   
			
			log.info("Starting TestActions");
			
			
			WixFormPage wixFormPage = new WixFormPage(driver, log);
	
			// open main page
			wixFormPage.openPage();
			
			//log.info("Check MINUS action");
			
			//Check MINUS action
			wixFormPage.typeNumber1("7")
						.typeNumber2("3")
						.dropDownAction("PLUS")
						.pushCalcButton();
	
	
			Sleep(1000);
			
			// Verifications
			wixFormPage.waitForRestuls()
						.VerifyTextElement("10", wixFormPage.restuls());
			
	    
			
		}
		catch (Exception exp)
		{			
			//log.info("Test Failed: " + exp.getMessage());
			logHtml.log(Status.FAIL,exp.getMessage());
			takeScreenshot("Exception CheckFormTestAdvance");

		}
		catch (AssertionError asr)
		{
			//log.info("Test Assertion Failed: "+ asr.getMessage());
			logHtml.log(Status.FAIL,asr.getMessage());
			takeScreenshot("Exception CheckFormTestAdvance");
		}
		
		
	}
	
	

}
