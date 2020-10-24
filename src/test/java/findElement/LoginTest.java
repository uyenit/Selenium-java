package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    void withValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        //driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//label[text()='Username']/following-sibling::input")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//label[text()='Username']/../input")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//label[text()='Username']/../../..//input[@id='password']")).sendKeys("SuperSecretPassword!");
        //driver.findElement(By.xpath("//*[@type='submit']")).click();
        //driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        //driver.findElement(By.xpath("//i[contains(.,'Login')]")).click();
        driver.findElement(By.xpath("//button//*[contains(.,'Login')]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://the-internet.herokuapp.com/secure",
                "Login password successfully");
        driver.quit();
    }
}
