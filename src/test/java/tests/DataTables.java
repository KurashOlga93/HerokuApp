package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTables {

    @Test
    public void dataTables(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        String lastNameSell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[1]")).getText();

        Assert.assertEquals(lastNameSell, "Smith");

        String emailSell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[3]")).getText();

        Assert.assertEquals(emailSell, "jsmith@gmail.com");

        String dueSell = driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[4]")).getText();

        Assert.assertEquals(dueSell, "$50.00");

        String webSiteSell = driver.findElement(By.xpath("//table[@id='table1']//tr[4]/td[5]")).getText();

        Assert.assertEquals(webSiteSell, "http://www.timconway.com");

    }
}
