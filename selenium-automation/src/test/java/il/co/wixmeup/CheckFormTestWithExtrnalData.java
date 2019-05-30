package il.co.wixmeup;

import java.util.Map;

import org.testng.annotations.Test;

import il.co.base.CsvDataProviders;
import il.co.base.TestUtilities;
import il.co.pages.WixFormPage;



/////////// Basic Test ////////////

// Include:
// Page object model
// Logger log4j2
// External parameter data from CSV



public class CheckFormTestWithExtrnalData extends TestUtilities {


	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void CheckFormTestWithExtrnalData(Map<String,String> testData) {

		log.info("Starting CheckFormTestWithExtrnalData()");
		
		
		//Extract Data from External file
		
		String no = testData.get("no");
		String num1 = testData.get("num1");
		String num2 = testData.get("num2");
		String result = testData.get("result");
		String action = testData.get("action");
				
		log.info("Starting CheckFormTestWithExtrnalData() #" + no +"| Parameters: Num1:" + num1 + " Num2:" + num2 + " action:" + action);
				
		
		WixFormPage wixFormPage = new WixFormPage(driver, log);

		// open main page
		wixFormPage.openPage();
		
		
		//Check calculator action
		wixFormPage.typeNumber1(num1)
					.typeNumber2(num2)
					.dropDownAction(action)
					.pushCalcButton();


		Sleep(1000);
		
		// Verifications
		wixFormPage.waitForRestuls()
					.VerifyTextElement(result, wixFormPage.restuls());
	
	}

}
