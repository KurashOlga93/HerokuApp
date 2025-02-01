package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Hovers {

        @Test
        public void hover() {

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("http://the-internet.herokuapp.com/hovers");

            Actions action = new Actions(driver);
            SoftAssert softAssert = new SoftAssert();

            WebElement user1 = driver.findElement(By.xpath("//div[@class='example']//div[@class='figure'][1]"));

            action.moveToElement(user1).build().perform();

            String user1Text = driver.findElement(By.xpath("(//*[@id='content']//h5)[1]")).getText();

            Assert.assertEquals(user1Text, "name: user1");

            WebElement link = driver.findElement(By.linkText("View profile"));

            link.click();

            String elementText = driver.findElement(By.xpath("//h1[text()]")).getText();

            softAssert.assertNotEquals(elementText, "Not Found");

            driver.navigate().to("http://the-internet.herokuapp.com/hovers");

            WebElement user2 = driver.findElement(By.xpath("//div[@class='example']//div[@class='figure'][2]"));

            action.moveToElement(user2).build().perform();

            String user2Text = driver.findElement(By.xpath("(//*[@id='content']//h5)[2]")).getText();

            Assert.assertEquals(user2Text, "name: user2");

            WebElement link2 = driver.findElement(By.linkText("View profile"));

            link2.click();

            softAssert.assertNotEquals(elementText, "Not Found");

            driver.navigate().to("http://the-internet.herokuapp.com/hovers");

            WebElement user3 = driver.findElement(By.xpath("//div[@class='example']//div[@class='figure'][3]"));

            action.moveToElement(user3).build().perform();

            String user3Text = driver.findElement(By.xpath("(//*[@id='content']//h5)[3]")).getText();

            Assert.assertEquals(user3Text, "name: user3");

            WebElement link3 = driver.findElement(By.linkText("View profile"));

            link3.click();

            softAssert.assertNotEquals(elementText, "Not Found");

            softAssert.assertAll();

        }
}
