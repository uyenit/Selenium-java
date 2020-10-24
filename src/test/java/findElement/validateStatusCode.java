package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateStatusCode {
    @Test
    void hyperLinkTest() {
        WebDriver driver = new ChromeDriver();
        String baseUrl ="https://the-internet.herokuapp.com/status_codes";
        driver.get(baseUrl);

        //driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"/200");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"/500");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"/301");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl+"/404");
        //driver.findElement(By.linkText("here")).click();

        driver.navigate().back();
        driver.quit();

    }
}
