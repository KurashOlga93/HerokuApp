package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {

    @Test
    public void dropdown() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElements = driver.findElement(By.id("dropdown"));

        Select dropdown = new Select(dropdownElements);

        List<WebElement> options = dropdown.getOptions();

        int actual = options.size();

        Assert.assertEquals(actual, 3);

        dropdown.selectByValue("1");

        WebElement firstOption = dropdown.getFirstSelectedOption();

        Assert.assertEquals(firstOption.getText(), "Option 1");

        dropdown.selectByValue("2");

        WebElement secondOption = dropdown.getFirstSelectedOption();

        Assert.assertEquals(secondOption.getText(), "Option 2");

    }
}
