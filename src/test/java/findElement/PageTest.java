package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageTest {

    @Test
    void withValidPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(string(),' My Account')]")).click();
        driver.findElement(By.xpath("//a[@href ='https://www.phptravels.net/login']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user@phptravels.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("demouser");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //driver.findElement(By.xpath("//a[@href ='https://www.phptravels.net/register']"));
    }
}
