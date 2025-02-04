package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTables {

    @Test
    public void cellCheck(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        String lastNameCell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[1]")).getText();
        Assert.assertEquals(lastNameCell, "Smith");
        String emailCell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[3]")).getText();
        Assert.assertEquals(emailCell, "jsmith@gmail.com");
        String dueCell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[4]")).getText();
        Assert.assertEquals(dueCell, "$50.00");
        String webSiteCell = driver.findElement(By.xpath("//table[@id='table1']//tr[4]/td[5]")).getText();
        Assert.assertEquals(webSiteCell, "http://www.timconway.com");
    }
}