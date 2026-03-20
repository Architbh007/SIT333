package task4_2c;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.*;
import java.time.Duration;

public class BunningsLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // The URL of the Bunnings login page for testing
    private static final String LOGIN_URL = "https://www.bunnings.com.au/login";

    //real credentials for the Bunnings account I created for testing
    private static final String VALID_EMAIL    = "bhullararchit07@gmail.com";
    private static final String VALID_PASSWORD = "*******";

    // These are the wrong/fake credentials to test failed login scenarios
    private static final String INVALID_EMAIL  = "notanemail";         // not a real email format
    private static final String UNREG_EMAIL    = "example@goggle.com"; //not registered email
    private static final String WRONG_PASSWORD = "1234567";      // wrong password for the real account

    //locators found by inspecting the Bunnings login page
    private static final By EMAIL_FIELD    = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By SUBMIT_BUTTON  = By.id("login-submit");

    //This opens a fresh Chrome browser
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //gives Selenium up to 10 seconds to find elements before giving up
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    //This closes the browser so we start fresh next time
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // reusable helper method so we don't repeat the same login steps in every test.
    // It opens the login page, fills in the email and password, and clicks the submit button.
    private void attemptLogin(String email, String password) throws InterruptedException {
        driver.get(LOGIN_URL);

        // Wait until the email field actually appears on the page
        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD)
        );

        if (!email.isEmpty()) {
            emailField.clear();
            emailField.sendKeys(email);
        }

        WebElement passwordField = driver.findElement(PASSWORD_FIELD);

        if (!password.isEmpty()) {
            passwordField.clear();
            passwordField.sendKeys(password);
        }

        // Click the Sign In button
        driver.findElement(SUBMIT_BUTTON).click();

        // Wait 3 seconds for the page to respond after clicking submit
        Thread.sleep(3000);
    }

    // How we decide if a test passes or fails 
    // After submitting the form we check the current URL:
    //   - If login FAILED - Bunnings keeps us on the /login page - URL still contains "login"
    //   - If login PASSED - Bunnings redirects us away - URL no longer contains "login"

    // T1 - Both email and password fields are left completely empty
    @Test
    public void BothFieldsEmpty() throws InterruptedException {
        attemptLogin("", "");
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page when both fields are empty",
            currentUrl.contains("login"));
    }

    // T2 - Email is left empty but a wrong password is typed in
    @Test
    public void EmailEmpty_WrongPassword() throws InterruptedException {
        attemptLogin("", WRONG_PASSWORD);
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page when email is empty",
            currentUrl.contains("login"));
    }

    // T3 - Email is left empty but the correct password is typed in
    @Test
    public void EmailEmpty_CorrectPassword() throws InterruptedException {
        attemptLogin("", VALID_PASSWORD);
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page when email is empty",
            currentUrl.contains("login"));
    }

    // T4 - An invalid email format (no @ symbol) is entered and password is left empty
    @Test
    public void InvalidEmail_PasswordEmpty() throws InterruptedException {
        attemptLogin(INVALID_EMAIL, "");
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page for invalid email format",
            currentUrl.contains("login"));
    }

    // T5 - An invalid email format is entered along with a wrong password
    @Test
    public void InvalidEmail_WrongPassword() throws InterruptedException {
        attemptLogin(INVALID_EMAIL, WRONG_PASSWORD);
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page for invalid email and wrong password",
            currentUrl.contains("login"));
    }

    // T6 - A correctly formatted email is used but it has never been registered on Bunnings
    @Test
    public void UnregisteredEmail_CorrectPassword() throws InterruptedException {
        attemptLogin(UNREG_EMAIL, VALID_PASSWORD);
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page for unregistered email",
            currentUrl.contains("login"));
    }

    // T7 - The real registered email is entered but the password field is left empty
    @Test
    public void CorrectEmail_PasswordEmpty() throws InterruptedException {
        attemptLogin(VALID_EMAIL, "");
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page when password is empty",
            currentUrl.contains("login"));
    }

    // T8 - The real registered email is entered but with the wrong password
    @Test
    public void CorrectEmail_WrongPassword() throws InterruptedException {
        attemptLogin(VALID_EMAIL, WRONG_PASSWORD);
        String currentUrl = driver.getCurrentUrl();
        assertTrue("FAILED: Should stay on login page for correct email but wrong password",
            currentUrl.contains("login"));
    }

    // T9 - Both the correct email and correct password are entered
    @Test
    public void CorrectEmail_CorrectPassword_LoginSuccess() throws InterruptedException {
        attemptLogin(VALID_EMAIL, VALID_PASSWORD);
        String currentUrl = driver.getCurrentUrl();
        assertFalse("FAILED: Should redirect away from login page on successful login",
            currentUrl.contains("login"));
    }

    //Below tests simply check that the student name and ID are not empty strings
    @Test
    public void testStudentName() {
        String studentName = "Archit Bhullar";
        assertNotNull("Student name should not be null", studentName);
        assertFalse("Student name should not be empty", studentName.isEmpty());
    }

    @Test
    public void testStudentId() {
        String studentId = "s224094385";
        assertNotNull("Student ID should not be null", studentId);
        assertTrue("Student ID should start with 's'", studentId.startsWith("s"));
    }
}