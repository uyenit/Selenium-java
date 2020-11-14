package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BMIPage extends BasePage{
    public BMIPage() {

        PageFactory.initElements(Browser.getDriver(),this);
    }
    
    @FindBy(xpath = "//a[contains(text(),'Metric Units')]")
    WebElement metricTab ;

    @FindBy(id ="cage")
    WebElement ageTxt ;

    @FindBy(id = "csex1")
    WebElement maleRad ;

    @FindBy(id = "csex2")
    WebElement feMaleRad ;

    @FindBy(id = "cheightmeter")
    WebElement heightTxt ;

    @FindBy(id = "ckg")
    WebElement weightTxt ;

    @FindBy(xpath = "//input[@alt='Calculate']")
    WebElement calculateBtn ;

    @FindBy(xpath = "//div[@class='bigtext']")
    WebElement text ;




    @Override
    public void open() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab() {
       metricTab.click();
    }

    public void fillForm(String age, String gender, String height, String weight) {
        ageTxt.clear();
        ageTxt.sendKeys(age);

        if (gender.equalsIgnoreCase("FeMale"))
            feMaleRad.click();
        else
            maleRad.click();

        heightTxt.clear();
        heightTxt.sendKeys(height);

        weightTxt.clear();
        weightTxt.sendKeys(weight);

        calculateBtn.click();

    }

    public String getResult() {
        return text.getText();
    }
}
