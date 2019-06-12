package il.co.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
	protected WebDriver driver;
	protected Logger log;
	
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	
	//Reports
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest logHtml;
    

    

    @BeforeClass(alwaysRun = true)
	public void setup_BeforeClass(ITestContext ctx) {
		
		// HTML Reports
    	
    	this.testName = ctx.getCurrentXmlTest().getName();
    	this.testSuiteName = ctx.getSuite().getName();
    	
        htmlReporter = new ExtentHtmlReporter("./Reports/report_" + this.testSuiteName + ".html");
    
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        logHtml = extent.createTest(this.testName);
	}

	@Parameters({ "browser", "chromeProfile" })
	@BeforeMethod(alwaysRun = true)
	public void setup(Method method,@Optional("chrome") String browser,@Optional String profile) {
		
		//String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(this.testName);
		
		log.info("Open Driver");
		logHtml.info("Open Driver");

		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log, logHtml);
		if(profile != null) {
			driver = factory.createChromeWithProfile(profile);
		} else {
			driver = factory.createDriver();
		}

		
		
//		switch (browser) {
//		case 1:
//			 System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//			 driver = new ChromeDriver();
//			 break;
//		
//		case 2:
//			 System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
//			 driver = new FirefoxDriver();
//			 break;
//
//		default:
//			System.out.println("Do not know how to start " + browser + ",starting chrome as a default");
//			 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//			 driver = new ChromeDriver();
//			break;
//		}	
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.manage().window().maximize();
		
		//this.testSuiteName = ctx.getSuite().getName();
		//this.testName = testName;
		this.testMethodName = method.getName();
		
		
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Close driver");
	
		driver.quit();
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown_AfterClass() {
		
		//Reporting
		extent.flush();
	}
	
	

}

