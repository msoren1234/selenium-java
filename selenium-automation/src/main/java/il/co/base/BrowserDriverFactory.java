package il.co.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;


public class BrowserDriverFactory {
	
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	private ExtentTest logHtml;
	
	public BrowserDriverFactory(String browser, Logger log, ExtentTest logHtml) {
		//this.browser = browser.toLowerCase();
		this.browser = browser;
		this.log = log;
		this.logHtml = logHtml;
	}
	
	// Set up a Chrome driver
	public WebDriver createDriver() {
		
		log.info("Check which browser to open");
		logHtml.info("Check which browser to open");
			
//		switch (browser) {
//			case "chrome":
//				 System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver3");
//				 driver.set(new ChromeDriver());
//				 break;
			
//			case 2:
//				 System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
//				 driver.set(new FirefoxDriver());
//				 break;

//		default:
			System.out.println("Do not know how to start " + browser + ",starting chrome as a default");
			 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver3");
			 driver.set( new ChromeDriver());
	//		break;
	//	}	
		
		
		return driver.get();
	}
	

	
	public WebDriver createChromeWithProfile(String profile) {
		
		log.info("Starting chrome driver with profile: " + profile);
		logHtml.info("Check which browser to open");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("user-data-dir=src/main/resources/Profiles/" + profile);
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver3");
		driver.set(new ChromeDriver(chromeOptions));
		
		return driver.get();
		
	}

}

