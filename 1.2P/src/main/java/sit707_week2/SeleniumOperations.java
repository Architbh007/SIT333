package sit707_week2;

import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
   public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Archit");
		
		WebElement lastname = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastname);
		lastname.sendKeys("Bhullar");

		WebElement phone = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phone);
		phone.sendKeys("0401029837");

		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		email.sendKeys("architbhullar@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		password.sendKeys("archit123");   // intentionally invalid so no acc will be ceated

		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPassword);
		confirmPassword.sendKeys("archit123");
		
		sleep(2);
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement createAccountButton = driver.findElement(
				By.xpath("//button[contains(text(),'Create account')]"));
		createAccountButton.click();
		sleep(3);
		
		/*
		 * Take screenshot using selenium API.
		 */
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("officeworks_failed_registration.png");

		//confirmation 
		try {
		    java.nio.file.Files.copy(
		        screenshot.toPath(),
		        destination.toPath(),
		        java.nio.file.StandardCopyOption.REPLACE_EXISTING
		    );
		    System.out.println("Screenshot saved: " + destination.getAbsolutePath());
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
