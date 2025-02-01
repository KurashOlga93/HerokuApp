package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HerokuAppTest {

    @Test
    public void herokuAppTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768 ));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        inputField.sendKeys("20");
        String actualText = inputField.getAttribute("value");
        Assert.assertEquals(actualText,"20");

        inputField.sendKeys(Keys.ARROW_UP);
        String actualText1 = inputField.getAttribute("value");
        Assert.assertEquals(actualText1,"21");

        /*
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("id"));

        WebElement myElement = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("id"))));

        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(360,640));
        driver.manage().window().setPosition(new Point(100,100));
        Point position = driver.manage().window().getPosition();
        int x = position.getX();
        int y = position.getY();
        driver.navigate().to("http://the-internet.herokuapp.com/inputs");

Cookie cookie = new Cookie("key", "value");
        driver.manage().addCookie(cookie);

        driver.manage().getCookieNamed("name");

        Set<Cookie> allCookies = driver.manage().getCookies();

        String handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        WebElement myElement1 = driver.findElement(By.name("name"));
        driver.switchTo().frame(myElement1);

        driver.getCurrentUrl();
        driver.getPageSource();

        driver.findElement(By.id("id"));
        driver.findElements(By.id("id1"));

        Select dropdown = new Select(driver.findElement(By.id("\"dropdown\"")));
        dropdown.selectByValue("Olga");
*/
    }
}
