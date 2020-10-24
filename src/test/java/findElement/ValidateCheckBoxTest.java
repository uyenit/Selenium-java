package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateCheckBoxTest {
    @Test
    void validateCheckBoxTest() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id ='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id ='checkboxes']/input[2]"));

        check(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());

        check(checkbox2);
        Assert.assertTrue(checkbox2.isSelected());

        driver.quit();
    }

    private void check(WebElement element) {
        if(!element.isSelected()){
            element.click();
        }
    }
}
