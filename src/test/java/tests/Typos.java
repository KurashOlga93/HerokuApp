package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Typos {

    @Test
    public void typos() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");

        WebElement paragraph = driver.findElement(By.xpath("//*/p[2]"));

        String expectedText = "Sometimes you'll see a typo, other times you won't.";
        String actual = paragraph.getText();

        Assert.assertEquals(actual, expectedText, "Actual text contains an error.");

    }
}
