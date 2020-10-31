package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuTest {
    @Test
    void rightClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions mouse = new Actions(driver);
        WebElement squareBox = driver.findElement(By.id("hot-spot"));
        mouse.contextClick(squareBox).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    void keyPresses() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions keyboard = new Actions(driver);
        //keyboard.sendKeys("A").build().perform();
        keyboard.sendKeys(Keys.ARROW_DOWN).perform();

    }
}
