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
 * This class demonstrates __Selenium__ locator APIs to identify HTML elements.
 *
 * Details in __Selenium__ documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 *
 * @author __Ahsan__ __Habib__
 */
public class github {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void officeworks_registration_page(String url) {
		// Step 1: Locate __chrome__ driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");

		// Step 2: Use above __chrome__ driver to open up a __chromium__ browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a __webpage__ in __chromium__ browser.
		driver.get(url);

		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the __webpage__,
		 * Step 2: locate the input field,
		 * Step 3: Find out how to identify it, by id/name/...
		 */

		// Find first input field which is __email__
		WebElement element = driver.findElement(By.id("email"));
		System.out.println("Found element: " + element);
		// Send email
		element.sendKeys("architbhullar@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		password.sendKeys("archit123");   

		WebElement login = driver.findElement(By.id("login"));
		System.out.println("Found element: " + login);
		login.sendKeys("archit");

		sleep(2);
		/*
		 * Identify button 'Create account' and click to submit using __Selenium__ API.
		 */
		WebElement createAccountButton = driver.findElement(
				By.xpath("//button[@type='submit']"));
		System.out.println("Found element: " + createAccountButton);
		createAccountButton.click();
		sleep(3);

		/*
		 * Take screenshot using __selenium__ API.
		 */
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("github_failed_registration.png");

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

		// close __chrome__ driver
		driver.close();
	}


}