package findElement;

import TestCase.BaseTest;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BMIPage;

public class BMITest extends BaseTest {


    @Test(description = "")
    public void calculator() {
        BMIPage bmi = new BMIPage();
        bmi.open();
        bmi.selectMetricTab();
        bmi.fillForm("25","male","180","65");

        Assert.assertEquals(bmi.getResult(),"BMI = 20.1 kg/m2   (Normal)");
    }

    @Test(description = "")
    public void should_be_obese_category() {
        BMIPage bmi = new BMIPage();
        bmi.open();
        bmi.selectMetricTab();
        bmi.fillForm("25","male","180","65");
        Assert.assertEquals(bmi.getResult(),"BMI = 20.1 kg/m2   (Normal)");
    }


}
