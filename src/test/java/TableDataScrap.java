import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TableDataScrap {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit waiter
    }

    @Test
    public void scrapData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        WebElement table = driver.findElement(By.className("inner-scroll"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("DSE.txt"));
        int i = 0;
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            StringBuilder rowText = new StringBuilder();
            for(WebElement cell : cells) {
                i++;
                rowText.append(cell.getText()).append(" ");
                System.out.println("num["+i+"] " + cell.getText());
            }
            writer.write(rowText.toString());
            writer.newLine();   // adds a line break after each row
        }
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
