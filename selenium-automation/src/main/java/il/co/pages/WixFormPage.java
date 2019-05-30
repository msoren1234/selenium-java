package il.co.pages;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WixFormPage extends BasePageObject {

	private String pageURL = "https://www.wixmeup.co.il/test-automation";

	private By calcButton_Test1 = By.xpath("//span[@id='comp-jv2bmxzglabel']");
	private By clearButton_Test1 = By.xpath("//div[@id='comp-jvf8omi6link']");
	private By errorMsg_Test1 = By.xpath("//div[@id='comp-jv2c83bl']/p/span/span/span");
	private By number1__Test1 = By.xpath("//input[@id='comp-jv2bkkx0input']");
	private By number2_Test1 = By.xpath("//input[@id='comp-jv2bldt0input']");
	private By reuslt_Test1 = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[8]/p[1]/span[1]/span[1]/span[1]");
	
	private By dropDown_Test1 = By.xpath("//select[@id='comp-jvf52vybcollection']");
	
	
	public WixFormPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {
		log.info("Openning page: " + pageURL);
		openUrl(pageURL);
		log.info("Page opened!");
	}
	
//	/** Execute log in */
//	public void logIn_test1(String number1, String number2) {
//		//Log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
//		type(number1, number1__Test1);
//		type(number2, number2_Test1);
//		//click(calcButton_Test1);
//	}
	
	/** Execute log in */
	public WixFormPage typeNumber1(String number) {
		type(number, number1__Test1);
		return this;
	}
	
	public WixFormPage typeNumber2(String number) {
		type(number, number2_Test1);
		return this;
	}
	
//	
	/** Push Calc button */
	public WixFormPage pushCalcButton() {
		log.info("Clicking on calc button");
		click(calcButton_Test1);
		return this;
	}
	
	/** Push Calc button */
	public WixFormPage pushClearButton() {
		log.info("Clicking on calc button");
		click(clearButton_Test1);
		return this;
	}

	/** return Upload button */
	public WebElement errorMsgObject() {
		log.info("Return errorMsg element");
		return find(errorMsg_Test1);
	}
	
	
	/** return Upload button */
	public WebElement restuls() {
		log.info("Return result element");
		return find(reuslt_Test1);
	}
	
	/** return Upload button */
	public WebElement num1Value() {
		log.info("Return result element");
		return find(number1__Test1);
	}
	
	/** return Upload button */
	public WebElement num2Value() {
		log.info("Return result element");
		return find(number2_Test1);
	}
	
	public WixFormPage waitForRestuls() {
		waitForVisibilityOf(reuslt_Test1, 4);
		return this;
	}
	
	public WixFormPage waitForErrorMsg() {
		waitForVisibilityOf(errorMsg_Test1, 4);
		return this;
	}
	
	public WixFormPage dropDownAction(String action) {
		select(action,dropDown_Test1);
		return this;
	}
	
	public WixFormPage clearAllFeilds(String action) {
		select(action,dropDown_Test1);
		return this;
	}
	


	
	
	//WebDriverWait wait = new WebDriverWait(driver, 10);

//	/** return Upload button */
//	public boolean waitForStale(WebElement element) {
//		return Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(element)), "ErrorMsg is still visible, but shouldn't be ");
//	}
	

	


}

