package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsAlerts {
    @Test
    void validatePopUpDisplay() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        element.click();

        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result,"You successfuly clicked an alert");

        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        elementConfirm.click();
        driver.switchTo().alert().accept();
        result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result,"You clicked: Ok");

        WebElement elementConfirmNo = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        elementConfirm.click();
        driver.switchTo().alert().dismiss();
        result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result,"You clicked: Cancel");

        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        elementConfirm.click();
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        result = driver.findElement(By.id("result")).getText().trim();
        Assert.assertEquals(result,"You entered: hello");


    }

    @Test
    void dragDrop(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions mouse = new Actions(driver);
        WebElement A = driver.findElement(By.id("column-a"));
        WebElement B = driver.findElement(By.id("column-b"));
        mouse.dragAndDrop(A,B).build().perform();
    }
}
