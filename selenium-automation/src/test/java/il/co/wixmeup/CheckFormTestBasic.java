package il.co.wixmeup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;




/////////// Basic Test ////////////

//Exclude:
//Page object model
//Logger log4j2
//External parameter data from CSV

public class CheckFormTestBasic {

	
	@Test
	public void BasicTest() {
		
		System.out.println("Starting BasicTest() function");
		
		// Create chrome Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver3");
		
		WebDriver driver = new ChromeDriver();
		
		// Open test page
		String url = "https://www.wixmeup.co.il/test-automation";
		driver.get(url);
		
		// Maximize browser window
		driver.manage().window().maximize();
				
		System.out.println("Page is open");
		
		sleep(2000);
		
		// Verify that current URL and expected URL
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, expectedUrl,"Actual page Url is not the same as expected");
		
		// Defined element on page
		WebElement text1  = driver.findElement(By.xpath("//input[@id='comp-jv2bkkx0input']"));
		WebElement text2  = driver.findElement(By.xpath("//input[@id='comp-jv2bldt0input']"));
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='comp-jvf52vybcollection']")));
		WebElement calcButton  = driver.findElement(By.xpath("//span[@id='comp-jv2bmxzglabel']"));
		

		// Enter numbers to text1 and text2 and press on Calc button 
		text1.sendKeys("7");
		
		text2.sendKeys("7");

		dropdown.selectByVisibleText("PLUS");

		calcButton.click();
		
		
		sleep(2000);
		
		
		// Verify that current result number are equal to to expected result number
		WebElement resultstext  = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[8]/p[1]/span[1]/span[1]/span[1]"));
		String resultText = resultstext.getText();
		Assert.assertEquals("14", resultText, "Actual results text is not the same as expected");
	
		
		sleep(2000);
		
		
		//Close browser
		driver.close();
		
	}

	private void sleep(int number) {
		//sleep for 2 seconds
		try {
			Thread.sleep(number);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	
