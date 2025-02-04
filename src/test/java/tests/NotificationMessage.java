package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationMessage {

    @Test
    public void notificationMessage() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        WebElement link = driver.findElement(By.linkText("Click here"));
        link.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String elementText = driver.findElement(By.xpath("//*[@id='flash']")).getText();
        Assert.assertEquals(elementText.split("\n")[0],
                "Action successful", "Actual text not equal to expected text.");
    }
}