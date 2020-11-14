package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class ValidateCheckBoxTest {
    @Test
    void validateCheckBoxTest() {
        WebDriver driver = new ChromeDriver();
        CheckboxPage checkboxpage = new CheckboxPage(driver);
        checkboxpage.open();



        checkboxpage.checkOn("1");
        Assert.assertTrue(checkboxpage.getCheckbox("1").isSelected());
        checkboxpage.checkOn("2");
        Assert.assertTrue(checkboxpage.getCheckbox("2").isSelected());

        driver.quit();
    }

}
