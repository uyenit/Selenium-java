package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HoverTest {
    @Test
    void validateHoverTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions mouse = new Actions(driver);
        mouse.moveToElement(driver.findElement(By.xpath("//div[@class=\"figure\"][1]"))).perform();

        Assert.assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
        String avatarCaption = driver.findElement(By.xpath("//*[@class='figcaption']/h5")).getText();
        Assert.assertEquals(avatarCaption,"name: user1");
    }
}
