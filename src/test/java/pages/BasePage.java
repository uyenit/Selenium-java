package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = Browser.getDriver();
    }

    public abstract void open();

    public void click(How how, String locator) {
        find(how,locator).click();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void fill(How how, String locator, String withText) {
        driver.findElement(how.buildBy(locator)).clear();
        driver.findElement(how.buildBy(locator)).sendKeys(withText);
    }

    public void fill(By locator, String withText) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(withText);
    }

    public void check(How how, String locator) {
        if(!find(how,locator).isSelected()) {
            click(how,locator);
        }
    }

    public WebElement find(How how, String locator) {
        return driver.findElement(how.buildBy(locator));
    }
}
