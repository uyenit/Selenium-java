package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicLoadingPage {
    @Test
    void loginPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        String finish = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("finish")))).findElement(By.tagName("h4")).getText().trim();

        Assert.assertEquals(finish,"Hello World!");

        String finished = driver.findElement(By.xpath("//*[@id='finish']/h4")).getText().trim();
        Assert.assertEquals(finished,"Hello World!");
    }
}
