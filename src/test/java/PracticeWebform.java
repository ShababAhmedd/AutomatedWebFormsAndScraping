import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PracticeWebform {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit waiter
    }

    @Test
    public void fillupUserForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");

        //accepting cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        List<WebElement> txtFields = driver.findElements(By.tagName("input"));

        // Name
        txtFields.get(0).sendKeys("Mashrur Safir");

        // Number
        txtFields.get(1).sendKeys("01234567891");   // Number

        // Today's date
        txtFields.get(2).sendKeys("19");
        txtFields.get(2).sendKeys("04");
        txtFields.get(2).sendKeys("25");

        // Email
        txtFields.get(3).sendKeys("mashrur.safir.shabab@g.bracu.ac.bd");

        // Tell us a bit about yourself
        WebElement aboutYourself = driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-"));
        aboutYourself.sendKeys("This is a test message");

        // Scrolling down to get view of upload and tickbox.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        // Uploading a txt file
        txtFields.get(4).sendKeys("/home/safir/Desktop/test.docx");
        // waiting for the file to get uploaded
        Thread.sleep(2000);

        // clicking the tick box
        txtFields.get(7).click();

        // submit
        txtFields.get(11).click();

        // Assert
        String actualMessage = driver.findElement(By.tagName("h1")).getText();
        String expectedMessage = "Thank you for your submission!";
        Assertions.assertTrue(actualMessage.equals(expectedMessage));
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
