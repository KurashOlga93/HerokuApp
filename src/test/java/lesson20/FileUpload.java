package lesson20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload {

    public static final String PATH_TO_THE_FILE = System.getProperty("user.dir") + "/src/test/resources/фото.jpg";

        @Test
        public void fileNameTest() {

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("http://the-internet.herokuapp.com/upload");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            driver.findElement(By.id("file-upload")).sendKeys(PATH_TO_THE_FILE);
            WebElement uploadButton = driver.findElement(By.id("file-submit"));
            uploadButton.click();
            wait.until(ExpectedConditions.textToBe(By.xpath("//h3"), "File Uploaded!"));
            String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
            Assert.assertEquals(actualFileName, "фото.jpg");
    }
}
