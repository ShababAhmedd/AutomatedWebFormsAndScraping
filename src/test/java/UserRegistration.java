import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRegistration {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit waiter
    }

    @Test
    public void fillupUserForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        List<WebElement> txtFields = driver.findElements(By.className("ur-frontend-field"));

        // First Name
        txtFields.get(0).sendKeys("Mashrur");

        // Last Name
        txtFields.get(3).sendKeys("Safir");

        // User Email
        txtFields.get(1).sendKeys("test@user.com");

//         User Password
        txtFields.get(2).sendKeys("@sDeT01059");
//
        // Gender
        txtFields.get(4).click();

        // Date of Birth
        WebElement dateField = driver.findElement(By.cssSelector("input[data-id='date_box_1665628538']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('readonly')", dateField);
        dateField.sendKeys("2025-04-19");


        // Nationality
        txtFields.get(10).sendKeys("Bangladeshi");

        // Phone
        txtFields.get(8).sendKeys("1234567890");

        // Country
        WebElement country = txtFields.get(11);
        Select options = new Select(country);
        options.selectByValue("BD");

        // Scrolling down to get view of terms and conditions and submit button
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        // Terms and Conditions
        txtFields.get(28).click();

        // submit
        List<WebElement> submit = driver.findElements(By.className("ur-submit-button"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.click(submit.get(0)).perform();

        // Assert
        String actualMessage = driver.findElement(By.id("ur-submit-message-node")).getText();
        String expectedMessage = "User successfully registered.";
        Assertions.assertTrue(actualMessage.equals(expectedMessage));
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
