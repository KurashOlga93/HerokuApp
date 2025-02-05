package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

    @Test
    public void checkboxes() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement firstCheckbox = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));
        Assert.assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());
        WebElement secondCheckbox = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
        Assert.assertTrue(secondCheckbox.isSelected());
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected());
    }
}