package lesson20;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    @Test
    public void checkIframeText() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/frames");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.linkText("iFrame")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='tox-icon']"))).click();
        driver.switchTo().frame("mce_0_ifr");
        String actualText = driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText();
        Assert.assertEquals(actualText, "Your content goes here.");
    }
}