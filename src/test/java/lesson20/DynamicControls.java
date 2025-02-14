package lesson20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class DynamicControls {

    @Test
    public void removeCheckboxTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement removeButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        removeButton.click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        List<WebElement> checkboxes = driver.findElements(By.id("checkbox"));
        boolean checkBoxDoesNotExist = checkboxes.isEmpty();
        Assert.assertTrue(checkBoxDoesNotExist);
    }

    @Test
    public void inputIsEnabledTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SoftAssert softAssert = new SoftAssert();

        boolean isInputEnabled = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        softAssert.assertFalse(isInputEnabled);
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        boolean isInputEnabledAfterClick = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        softAssert.assertTrue(isInputEnabledAfterClick);
        softAssert.assertAll();
    }
}